Feature: Buying different products and checking shopping basket

  @ipon
  Scenario Outline: Add product to shopping cart and verify successful action

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks shopping basket button
    Then user verify empty shopping basket
    And user clicks continue shopping
    And user choose category
    And user choose notebook as a product
    And user filters appropriate notebook
    And user selects one item
    And user adds products quantity number
    And user clicks add to cart
    And user closes cart window
    Then user should verify that product is added in the shoopping basket


    Examples:
      | TC_ID  |
      | IP_004 |

  @ipon
  Scenario Outline: Delete all products from shopping cart

    Given a user reads test data from "ipon" "notebook" by id "<TC_ID>"
    Given the user is on the ipon page
    And user chooses language
    And user clicks login button
    And user enters username and password for login action
    And user clicks shopping basket button
    And user delete all products



    Examples:
      | TC_ID  |
      | IP_004 |