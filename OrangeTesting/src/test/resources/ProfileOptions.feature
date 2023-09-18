Feature: Profile Options Feature
  Background: User should be able to check out all profile options
    Given I am in Orange HRM web page

  @CheckAbout
  Scenario: Check that about displays the correct information
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button
    And I select "About"
    Then About title should show
    And The following information titles should be displayed
      | Company Name: | Version: | Active Employees: | Employees Terminated: |
    And The following information text should be displayed
      | OrangeHRM | OrangeHRM OS 5.5 | 0 |
