Feature: Registration include valid and invalid scenarios with combination of wrong data

  @ipon
  Scenario Outline: Valid registration

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
    Then user should verify that is registered

    Examples:
      | TC_ID  |
      | IP_002 |

  @ipon
  Scenario Outline: Invalid registration (empty surename)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
    Then user should verify that the surename field is blank

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipon
  Scenario Outline: Invalid registration (empty firstname)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the firstname field is blank

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipon
  Scenario Outline: Invalid registration (empty email)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the email field is blank

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipon
  Scenario Outline: Invalid registration (empty password)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the password field is blank

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipon
  Scenario Outline: Invalid registration (empty username)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the username field is blank

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipon
  Scenario Outline: Invalid registration (invalid email)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the email field is filled as invalid

    Examples:
      | TC_ID  |
      | IP_004 |

  @ipon
  Scenario Outline: Invalid registration (short password <= 5)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the password field is filled as invalid

    Examples:
      | TC_ID  |
      | IP_005 |

  @ipon
  Scenario Outline: Invalid registration (short username <= 5)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the username field is filled as invalid

    Examples:
      | TC_ID  |
      | IP_006 |

  @ipon
  Scenario Outline: Invalid registration (long username > 30)

    Given a user reads test data from "ipon" "registration" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user clicks registration button
    And user should verify registration page
    And user should fill all fields
#    And user closes popup window
    Then user should verify that the username field is filled as invalid

    Examples:
      | TC_ID  |
      | IP_007 |