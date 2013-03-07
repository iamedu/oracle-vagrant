name "oracle-server"
description "Install Oracle server"

run_list(
	"recipe[oracle]"
)


override_attributes "sysctl" => {
	"is_oracle" => true
},
	"oracle" => {
	"dbas" => ["vagrant"],
	"version" => 11,
	"processes" => 512
}
