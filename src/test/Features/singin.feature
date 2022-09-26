Feature: SingIn
  As a user
  I want to test sing in functionality
  So that I can be cure that I can sign in

  @smoke
    @signin
  Scenario Outline: Check sign in with correct credentials
    Given User opens '<homePage>' page
    And User checks sign in link visibility
    And User goes to sign in page
    When User enter credentials '<userID>' and '<password>'
    Then User logged in successfully
    Examples:
      | homePage                | userID             | password        |
      | https://www.amazon.com/ | sobol.mo@gmail.com | u/S57(HjseUtiP@ |


  @smoke
    @signin
  Scenario Outline: Check sign in with wrong password
    Given User opens '<homePage>' page
    And User checks sign in link visibility
    And User goes to sign in page
    When User enter credentials '<userID>' and '<password>'
    Then User logged in unsuccessfully
    Examples:
      | homePage                | userID             | password       |
      | https://www.amazon.com/ | sobol.mo@gmail.com | u/S57(HjseUtiP |

  @smoke
    @signin
  Scenario Outline: Check sign in with wrong userID
    Given User opens '<homePage>' page
    And User checks sign in link visibility
    And User goes to sign in page
    When User enter wrong '<userID>'
    Then User logged in unsuccessfully with wrong userID
    Examples:
      | homePage                | userID            | password       |
      | https://www.amazon.com/ | sobol.m@gmail.com | u/S57(HjseUtiP |