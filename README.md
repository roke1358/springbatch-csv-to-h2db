# springbatch-csv-to-h2db

compile:
mvn clean install -DskipTests

run:
mvn spring-boot:run

browser:
http://localhost:8089/load

to check h2 db:
http://localhost:8089/h2-console

h2 db parameters:
settings: generic h2 embedded
jdbc url: jdbc:h2:mem:testdb
driver: org.h2.Driver


to generate csv file:
https://mockaroo.com/

id, row number |
firstName, First Name |
lastName, Last Name |
dept, Number min=1, max=4,  fx('00' + this.to_s) |
salary, number
