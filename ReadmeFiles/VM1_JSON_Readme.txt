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

mosquitto_sub -t /1234/sensor01/attrs

$ mosquitto_pub -t /1234/sensor01/attrs -m '{"l":4,"t": "31.5"}'

-h = mqtt host to connect to(defaults to localhost)
-t = mqtt topic to subscribe or to publish to
-m = message
-p = mqtt port to connect to

==================================================================================
JSON IoT Agent

-----Installation-----
https://fiware-iotagent-json.readthedocs.io/en/latest/stepbystep/index.html

-----Starting JSON IoT Agent-----
$ cd iotagent-json
$ nohup bin/iotagent-json &> /var/log/iotAgent&

-----Checking JSON IoT Agent-----
$ netstat -ntpl | grep 4041
$ curl http://localhost:4041/iot/about

===================================================================================



