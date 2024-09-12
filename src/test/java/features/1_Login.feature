Feature: Login scenarios include valid login and invalid login with combination of wrong credentials

  @iponeeee
  Scenario Outline: Login valid username

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    Then user should verify login action

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipone
  Scenario Outline: Login valid email

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters email and password for login action
    Then user should verify login action

    Examples:
      | TC_ID  |
      | IP_002 |

  @ipone
  Scenario Outline: Login invalid username

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    Then user should verify invalid login action

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipone
  Scenario Outline: Login invalid email

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    Then user should verify invalid login action

    Examples:
      | TC_ID  |
      | IP_004 |

  @ipone
  Scenario Outline: Login empty username

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    Then user should verify invalid login action

    Examples:
      | TC_ID  |
      | IP_005 |

  @ipone
  Scenario Outline: Login empty email

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    Then user should verify invalid login action

    Examples:
      | TC_ID  |
      | IP_006 |

  @ipone
  Scenario Outline: Login valid username (footer)

    Given a user reads test data from "ipon" "general" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login footer button
    And user enters username and password for login action
    Then user should verify login action

    Examples:
      | TC_ID  |
      | IP_001 |
