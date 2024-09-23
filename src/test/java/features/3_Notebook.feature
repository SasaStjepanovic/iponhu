Feature: Notebook product: Apply filter for all Notebook PC eBook's

  @ipon
  Scenario Outline: Notebook PC, eBook -> Mini computer

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user want to get name of Notebook category
    Then user should verify visibility of Notebook category

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Apply filter for Notebook

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    Then user should verify visibility Notebook product

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Apply filter for Gamer notebook

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    Then user should verify visibility Notebook product

    Examples:
      | TC_ID  |
      | IP_002 |

  @ipon
  Scenario Outline: Apply filter for Notebook accessories

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    Then user should verify visibility Notebook product

    Examples:
      | TC_ID  |
      | IP_003 |

  @ipon
  Scenario Outline: There are no filtered products

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    Then user should verify invisibility of filtered product

    Examples:
      | TC_ID  |
      | IP_002 |

  @iponx
  Scenario Outline: There are no filtered products

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    And user selects one item

    Examples:
      | TC_ID  |
      | IP_003 |