Feature: SingIn
  As a user
  I want to test sing in functionality
  So that I can be cure that I can sign in

  @smoke
    @signin
  Scenario Outline: Check sign in with correct credentials
    Given I open '<homePage>' page
    And I check sign in link visibility
    And I go to sign in page
    When I enter credentials '<userID>' and '<password>'
    Then I logged in successfully
    Examples:
      | homePage                | userID             | password        |
      | https://www.amazon.com/ | sobol.mo@gmail.com | u/S57(HjseUtiP@ |


  @smoke
    @signin
  Scenario Outline: Check sign in with wrong password
    Given I open '<homePage>' page
    And I check sign in link visibility
    And I go to sign in page
    When I enter credentials '<userID>' and '<password>'
    Then I logged in unsuccessfully
    Examples:
      | homePage                | userID             | password       |
      | https://www.amazon.com/ | sobol.mo@gmail.com | u/S57(HjseUtiP |

  @smoke
    @signin
  Scenario Outline: Check sign in with wrong userID
    Given I open '<homePage>' page
    And I check sign in link visibility
    And I go to sign in page
    When I enter wrong '<userID>'
    Then I logged in unsuccessfully with wrong userID
    Examples:
      | homePage                | userID            |
      | https://www.amazon.com/ | sobol.m@gmail.com |