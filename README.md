Planner
As part of the Learn IT Girl I was developping a Java desktop application. I used Java 8. 
The application is a planner of day by day tasks and important events. The Planner offers a calendar like interface, where users can view tasks for each day and also create tasks. 
Planner uses also the MySQL database. The lists of the users and the tasks are keeping in the database. 

The planner offers the following functionalities:
- monthly view of the calendar,
- creating one time or recurring events (repeatable monthly and yearly),
- 15 minutes, 10 minutes, “starting now” reminders for tasks.
The planner will help you organize your time and your family's time.

 Instructions on how to set up the database for the Planner (for Windows):
- you need to download the MySQL Installer from: https://dev.mysql.com/downloads/installer/
- you need to install MySQL Server, MySQL Connector/J and MySQL Workbench. During the installation, program can ask you to download additional packages.
- do not forget to add the JAR archive named mysql-connector-java-version-bin.jar to the build path (COPY the JAR file "mysql-connector-java-5.1.{xx}-bin.jar" to your JDK's Extension Directory at "<JAVA_HOME>\jre\lib\ext" (where <JAVA_HOME> is the JDK installed directory), e.g., "c:\program files\java\jdk1.8.0_{xx}\jre\lib\ext"). 

The database needs to have 2 tables: users and tasks. 
To create the database and the tables, you need to use the queries:

1. Database "planner":
CREATE DATABASE planner;

2. Table"users": 
CREATE TABLE users (
    ID int NOT NULL AUTO_INCREMENT,
    firstName varchar(50) NOT NULL,
    surname	varchar(50) NOT NULL,
	PRIMARY KEY (ID)
);

3. Table "tasks":
CREATE TABLE tasks (
    taskID int NOT NULL AUTO_INCREMENT,
    nameTask varchar(50) NOT NULL,
	descriptionTask varchar(100) NOT NULL,
	DATETIME startTime NOT NULL,
	DATETIME endTime NOT NULL,
	assignedTo int NOT NULL,
    PRIMARY KEY (taskID),
    FOREIGN KEY (assignedTo) REFERENCES users(ID)
);

And then you have to remember to edit the classes TaskDao and UserDao to add your own connection credentials needed to connect to the database.
