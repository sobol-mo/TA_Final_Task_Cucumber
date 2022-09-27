Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  @smoke
  Scenario Outline: Check search product
    Given I open '<homePage>' page
    And I check search field visibility
    When I make search by keyword '<keyword>'
    And I click search button
    Then I can see right amount of products '<amountOfProducts>'

    Examples:
      | homePage                | keyword      | amountOfProducts |
      | https://www.amazon.com/ | dire straits | 16               |

