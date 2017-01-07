# allocations
Develop Allocations using spring boot, spring integration, gradle

Note to run alternative main class from spring boot main jar is
------------------------------------------------------------------------------------------------------
java -cp allocations-0.0.1-SNAPSHOT.jar -Dloader.main=alloc.controller.AllocationsControllerApplication  org.springframework.boot.loader.PropertiesLauncher
