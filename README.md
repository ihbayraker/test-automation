# Getting Started

![workflow](https://github.com/ihbayraker/test-automation/actions/workflows/run-tests.yml/badge.svg)

- This project uses Selenium with BDD Framework to automate web and api testing
- It's configured to run several web and api tests out of the box.
- The web test are run on [ToolQA](https://demoqa.com) while api tests use [Petstore](https://petstore.swagger.io/).
- To execute the tests in default configuration locally run the command below through command console.
```sh
$ mvn clean test exec:java
```
- After the execution the report of the results should be fired up automatically, but they can be also found in **target/cucumber-html-report** folder.
# Configuration
- Several parameters can be altered via maven commands.
- By default, the tests will be run on **Chrome** browser **headless** and a report wil be generated however all these can be altered with commands shown below.

| Command | Parameters | Description |
| ------ | ------ | ------ |
| mvn clean test | N/A | Mandatory, runs the tests. |
| exec:java | N/A | Optional, Fires up the reports automatically, should  only used in a local environment. |
| -Dcucumber.filter.tags | @all, @demoqa, @elements, @forms, @bookstore, @alertswindows  | Optional, specify the feature tags to manipulate test scope, By default **@all** is run.  |
| -Dcucumber.reporting.skip | true,false | Optional, determines if the report generation step at the end is skipped or not, by default its **false**. |
| -Dbrowser | chrome, firefox, opera, edge | Optional, determines the browser the test will be run, by default its **chrome**. |
| -Dheadless | true, false | Optional, determines if the browser will be run headless or not, by default its **true**. |

- Based on the information given above if we wanted to execute bookstore tests in a CI/CD pipeline using the firefox browser we should use a command like this.
```sh
$ mvn clean test -Dcucumber.reporting.skip=false -Dcucumber.filter.tags=@bookstore -Dbrowser=firefox
```