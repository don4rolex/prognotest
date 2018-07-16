# Single-Page Application (SPA) that gets the geolocation coordinates of the user and displays weather information from their closest weather station. 

A simple Java EE web application that fetches weather data from geonames.org and displays that on a simple UI.

The application can be deployed on any JAX-RS 2.0 compatible server (~Java EE 7 ). 
Wildfly plugin is added in the pom.xml, so you can easily run it by executing the command below in your terminal:
```
mvn wildfly:run
```
And open `localhost:8080/prognotest` in your browser.

To deploy the application on a different server, simply execute `mvn clean package` in your terminal.

To run integration tests only, execute `mvn clean verify` in your terminal
