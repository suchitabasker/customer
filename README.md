# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.12/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.12/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.12/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.12/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.12/reference/htmlsingle/#actuator)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans â€“ insights for your project's build](https://scans.gradle.com#gradle)


### H2 Database console
http://localhost:9090/h2-console/
	Username : sa
	password : admin

### Login into security
1) Get the access token 
Post: http://localhost:9090/security/authenticate
{
    "username": "basker",
    "password": "password"
}

2) pass the access token with bearer in the header Authorization parameter.
http://localhost:9090/orders/1
sample: 
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdWNoaXRhIiwiZXhwIjoxNjg3MjM2MzgwLCJpYXQiOjE2ODcyMzYyODAsImp0aSI6ImViYmI1N2MwLWE4MjItNGRjMy04NjNiLWI0ZDkzNTZiMzFjYiJ9.gV9-r22TJINL5mHkbZg1Uc4bRNEe_gSZBkJqAmrQtEA


### Docker
* Create the images
 	dkr build -t customer:1.0 .
* Start the container
	 dkr run -d -p 9090:9090 customer:1.0
* Access the API
	http://localhost:9090/orders/1
