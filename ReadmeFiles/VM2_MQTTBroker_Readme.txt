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