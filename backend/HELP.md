# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


gradlew clean build
gradlew build
gradlew bootRun
UF_pTwKKCjLWTLZNMcV0x-3VVKZ135g5NpGUIVGOca-yLBczO18rQqr54S5PoUpIBL0rTrUcccsAmSBAjsHVug==

export INFLUXDB_TOKEN=NYfVcZLzT9rgxFjXR-Kbyzm9styDzA8gGXzrfFa6vfYMfA2I2pyqAK-Lzw6WGujpidjsKmCIrp-5rHLgw2BlrA==

SELECT *
FROM 'census'
WHERE time >= now() - interval '1 hour'
AND ('bees' IS NOT NULL OR 'ants' IS NOT NULL) order by time asc

String sql = "SELECT * " +
        "FROM 'census' " +
        "WHERE time >= now() - interval '1 hour' " +
        "AND ('bees' IS NOT NULL OR 'ants' IS NOT NULL) order by time asc";

System.out.printf("| %-5s | %-5s | %-8s | %-30s |%n", "ants", "bees", "location", "time");
try (Stream<Object[]> stream = client.query(sql, new QueryOptions("temperatureSensor", QueryType.SQL))) {
    stream.forEach(row -> System.out.printf("| %-5s | %-5s | %-8s | %-30s |%n",  row[0], row[1], row[2], row[3]));
}
