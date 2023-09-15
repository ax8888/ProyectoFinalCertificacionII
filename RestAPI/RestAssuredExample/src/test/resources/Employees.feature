Feature: Employees endpoint
  Background: Employees endpoints should allow to get, create, update and delete employees

    @getAll
    Scenario: /employees should return all the employees
      Given I perform a GET to the employees endpoint
      Then I verify status code 200 is returned
      And I verify that the body does not have size 0

    @post
    Scenario: /create should create an employee
      Given I perform a POST to the create endpoint with the following data
        | Diego | 3500 | 26 |
        Then I verify status code 200 is returned
      And I verify that the body does not have size 0
      And I verify the following data in the body response
        | Diego | 3500 | 26 |

        #proyecto final
    @get
    Scenario: /get should return an employee with a valid id
        Given I perform a GET employee with id 2
        Then I verify status code 200 is returned
        And I verify I got the following data
          | Garrett Winters | 170750 | 63 |

    @put
    Scenario: /put should update the information of employee with a valid id
       Given I perform a PUT employee with the following data
         | 23 | Paula | 150000 | 35 |
       Then I verify status code 200 is returned
       And I verify the following data in the body response
         | Paula | 150000 | 35 |

    @remove
    Scenario: /delete should delete the information of employee with a valid id
       Given I perform a DELETE employee with id 24
       Then I verify status code 200 is returned
       And I verify that I get the following message
         | Successfully! Record has been deleted |

    @failedGet
    Scenario: /get with an invalid id should return empty data
      Given I perform a GET employee with id 100000
      Then I verify status code 200 is returned
      And I verify that data is null

