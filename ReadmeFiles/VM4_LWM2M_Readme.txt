=================================================================================
Orion Context Broker:

-----Installation-----
Building from sources
https://fiware-orion.readthedocs.io/en/master/admin/build_source/index.html

-----Starting Orion Context Broker-----
$ contextBroker

-----Orion Context Broker Sanity Checks-----
End to end testing:
$ curl --header 'Accept: application/json' localhost:1026/version
List of running proccesses:
$ ps ax | grep contextBroker
$ netstat -ntpl

==================================================================================
Lightweight M2M IoT Agent

-----Installation-----
https://fiware-iotagent-lwm2m.readthedocs.io/en/latest/deviceProvisioning/index.html

-----Starting Lightweight M2M IoT Agent-----
$ cd lightweightm2m-iotagent
$ bin/lwm2mAgent.js examples/config-factory.js

-----Starting Lightweight M2M IoT Client-----
	In different terminal
$ cd lwm2m-node-lib
$ bin/iotagent-lwm2m-client.js

-----Lightweight M2M IoT Agent Config File-----
$ sudo nano /lightweightm2m-iotagent/config.js

-----Checking Lightweight M2M IoT Agent-----
$ netstat -ntpl | grep 4041
$ netstat -nupl | grep 60001
$ curl http://localhost:4041/iot/about

===================================================================================
