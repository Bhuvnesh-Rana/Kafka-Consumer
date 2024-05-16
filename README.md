# Kafka consumer read me.

1. Install kafka.
2. Check java version. (Kafka requires java version above 8 to run, check kafka documentaion for more information.)
3. Open kafka folder and open cmd in that folder.
4. In cmd prompt write the following command to run zookeeper.
5. bin\windows\zookeeper-server-start.bat config\zookeeper.properties
6. Open another cmd prompt in same kafka folder and run the following command to run kafka.
7. bin\windows\kafka-server-start.bat config\server.properties
8. After running both zookeeper and kafka, run the Kafka-Producer and Kafka-Consumer projects.(Both projects are present separately as repositories.)
9. Run both Kafka-Producer project and Kafka-Consumer project as spring boot projects one by one.
10. Open postmann app and send valid JSON.
11. The producer will produce message and then the consumer will consume the message.
    
    

