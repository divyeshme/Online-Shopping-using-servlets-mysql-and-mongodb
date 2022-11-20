How to run SmartPortables

1. Download and install Tomcat v9.0
2. Download and install MySQL v8.0
3. Download and install MongoDB v3.4
4. Download and unzip the assignment
5. Copy the SmartPortables folder into Tomcat9.0\webapps
6. Ensure to change the MySQL username and password in WEB-INF\classes\MySqlDataStoreUtilities.java
7. Ensure to change the Mongodb Database name and collection in WEB-INF\classes\MongoDBDataStoreUtilities.java (Collection will be created automatically once you will write a review so just create database)
8. Open command prompt and cd to tomcat\bin and execute startup.bat
9. Visit http://localhost:8080/SmartPortables in your browser