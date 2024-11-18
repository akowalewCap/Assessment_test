# API Test Automation Documentation

This project is a Java-based API testing assessment inspired by API Test Cases from [automationexercise.com](https://fakeapi.platzi.com/). Below documentation provides an in-depth guide for the **API Test Automation Framework** used in this project. It includes an overview of the technical solution used in the framework.

## 1. Technical Solution Selection for API Test Automation

### 1.1. Technology Stack

The API test automation framework uses the following technologies:

- **Java**: The programming language chosen for test automation due to its widespread use, robustness, and integration capabilities with various test automation tools.
- **JUnit**: The testing framework for Java used to organize and execute tests. JUnit is used to annotate test methods, handle test lifecycle, and generate reports.
- **RestAssured**: A Java library for testing REST APIs. It simplifies the process of sending HTTP requests, validating responses, and performing assertions.
- **Cucumber**: A tool for Behavior-Driven Development (BDD). It allows writing tests in a human-readable format using Gherkin syntax, which improves collaboration between developers, QA, and business stakeholders.
- **Maven**: A build automation tool that is used to manage dependencies and build the project.
  
### 1.2. API Test Automation Approach

The solution adopts the following approach:

- **Automated API Tests**: The main goal is to automate API endpoint testing. The tests are designed to ensure that APIs function as expected.
- **BDD with Cucumber**: The framework utilizes **Behavior-Driven Development (BDD)** through **Cucumber**. BDD enables writing tests in a human-readable format, using **Gherkin syntax**. This approach encourages collaboration between developers, QA teams, and stakeholders to define clear and understandable test scenarios. 
- **Assertions**: Responses from the API are validated using assertions on status codes, response bodies, headers, and JSON structure.

---

## 2. Architecture of the Test Automation Framework

The architecture of the test automation framework is designed to be modular, scalable, and easy to extend. 

### 2.1. Folder Structure

The folder structure is organized in a way that allows easy maintenance and scalability. It follows the Page Object Model (POM) for separating the test logic and API interaction.

## 3. Design Patterns Adopted

### 3.1. Page Object Model (POM)

The Page Object Model design pattern is used to separate the test logic from the API interaction logic. This makes the code more modular and easier to maintain.

- **Advantages**:
  - **Reusability**: Common actions like sending requests and validating responses are written in separate classes, and can be reused across multiple test cases.
  - **Scalability**: As the number of API endpoints grows, you can easily add new test methods and API interaction logic without changing the structure of existing tests.
  - **Maintainability**: Any change in the API interaction (such as a new endpoint or changed parameter) only requires modification in one place (the API client), not across multiple test scripts.

## 4. Setup and Usage Documentation

### 4.1. Prerequisites

Before setting up the project, make sure you have the following installed:

- **Java**: Ensure that you have **Java 8 or higher** installed.
- **Maven**: Ensure **Maven** is installed to handle dependencies and build the project. 
- **IDE**: You can use any Java IDE (e.g., IntelliJ IDEA, Eclipse) for development and running tests.
- **Git**: You will need **Git** to clone the repository. 
- **Cucumber**: This project uses **Cucumber** for Behavior-Driven Development (BDD) testing.

### 4.2. Viewing Reports

After running the tests, cucumber-test-report.html report is generated. You can view the detailed results of your tests by opening this report in a browser. The report is located in the following directory:
- Reports/cucumber-test-report.html

## 5. Conclusion

This API test automation framework provides a scalable, maintainable, and reusable approach to automating API tests using Java, RestAssured, Cucumber and JUnit. By leveraging design pattern such as Page Object Model, the framework is well-structured and adaptable to future needs. With easy setup steps and clear organization, it ensures that API functionality is thoroughly tested and validated.
