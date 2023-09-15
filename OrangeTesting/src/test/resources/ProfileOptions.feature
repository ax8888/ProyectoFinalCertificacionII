Feature: Profile Options Feature
  Background: User should be able to check out all profile options
    Given I am in Orange HRM web page

  @CheckAbout
  Scenario: Check that about displays the correct message
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button