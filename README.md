# Getting Started
- This project is a Selenium BDD Framework that can be used to automate web browsers.
- It's configured to run a simple showcase out of the box.
- To execute in default configuration run following in command line.
```sh
mvn clean test exec:java
```
- After the execution the report of the results will be fired up automatically but they can be also found in **cucumber-html-report** folder.
# Configuration
- There are several configurable files in the project to further customize the execution environment.
- An example **testframework.properties** file is shown below.
```sh
browser=chrome
headless=true
```
- **browser** determines the webdriver thats going to be used currently chrome, firefox, opera and edge is supported.
- **headless** is a boolean value, will determine if the webdriver going to be used headless or not.
- The runner class is **TestRunner.java** which is shown below.
```sh
plugin = {"json:target/cucumber.json"},
features = {"src/test/resources/features"},
glue = {"com.testautomation.stepdef"},
tags = "@demo"
```
- By default, all scenarios with the tag @demo will be run however this can be altered by changing the **Dcucumber.filter.tags** property.
- If we wanted to exclude scenarios with the tag @pass2 we could use the following command.
```sh
mvn clean test exec:java "-Dcucumber.filter.tags=@demo and not @pass2"
```
- The report generation can be disabled by setting the **cucumber.reporting.skip** property as false.
- The command shown below will not prevent the generation of cucumber.json.
```sh
mvn clean test exec:java -Dcucumber.reporting.skip=true
```