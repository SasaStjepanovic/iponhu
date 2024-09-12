Feature: Footer scenarios include checking all footer functions

  @ipon
  Scenario Outline: Verification of existing all languages in drop down footer from

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user clicks login button
    And user enters username and password for login action
    Then user should verify login action
    And user expand languages bar
    Then user should verify existing of all languages

    Examples:
      | TC_ID  |
      | IP_001 |