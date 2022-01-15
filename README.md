# Getting Started
- This project is a Selenium BDD Framework that can be used to automate web browsers.
- It's configured to run a simple showcase out of the box.
- To execute it run **mvn clean verify exec:java -Dexec.mainClass=com.testautomation.TearDown**.
- After the execution the report of the results can be found in **cucumber-html-report** folder.
# Configuration
- There are several configurable files in the project to further customize the execution environment.
- An example **testframework.properties** file is shown below.
```sh
browser=chrome
headless=true
```
- **browser** determines the webdriver thats going to be used currently chrome, firefox, opera and edge is supported.
- **headless** is a boolean value, will determine if the webdriver going to be used headless or not.
- The runner class is **TestRunner.java** in this project.
```sh
plugin = {"json:target/cucumber.json"},
features = {"src/test/resources/features"},
glue = {"com.testautomation.stepdef"},
tags = "@demo"
```