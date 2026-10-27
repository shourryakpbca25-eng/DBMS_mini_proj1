@echo off
mvn clean package
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass="com.inventory.InventoryManagementApp"
pause
