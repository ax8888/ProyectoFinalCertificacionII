Feature: Save User Feature
  Background: The ability to create a user in the Admin Page
    Given I am in Orange HRM web page

  Scenario: Check that the password notifies the user about the different requirements
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button
    And I select Admin
    Then I get a certain message when putting a certain password
      | 1 | Should have at least 7 characters |
      #| 1234567 | Your password must contain minimum 1 lower-case letter |