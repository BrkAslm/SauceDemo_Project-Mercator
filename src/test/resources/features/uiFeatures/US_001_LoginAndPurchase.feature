Feature: US_001 Login And Purchase

  Background: user login
    Given user goes to login page
    And user login with the username and password "standard_user" and "secret_sauce"

  @UI
  @smoke
  @login
  Scenario: user selects the most expensive item and checkout succesfully
    When user selects the highest priced item on the inventory page
    When user clicks on the basket icon to go to the basket page
    Then user is able to be on the basket page
    And user able to see product has been added to cart
    When user clicks on the check out button
    Then user is able to be on the checkout page
    When user enters the firstname as "burak" , lastname as "aslim", and postalcode as "123456"
    Then user is able to see the firstname as "burak" , lastname as "aslim", and postalcode as "123456"
    When user clicks on continue button
    Then user is able to be on the overview page
    And  user is able to see prices of the items
    When user clicks on finish button
    Then user is able to see the "Thank you for your order!" message

  @UI
  @smoke
  @login
  Scenario: user checks the selected items' names and prices are same in the cart page
    When user selects items on the inventory page
    When user clicks on the basket icon to go to the basket page
    Then user is able to see items' names and totals are equal on the cart

