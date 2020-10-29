# Spring Boot with ActiveMQ 5
This is a demo project demonstrating Spring Boot with ActiveMQ using Topics.
Here we have the receiver which is listening for messages in a specific topic.

# Configuration
In application.properties file you can see how we set the properties for ActiveMQ.
We are using the default username and password (admin/admin).
In order to use Topics (broadcast) and not Queues (serial) we have to set to TRUE the following property:
```
spring.jms.pub-sub-domain
```
We also set the name of the topic here, using a custom property name (destination.name).

# Receiving messages from topic
In order to receive a message from the topic, we have to annotate our receiver class (Receiver.java) with the @EnableJms annotation. 
Then we can use a function to specify the name of the topic from which we want to receive a message from, using the @JmsListener annotation and passing
as parameter the name of the topic (we have already set it in our application.properties file).
This part is done here:
```
@JmsListener(destination = "${destination.name}")
public void showReceivedMessage(String message) {
	logger.info("Message received: {} ", message);
}
```
and pretty much that is all. 

# Run the application
Open a console window and run the following commands while inside the project folder:
```
mvn clean package
java -jar target/amqReceiver-0.0.1-SNAPSHOT.jar
```

**Keep in mind that you have to start the ActiveMQ first:**
For Windows users:
- Download it and extract it
- Go to <downloaded_folder>/bin/<win_version>
- Run activeqm.bat 

For Linux and Mac:
Follow the manual :)