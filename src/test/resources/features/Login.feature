 Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
#When User enteres valid email address "supriyaanikivi234@gmail.com" into email field
When User enteres valid email address <username> into email field
#And User has entered valid password "supriya123*" into password field
And User has entered valid password <password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|username								|password	|
|amotooricap1@gmail.com	|12345		|
|amotooricap2@gmail.com	|12345		|
|amotooricap3@gmail.com	|12345		|

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enteres invalid email address into email field
And User enters invalid password "ad34577" into password field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch


Scenario: Login with valid email and invalid password 
Given User has navigated to login page
When User enteres valid email address "supriyaanikivi234@gmail.com" into email field
And User enters invalid password "ad34577" into password field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch


Scenario: Login with invalid email and valid password 
Given User has navigated to login page
When User enteres invalid email address into email field
And User has entered valid password "supriya123*" into password field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch


Scenario: Login without providing any credentials
Given User has navigated to login page
When User do not enter email address into email field
And  User do not enter password into password field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch