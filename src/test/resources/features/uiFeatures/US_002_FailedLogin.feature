Feature: US_002 Failed Login

  @UI
  Scenario: User going to the main page by using the page url
    Given user goes to login page
    Given user login with the username and password "standard_user" and "secret_password"
    Given assertion for unsuccesful login
