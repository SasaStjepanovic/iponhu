Feature: Footer scenarios include checking all footer functions

  @ipon
  Scenario Outline: Verification of existing items from myProfile

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    Then user should verify all myprofile items

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Verification of Orders item

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    And user clicks Order item
    Then user should verify visibility of item

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Verification of Favourites item

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    And user clicks Favourites item
    And user want to get name favourites
    Then user should verify visibility of item Favourites

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Verification of Monitored item

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    And user clicks Monitored item
    And user want to get name monitored item
    Then user should verify visibility of Monitored item

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Verification of Partner program item

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    And user clicks Partner Program item
    And user want to get name partner program item
    Then user should verify visibility of Partner program item

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Verification of Personal information item

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    And user clicks Personal Information item
    And user want to get name personal information item
    Then user should verify visibility of Personal information item

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Verification of Settings item

    Given a user reads test data from "ipon" "login" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks Myprofile button
    And user clicks Settings item
    And user want to get name settings item
    Then user should verify visibility of Settings item

    Examples:
      | TC_ID  |
      | IP_001 |