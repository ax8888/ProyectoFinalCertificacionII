Feature: My Info Feature
  Background: User should be able to see their information displayed correctly
    Given I am in Orange HRM web page

  Scenario: Check that the memberships tab shows the correct information
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button
    And I select My Info
    And I select Memberships
    Then The membership with the following information should be displayed
      | abc.txt | its membership | 9.00 B | text/plain | 2023-07-17 | Admin |