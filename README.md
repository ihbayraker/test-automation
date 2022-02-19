# Getting Started

[![workflow](https://github.com/ihbayraker/test-automation/actions/workflows/run-tests.yml/badge.svg)](https://github.com/ihbayraker/test-automation/actions/runs/1869686019)  [![Netlify](https://api.netlify.com/api/v1/badges/f51c65b7-63f5-4627-911a-9e5b3b1125d5/deploy-status)](https://demo-test-automation-results.netlify.app) [![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

![Calliope](https://app.calliope.pro/assets/Calliope_logo-01389101a575495346f8183f224fc57a250a0e72e7f2b4bb8024f0c544a3497a.png)

[Chrome](https://app.calliope.pro/reports/118650/public/86d8b2c9-d9a3-4627-8bbf-0102951b4ab9) ------ [Firefox](https://app.calliope.pro/reports/118651/public/e18e8c09-6a2f-4f5a-a898-90d13b16d4be) ------ [Edge](https://app.calliope.pro/reports/118652/public/3192488b-b7c3-44d7-a665-5c94a10a220e) ------ [Api](https://app.calliope.pro/reports/118649/public/9cf4c11d-1714-46ff-8c1b-56b73805c565)

- This project uses Selenium with BDD Framework to automate web and api testing
- It's configured to run several web and api tests out of the box.
- The web test are run on [ToolQA](https://demoqa.com) while api tests use [Petstore](https://petstore.swagger.io/).
- To execute the tests in default configuration locally run the command below through command console.
```sh
$ mvn clean test exec:java
```
- After the execution the report of the results should be fired up automatically, but they can be also found in **target/cucumber-html-report** folder.
- The Netlify badge above is linked to a report generated by this project when ran with the default configuration.
- Links under Calliope logo will go to reports of test runs by gitHub workflow.

# Configuration
- Several parameters can be altered via maven commands.
- By default, the tests will be run on **Chrome** browser **headless** and a report wil be generated however all these can be altered with commands shown below.

| Command | Parameters | Description |
| ------ | ------ | ------ |
| mvn clean test | N/A | Mandatory, runs the tests. |
| exec:java | N/A | Optional, Fires up the reports automatically, should  only used in a local environment. |
| Dcucumber.filter.tags=@all | @all, @web, @api @demoqa, @petstore, @elements, @forms, @bookstore, @alertswindows, @user, @pet, @order  | Optional, specify the feature tags to manipulate test scope, By default **@all** is run.  |
| Dcucumber.reporting.skip=false | true,false | Optional, determines if the report generation step is skipped or not, by default its **false**. |
| Dbrowser=chrome | chrome, firefox, opera, edge | Optional, determines the browser  test will be run at, by default its **chrome**. |
| Dheadless=true | true, false | Optional, determines if the browser will be run headless or not, by default its **true**. |

- Based on the information given above if we wanted to execute bookstore tests in a CI/CD pipeline using the firefox browser we should use a command like this.
```sh
$ mvn clean test -Dcucumber.reporting.skip=false -Dcucumber.filter.tags=@bookstore -Dbrowser=firefox
```
# Scenarios
- There are in total 23 scenarios bundled in this project. 18 of them are web tests ran on demoqa while 5 of them are api tests for petstore.
- The scenarios are categorized in a hierarchy, **@all** tag is included in every scenario to run them all in a single command while **@web** and **@api** tags indicate the type of testing the scenarios include. The rest of the tags are module spesific tags.
  
 | Tags | Features | Description |
 | ------ | ------ | ------ |
 | @all, @web, @demoqa, @alertswindows | Alerts.feature, NewMessage.feature, NewTab.feature, NewWindow.feature | Tests the Alerts, Frame & Windows tab on ToolsQA. Scenarios include testing all alerts and browser window buttons.  |
 | @all, @web, @demoqa, @bookstore | BookstoreAddDelete.feature, BookstoreAddLogout.feature, BookstoreDeleteAll.feature, BookstoreLoginFail.feature | Tests the Book Store Application tab on ToolsQA. Scenarios include creating an account via api, login/logout operations and adding/removing books.  |
 | @all, @web, @demoqa, @elements | Buttons.feature, CheckBox.feature, DownloadAndUpload.feature, Links.feature, RadioButton.feature, TextBox.feature, WebTablesAdd.feature, WebTablesDelete.feature, WebTablesUpdate.feature | Tests the Elements tab on ToolsQA. Scenarios include almost every section of this module because elements here are used in every part of the website as such in case of a failure its much easier to debug when they are isolated. |
 | @all, @web, @demoqa, @forms | FillForm.feature | Tests the Forms tab on ToolsQA. Only scenario is filling the entire form. The happy path is enough to conclude that form works for average user. |
 | @all, @api, @petstore, @user | UserCreateUpdate.feature, UserCreateDelete.feature | Tests the user api in petstore. The api is tested for most fundamental operations which are create, update and delete. Some operations are done logged in as api documentation requires. |
 | @all, @api, @petstore, @pet | PetAddDelete.feature, PetAddUpdate.feature | Tests the pet api in petstore. The api is tested for most fundamental operations which are create, update and delete. An image is generated and uploaded for the update scenario. |
 | @all, @api, @petstore, @order | PlaceOrderDelete.feature | Tests the order api in petstore. The api does not allow update operations as such placing an order then deleting it is run in single scenario. A pet is also created with pet api to place an order with. |

# Framework
- The test automation framework in this project is designed to be fully modular as such new scenarios or features can be added or included ones be ignored based on what the user wants to automate.
- For CI/CD GitHub workflows is used the current workflow will trigger 4 executions which are api tests and web tests being run in chrome, firefox and edge browser. Opera is omitted from the workflow because it lacks a headless mode. The results are then imported to calliope.pro.
- Executions are controlled with maven, In test step **TestRunner.java** class is run. This class uses properties defined in **cucumber.properties**. In exec:java step **Main.java** is run which only include a short command to fire up locally generated test report.
- Resources folder holds all the feature files and properties files. **demoqa.properties** holds all element paths used in ToolsQA tests while **petstore.properties** holds all apis used in petstore tests.
- **com.testautomation.utils** package holds the static methods that are called and reused in entire project.
- **com.testautomation.stepdef** package holds the step definitions of all feature files. Any new step definitions should be put in this package.
- **com.testautomation.pojo** package holds the plain objects that are used in api tests.
- **com.testautomation.pageobjects** package holds the page object model for web tests. Each tested module has their own class and interface that holds every method that's called in step definitions.
- **com.testautomation.drivers** package holds the drivers. The **DriverFactory.java** determines the driver based on the configuration put by the user and **DriverManager.java** manages it. All drivers have the same functionality.
- **com.testautomation.api** holds request classes for each api tested in api tests. Each api has their own class and interface that holds every method that is called in step definitions.

# Roadmap
- [x] Driver Manager
- [x] Cucumber BDD Integration
- [x] Page object model
- [x] Properties file Model
- [x] ToolsQA web tests
- [x] Api testing support
- [x] Petstore api tests
- [ ] Safari driver Support
- [ ] Browserstack support
- [ ] Slack Integration
- [ ] Report Mailing support
- [ ] Dynamic scenario execution

# Authors


[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ismail-hakan-bayraker/) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)