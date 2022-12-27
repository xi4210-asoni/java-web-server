# java-web-server

This application is a postgres database connection tester.

## Working
You pass the database connection string as an environment variable. 
Example: `CONN="jdbc:postgresql://localhost:5432/postgres?user=postgres&password=mysecretpassword"`

If database connection is successfull, you will see a green screen
![image](https://user-images.githubusercontent.com/93035155/209615779-0726e0f7-4448-4192-bd61-19da5e8664cd.png)

If database connection failed, you will see a red screen
![image](https://user-images.githubusercontent.com/93035155/209615831-7add4b33-0b50-4889-a7cd-963d991b8215.png)

## Metrics endpoint
This applicatoin exposes metrics at the following endpoint `/actuator/prometheus`
![image](https://user-images.githubusercontent.com/93035155/209643771-9c964c8f-ad82-4cf0-ab88-298bb9341c01.png)


## Running the application
- Directly running on the terminal
`./mvnw spring-boot:run`

- Building the java app to generate .jar file
`./mvnw clean package`

- Running app using .jar file
`java -jar target/rest-service-complete-0.0.1-SNAPSHOT.jar`
