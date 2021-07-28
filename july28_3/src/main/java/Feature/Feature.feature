Feature: Flipkart login feature

Scenario: Flipkart login test Scenario
Given User is already on login page
When title of the page is Flipkart
Then user enters username and password
|username|password|
|9894506053|Msft@2020|
Then user clicks on login button
Then user is on Home page
Then user closes the browser
