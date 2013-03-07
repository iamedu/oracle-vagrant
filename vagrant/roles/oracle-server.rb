name "oracle-server"
description "Install Oracle server"

run_list(
	"recipe[oracle]",
	"recipe[oracle-xe]"
)


override_attributes "sysctl" => {
	"is_oracle" => true
}, "oracle" => {
	"dbas" => ["vagrant"],
	"version" => 11,
	"processes" => 512
}, "oraclexe" => {
	"password" => "password"
}
