Feature: User Login Functionality

  Scenario: Validate the presence and functionality of the login button
    Given I am on the e-commerce website login page
    Then I should see the login button
    And the login button should be clickable

  Scenario: Successful login with valid credentials
    Given I am on the e-commerce website login page
    When I enter valid credentials
    And I click the login button
    Then I should be redirected to my account dashboard
    And I should see a welcome message

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the e-commerce website login page
    When I enter invalid credentials
    And I click the login button
    Then I should see an error message indicating invalid credentials

  Scenario: Login button is disabled when input fields are empty
    Given I am on the e-commerce website login page
    When I leave the username and password fields empty
    Then the login button should be disabled

  Scenario: Successful logout after logging in
    Given I am logged in to my account
    When I click the logout button
    Then I should be redirected to the login page
    And I should see a confirmation message indicating I have logged out

  Scenario: Unsuccessful login with an unregistered email address
    Given I am on the e-commerce website login page
    When I enter an unregistered email address
    And I click the login button
    Then I should see an error message indicating the email is not registered

  Scenario: Password reset functionality from the login page
    Given I am on the e-commerce website login page
    When I click on the "Forgot Password?" link
    Then I should be redirected to the password reset page

  Scenario: Handling session timeouts appropriately
    Given I am logged in to my account
    When my session times out
    Then I should be redirected to the login page
    And I should see a message indicating my session has expired