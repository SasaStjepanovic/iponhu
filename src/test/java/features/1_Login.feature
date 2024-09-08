Feature: Login scenarios include valid login and invalid login with combination of wrong credentials

  @ipon
  Scenario Outline: Login valid user

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user clicks login button
    And user enters username and password for login action
#    Then user sholud verify login action

    Examples:
      | TC_ID  |
      | IP_001 |


