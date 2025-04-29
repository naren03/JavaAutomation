Feature: User Login Functionality

  Scenario: Display login button on homepage
    Given I am on the homepage
    Then I should see a prominently displayed login button

  Scenario: Display login button on relevant pages
    Given I am on a relevant page
    Then I should see a prominently displayed login button

  Scenario: Open login modal on clicking login button
    Given I am on the homepage
    When I click the login button
    Then a login modal should open

  Scenario: Redirect to login page on clicking login button
    Given I am on a relevant page
    When I click the login button
    Then I should be redirected to the login page

  Scenario: Successful login
    Given I am on the login page
    And I enter a valid email/username and password
    When I click the 'Submit' button
    Then I should be redirected to my account dashboard

  Scenario: Failed login due to incorrect credentials
    Given I am on the login page
    And I enter an invalid email/username and password
    When I click the 'Submit' button
    Then I should see an error message indicating incorrect credentials

  Scenario: Access password recovery process
    Given I am on the login page
    When I click the 'Forgot Password?' link
    Then I should be directed to the password recovery process