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
Mosquitto MQTT Broker:

-----Installation-----
https://www.digitalocean.com/community/tutorials/how-to-install-and-secure-the-mosquitto-mqtt-messaging-broker-on-centos-7

-----Starting Mosquitto MQTT Broker-----
$ sudo systemctl start mosquitto

-----Mosquitto MQTT Broker Config File-----
$ sudo nano /etc/mosquitto/mosquitto.conf

-----Mosquitto MQTT Broker sub and pub----
$ mosquitto_sub -h localhost -t test

$ mosquitto_pub -h localhost -t test -m "hello world"

$ mosquitto_sub -t /ul/ABCDEF/id_sen1/attrs

$ mosquitto_pub -t /ul/ABCDEF/id_sen1/attrs -m 'h|70|t|15' -h <mosquitto_broker> -p <mosquitto_port> -u <user> -P <password>

-h = mqtt host to connect to(defaults to localhost)
-t = mqtt topic to subscribe or to publish to
-m = message
-p = mqtt port to connect to

==================================================================================
UL IoT Agent

-----Installation-----
https://fiware-iotagent-ul.readthedocs.io/en/stable/installationguide/index.html

-----Starting UL IoT Agent-----
$ cd iotagent-ul
$ bin/iotagent-ul

-----UL IoT Agent Config File-----

$ sudo nano /iotagent-ul/config.js


-----Checking UL IoT Agent-----
$ netstat -ntpl | grep 4041
$ curl http://localhost:4041/iot/about

==================================================================================


