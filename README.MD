# Read Me First
The following was discovered as part of building this project:

* The project works with Java11, Google appengine, Google datastore, Spring data,Spring boot.

Reach out me for any furuther doubts: <mail@saifali.in> 

<https://www.linkedin.com/in/saif40>

# Getting Started

## Basic Project setup.
Its an template project you can check the project for basic setup for the Java11, spring boot, Spring data and google datastore.


Add the following to your `build.gradle`

```
plugins {
	id 'org.springframework.boot' version '2.4.3'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
	id 'org.springframework.experimental.aot' version '0.9.0'
}
```
```
ext {
	set('springCloudGcpVersion', "2.0.0")
	set('springCloudVersion', "2020.0.1")
}
```
```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'com.google.cloud:spring-cloud-gcp-starter'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	implementation group: 'org.springframework.cloud', name: 'spring-cloud-gcp-starter-data-datastore', version: '1.2.7.RELEASE'

}
```
```
dependencyManagement {
	imports {
		mavenBom "com.google.cloud:spring-cloud-gcp-dependencies:${springCloudGcpVersion}"
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}
```
you can find the complete `build.gradle` in project gradle setup. 

`implementation group: 'org.springframework.cloud', name: 'spring-cloud-gcp-starter-data-datastore', version: '1.2.7.RELEASE'`

this dependency will help you to use the spring data with google datastore.


## Appengine Requirements
create and app.yml file inside `src/main/appengine` below will be sharing a example and you update your preferences.

```
runtime: java11
env: standard
service: testservice
instance_class: F2
runtime_config:
  jdk: openjdk11
env_variables:
  SPRING_PROFILES_ACTIVE: "dev"
handlers:
  - url: /.*
    script: this field is required, but ignored
manual_scaling:
  instances: 1
```

## Controller, Entities, Repositories

As all you know more about the *controller* i'm not explaining about that more here. but if you are accessing the repository directly from the controller, use `@Autowired` example shown below.

```
@Autowired
BookRepository repository;
```
Spring datarepository is the best thing when i worked in Spring so far, all your queries and saving all made super easy, you can save lot of time by using spring data repositoory. you can find the repository inside the project and the example below.

```
import com.scheduling.j11.entities.Books;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import java.util.List;


public interface BookRepository extends DatastoreRepository<Books, String> {
    List<Books> findByBrand(String brand);
    List<Books> findByBrandAndMerchantId(String brand, String merchantId);
    List<Books> findByMerchantId(String merchantId);
}
```

Entity can be as same as jpa or objectify all you need to add the `@Entity` ( `import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;` )

and for `Id` use `@Id`(`import org.springframework.data.annotation.Id`);


## Properties files
add the following to the project
```
spring.cloud.gcp.datastore.enabled=true
spring.cloud.gcp.datastore.project-id=bookshop
spring.main.allow-bean-definition-overriding=true
```
and if you want to add new namespae
```
spring.cloud.gcp.datastore.namespace=new_namespace
```

## Deploying is little different now.

if you haven't set up the gcloud follow the [link](https://cloud.google.com/deployment-manager/docs/step-by-step-guide/installation-and-setup#install) and update


you have to create jar before using the deploying 
so once you done with the changes you have to create the build jar using 
```bash
$ ./gradlew clean build
```
 and the build will be ready.

one the build is ready you can deploy using 
```bash
$ gcloud app deploy
```



### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [GCP Support](https://cloud.spring.io/spring-cloud-gcp/reference/html/)
* [GCP Storage](https://cloud.spring.io/spring-cloud-gcp/reference/html/#spring-resources)
* [GCP Messaging](https://cloud.spring.io/spring-cloud-gcp/reference/html/#spring-integration)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [GCP Samples](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/master/spring-cloud-gcp-samples)
* [GCP Storage](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/master/spring-cloud-gcp-samples/spring-cloud-gcp-storage-resource-sample)
* [GCP Pub/Sub Sample](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/master/spring-cloud-gcp-samples/spring-cloud-gcp-pubsub-sample)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.9.0/reference/htmlsingle/#spring-aot-gradle)

