@tag
Feature: Purchase the order from Ecommerce website

//pre-requisite can be written for all the tests 
Background:
Given I Landed on Ecommerce Page
@tag2
Scenario Outline: Positive Test of submitting the Order
Given Logged in with username and password
When i add product to Cart
And Checkout product and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

Examples:
|name						|password	|productName|
|shakelliambica@gmail.com	|Ambica@123	|ZARA COAT 3|

