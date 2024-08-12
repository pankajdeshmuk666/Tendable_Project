# Tendable_project

Project Title: Tendable.com

Description: This project automates testing of Tendable Application using the selenium with java , testNG data driven framework design pattern. It leverages TestNG for test execution. I have used data driven framework i have added the way to read data from xml add properties file. I have store the test date inside properties file and read it from there the test file. Designed POM classes as well .All the dependencies are stored inside the pom.xml. Suppose if the script get fail in that case it will captusres the screenshot of the page where it fails.

Key Features:

POM Implementation: Separates page objects (locators and methods) from test cases for improved maintainability. 
TestNG Framework: Utilizes TestNG for test execution. 
Smart Waits: Employs explicit waits for page elements to enhance test reliability. 
Error Handling: By throws default exeption handel. 
Prerequisites:Java Development Kit (JDK) 11.0.18 or later Maven (for dependency management) Selenium WebDriver TestNG Setup:

Clone the repository: git clone Configure project dependencies using Maven. Set up your test environment (browser, drivers, etc.). 
Execution:Compile the project. Run the TestNG suite using the testng.xml file. 
report is generated inside test-output/emailable-report.html . By running the testNg.xml it will run whole suite .

Modify page objects in the Objects package to reflect the application's UI elements. Create test cases in the TestSce package, utilizing methods from page objects. Customize the testng.xml file to define test suites and groups.
