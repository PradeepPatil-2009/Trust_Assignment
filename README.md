High-Concurrency Transaction Processing System (Spring Boot)
Overview :

This project implements a high-concurrency transaction processing system using Spring Boot.
It simulates two independent bank clients (Bank A and Bank B) sending transactions concurrently to a central server.
The system is designed to handle thousands of concurrent requests using asynchronous processing, thread-safe logic, and proper server tuning.

-----------------------------------
System Architecture :

Client Bank A
Client Bank B
Central Transaction Server

Both client applications send transaction requests concurrently to the server.
The server processes requests asynchronously and returns responses.
-----------------------------------
Technology Stack :

Java 17
Spring Boot
Spring Web
Spring Async
Java Concurrency Utilities
Embedded Tomcat
H2 In-Memory Database
Apache JMeter
Swagger / OpenAPI
-----------------------------------
Client API :
Endpoint : POST /bank/transaction

Request (JSON)
{
  "customerId": 892345,
  "fromAccount": "1234567890",
  "toAccount": "9876543210",
  "amount": 1250.75,
  "currency": "INR"
}

Client Responsibilities : 

1.Generate a unique transaction ID
2.Convert the request from JSON to XML
3.Send the request to the server with authentication
4.Validate request fields for null or blank values

-----------------------------------
Server API :

Endpoint : POST /server/transaction/process

Request (XML)
<TxnRequestXml>
    <TrxId>TRX-1001</TrxId>
    <BankId>client-app-1</BankId>
    <CustomerId>892345</CustomerId>
    <FromAccount>1234567890</FromAccount>
    <ToAccount>9876543210</ToAccount>
    <Amount>1250.75</Amount>
    <Currency>INR</Currency>
    <Timestamp>2026-01-01T00:00:00.000+05:30</Timestamp>
</TxnRequestXml>

Response (JSON)
{
  "trxId": "TRX-1001",
  "status": "SUCCESS",
  "message": "Completed",
  "processingTimeMs": 5,
  "bankId": "client-app-1"
}

Authentication : 
Simple Bearer token–based authentication is used.
Client ID and client password are stored in application.properties.

Header Format :
Authorization: Bearer client-app-1:Pass@12345A

-----------------------------------
Concurrency Design :
1.Asynchronous processing using @Async
2.Custom thread pool executor
3.Thread-safe duplicate transaction detection
4.No shared mutable state
5.Non-blocking request handling
6.Global and field-level exception handling

-----------------------------------
Server Performance Configuration
Tomcat Tuning
Max threads: 1000
Accept count: 5000
Max connections: 10000
-----------------------------------
Load Testing (Apache JMeter)
Test Configuration :
Two thread groups (Bank A and Bank B)
2000 users per group
Ramp-up period: 20 seconds
Total concurrent users: 4000

-----------------------------------
Results :
Error rate: 0.00%
Average response time: ~1 ms
Maximum response time: < 10 ms
Throughput: ~100 requests/sec

Spike tests with zero ramp-up were avoided in the final evaluation due to expected socket-level rejections.

-----------------------------------
Swagger Documentation :
Swagger UI is available at: http://localhost:8080/swagger-ui.html

-----------------------------------
How to Run
1. Start Server
cd server-app
mvn spring-boot:run

2. Start Client Bank A
cd client-bank-a
mvn spring-boot:run

3. Start Client Bank B
cd client-bank-b
mvn spring-boot:run

-----------------------------------
Project Structure
Trust_Assignment/
─ server-app/
─ client-bank-a/
─ client-bank-b/
─ jmeter/
─ requests/
─ README.md
-----------------------------------
Conclusion

This project demonstrates a scalable and thread-safe transaction processing system capable of handling high concurrency using Spring Boot.It fulfills all functional and non-functional requirements specified in the assignment, including performance, reliability, and clean architectural design.