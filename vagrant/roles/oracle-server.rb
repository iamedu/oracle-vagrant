name "oracle-server"
description "Install Oracle server"

run_list(
	"recipe[oracle-xe]"
)


override_attributes "oraclexe" => {
	"password" => "password",
	"mirror" => "http://dl.dropbox.com/u/4586016/oracle-xe_11.2.0-2_amd64.deb"
}
