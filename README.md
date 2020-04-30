## How to build
`./gradlew clean build`

## For Intellij idea users
*This project needs enabled annotation processor cause of lombok dependency

## How to run/test
Run `./tools/test_cli` and check for the available commands

## How to load
`./tools/load/loader.sh pre_load` for client loading and simple instructions. <br>
It start loader, e.g.:`./tools/test_cli load 100 10s` - 100 connections during 10s <br>
[Source code](https://github.com/obscurecore/rx-benchmark "rx-loader").

## Additional instructions
At first you need create environment by running `./tools/test_cli env`,<br>
Then fill mongo  `./tools/test_cli mongo_fill` 

##execution example
* `./tools/test_cli env_start`
* `./tools/test_cli mongo_fill`
* `./tools/load/loader.sh pre_load`
* run `./tools/test_cli clean_boot`
* `./tools/test_cli load 100 10s`

History evolution :
* step0 or sync
* step1 or async_servlet
* step2 or mono_first_try
* step3 or schedulers
* step4 or async_client
* step5 or reactive_mongo
* step6
