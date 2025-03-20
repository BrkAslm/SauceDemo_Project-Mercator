SauceDemo Automated Test Framework

Overview
This project is an automated test framework for SauceDemo built using Selenium WebDriver, 
Cucumber BDD, and JUnit. 
It covers key test scenarios such as login, selecting the highest-priced item, 
adding items to the cart, and verifying cart functionality.

Technologies Used

Java (JDK 19)
Selenium WebDriver (v4.17.0)
Cucumber BDD (v7.3.2)
JUnit (v5)
WebDriverManager (v5.7.0)
Maven (for dependency management)
Project Structure

SauceDemo_Project
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages       # Page Object Model (POM) classes
│   │   │   ├── utilities   # Reusable utilities and helper methods
│   ├── test
│   │   ├── java
│   │   │   ├── stepDefinitions  # Cucumber step definitions
│   │   │   ├── runners          # Cucumber test runners
│   │   │   ├── features         # Feature files (Gherkin syntax)
│── pom.xml (Maven dependencies)
│── README.md (Project documentation)
│── test-output (Generated test reports)
How to Run the Tests

1. Clone the Repository
   git clone <repository-url>
   cd SauceDemo_Project
2. Install Dependencies
   Ensure that Maven and Java 19 are installed on your system. Then, install dependencies:

mvn clean install
3. Execute Tests
   To run all Cucumber scenarios:

mvn test
4. Generate Reports
   After test execution, Cucumber reports will be generated in:

HTML Report: target/reports/html/saucedemo_reports.html
JSON Report: target/reports/json/json-reports/cucumber.json
JUnit XML Report: target/reports/xml/xml-report/cucumber.xml

Test Scenarios Covered

✔️ Successful login with valid credentials
✔️ Unsuccessful login attempt with invalid credentials
✔️ Selecting the highest-priced item on the inventory page
✔️ Adding an item to the cart
✔️ Verifying items in the cart

Contributors

Burak Aslim
License

This project is for testing purposes only and follows open-source guidelines.