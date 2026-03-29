# Saucedemo E2E Test Automation Project

This project contains end-to-end automated tests for the Saucedemo e-commerce website using Selenium WebDriver, Cucumber BDD, and TestNG.

## Tech Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **BDD Framework:** Cucumber
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Reporting:** Allure Reports

## Design Patterns & Principles
* **Page Object Model (POM):** To enhance test maintainability and reduce code duplication.
* **Page Factory:** Utilized `@FindBy` annotations for cleaner and more efficient element location.
* **Singleton Pattern:** Implemented in `DriverManager` to ensure a single WebDriver instance per thread.
* **Dry Principle:** Reusable methods and centralized configurations to keep the code clean.


## Prerequisites
* Java JDK installed and configured in system path.
* Apache Maven installed and configured.

## Execution Instructions

You can run the tests using Maven from the terminal/command line. Navigate to the project root directory before executing this command.

**Run All Tests**
`mvn clean test`

## Report Instructions

**Allure Report**
To generate and view the interactive Allure report, run the following command after the test execution is complete:
`mvn allure:serve`
*(Make sure tests have finished running before executing this command).*

