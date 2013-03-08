#
# Cookbook Name:: oraclexe
# Recipe:: default
#
# Copyright 2012, Lucasian
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

default["oraclexe"]["mirror"] = "http://dl.dropbox.com/u/4586016/oracle-xe_11.2.0-2_amd64.deb"
default["oraclexe"]["listener_port"] = "1521"
default["oraclexe"]["http_port"] = "8080"
default["oraclexe"]["password"] = "password"
default["oraclexe"]["db_enable"] = "y"

