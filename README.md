# Welcome to Project Dream
Lets get you up and running.

## General Requirements

You'll need following

* Latest Eclipse EE
* Latest Maven
* GIT/GITHub
* Postgres 9.3.4.2
* Tomcat 7

## Steps
* Setup Eclipse
* Download Postgres 9.3.4.2 (there is a UI for it if necessary)
** Startup the database server and change the hibernate.cfg.xml file with your own stuff
```
<property name="connection.url">jdbc:postgresql://127.0.0.1:5432/core</property>
<property name="connection.username">kamlesh</property>
<property name="connection.password"></property>
```

* Clone "development" branch to your local drive
* Import it as a maven project (This will download all the necessary dependencies for Spring, Hibernate and Db Drivers
* Right Click on the project and Run-As --> Run on Server
* Tada! View your deployed app @ http://localhost:8080/core/ 

### Frameworks used
* Annotations based Spring MVC and hibernate
* Bootstrap css and js for UI
* JQuery
* ....


