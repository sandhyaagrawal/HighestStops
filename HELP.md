# About application
This application will call the Trafik Lab's public API using a KEY to find out which bus line number has the most bus stops on their route,

This application is built upon Spring Boot with Restfull services. The application has a controller which will call the service class method. The Service class method will call the Trafik Lab API which returns Json object. The Json object will then be converted into Java Object. 

## Relationship between Bus Line and Stop Point
Each Bus Line number have multiple entries for its respective JourneyPatternPointNumber(stop point). 
So the Bus Line Number which has the highest number of count will have the most stop points on its route.

## Prerequisites
- Java 8
- Maven > 3.0

## Build and run
 #### Instructions to build the application:

  	-mvn clean install

Once the build run successfully,you’ll get a jar. This jar is handy because it includes all the other dependencies and things like your web server inside the archive.

  #### Run the application:
  You can use the .jar file created inside target folder to run the application
	
	-$ java -jar target/route-1.0.0-SNAPSHOT.jar

When you run your application, Spring Boot will detect that you have a Spring MVC controller and start up an embedded Apache Tomcat 8 instance, by default. Please note that currently application is using port 8080. But if the Port 8080 is not available then change the port number in side application.properties file and use new port number in the URL instead of 8080. 

  #### Application Endpoint:
[Get Bus Lines and Stop Names] (http://localhost:8080/getBusLineWithHighestStops)


## Key detail
This application is using *Key=29240f5332544957908632ae965b237d* to access the Trafik lab APIs

## Trafik Lab API called
- This application will call a public API from Trafik Lab
	- [API] (https://api.sl.se/api2/linedata.json?key=29240f5332544957908632ae965b237d&model=jour&DefaultTransportModeCode=BUS)


