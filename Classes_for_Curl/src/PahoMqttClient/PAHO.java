package PahoMqttClient;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class PAHO {

    public void PahoMqttClient(){
        /**
         * topic = api_key + device_id + attrs
         */
        String topic = "/1234/sensor33333/attrs";
        String content = "{\"l\":10,\"t\": \"55.62\"}";
        int qos = 2;
        /**
         * PAHO Client works on port 1883
         */
        String broker = "tcp://192.168.0.104:1883";
        String clientId = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            /**
             * Connecting to the broker
             */
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+ broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");

            /**
             * publishing message
             */
            System.out.println("Publishing message: "+ content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");

            /**
             * subscribing for topic
             */
            sampleClient.subscribe(topic);
            System.out.println("Subscribed to topic: "+topic);
            System.out.println("Received data: "+content);

            /**
             * disconnecting
             */
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);

        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}

