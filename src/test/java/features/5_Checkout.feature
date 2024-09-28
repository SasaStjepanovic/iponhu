Feature: Order scenarios include valid and invalid order with combination of wrong data

  @iponx
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
    Then user should verify error message for zip code

    Examples:
      | TC_ID  |
      | IP_004 |
