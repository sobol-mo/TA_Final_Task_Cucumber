Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  @smoke
  Scenario Outline: Check add product to watchlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
#    And User clicks watchlist on first product
#    Then User checks that amount of products in watchlist are '<amountOfProducts>'

    Examples:
      | homePage                | keyword      | amountOfProducts |
      | https://www.amazon.com/ | dire straits | 1                |

