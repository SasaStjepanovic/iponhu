Feature: Checkout scenarios include own data, pickup and payment option

  @ipon
  Scenario Outline: Invalid order (empty zip code)

    Given a user reads test data from "ipon" "checkout" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    And user selects one item
    And user adds products quantity number
    And user clicks add to cart
    And user clicks continue to checkout
    And user clicks order button
    Then user should verify error message for empty zip code

    Examples:
      | TC_ID  |
      | IP_004 |

  @ipon
  Scenario Outline: Invalid order (bad zip code)

    Given a user reads test data from "ipon" "checkout" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    When user clicks shopping cart button
    And user clicks continue to checkout
    And user clicks edit button of own data
    And user wants to edit own
    And user clicks order button
    Then user should verify error message for bad zip code

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Invalid order (empty city)

    Given a user reads test data from "ipon" "checkout" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    When user clicks shopping cart button
    And user clicks continue to checkout
    And user clicks edit button of own data
    And user wants to edit own
    And user clicks order button
    Then user should verify error message for empty city

    Examples:
      | TC_ID  |
      | IP_001 |

  @ipon
  Scenario Outline: Invalid order (empty street)

    Given a user reads test data from "ipon" "checkout" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    When user clicks shopping cart button
    And user clicks continue to checkout
    And user clicks edit button of own data
    And user wants to edit own
    And user clicks order button
    Then user should verify error message for empty street

    Examples:
      | TC_ID  |
      | IP_001 |
