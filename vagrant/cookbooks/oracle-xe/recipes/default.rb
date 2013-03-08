remote_file "/tmp/oracle-xe_11.2.0-2_amd64.deb" do
	source "#{node["oraclexe"]["mirror"]}"
	mode "0644"
	checksum "85c07ceff97a1bbd968a92c37d835f51cabf6635419a9c3d0e068b96f20b3b02" # A SHA256 (or portion thereof) of the file.
end

unless File.exists? "/etc/rc2.d/S01shm_load"
	execute "load ram" do
		command "rm -rf /dev/shm;  mkdir /dev/shm; mount -t tmpfs shmfs -o size=2048m /dev/shm"
		action :run
	end
end

template "/etc/rc2.d/S01shm_load" do
	source "shm_load.erb"
	owner "root"
	mode "0755"
end

template "/tmp/xe.rsp" do
	source "xe.rsp.erb"
	owner "root"
	mode "0755"
end

template "/sbin/chkconfig" do
	source "chkconfig.erb"
	owner "root"
	mode "0755"
end

template "/etc/sysctl.d/60-oracle.conf" do
	source "60-oracle.conf.erb"
	owner "root"
	mode "0644"
end

template "/etc/profile.d/oracle-env.sh" do
	source "oracle-env.sh.erb"
	owner "root"
	mode "0755"
end

apt_package "alien" do
	action :install
	options "--force-yes"
end

apt_package "libaio1" do
	action :install
	options "--force-yes"
end

apt_package "unixodbc" do
	action :install
	options "--force-yes"
end

apt_package "vim" do
	action :install
	options "--force-yes"
end

apt_package "bc" do
	action :install
	options "--force-yes"
end

dpkg_package "oracle" do
	action :install
	source "/tmp/oracle-xe_11.2.0-2_amd64.deb"
end

unless File.exists? "/etc/oracle-installed"

	execute "configure oracle" do
		command "/etc/init.d/oracle-xe configure responseFile=/tmp/xe.rsp"
		action :run
	end

	file "/etc/oracle-installed" do
		action :create
	end

end

service "oracle-xe" do
	supports "status" => true, "restart" => true, "reload" => true
	action [ "enable", "start"]
end

