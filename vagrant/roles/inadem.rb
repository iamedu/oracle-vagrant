name "inadem"
description "INADEM"

run_list(
	"recipe[java]",
	"recipe[glassfish]"
)

override_attributes "java" => {
	"oracle" => {
	  "accept_oracle_download_terms" => true
	},
	"install_flavor" => "oracle"
}
