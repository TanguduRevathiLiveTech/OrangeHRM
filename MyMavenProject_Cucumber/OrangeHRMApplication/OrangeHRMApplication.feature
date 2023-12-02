Feature: OrangeHRM Application Functionality Testing
Scenario: OrangeHRM Application Login Page validation

Given User should be open a chrome browser in the system
When User enter a url address of OrangeHrm Application
Then User should be navigated to OrangeHRM Application login page
Then  User should be close the OrangeHRM application Along with the browser

Given User should be open a chrome browser in the system
When User enters a url address of OrangeHrm Application
Then User should be navigated to OrangeHRM Application login page
Then User should enter UserName and Password and click on login button
Then User should be navigated to OrangeHRM Application HomePage
Then User should click on WelCome Admin and click on LogOut
Then  User should be close the OrangeHRM application Along with the browser
