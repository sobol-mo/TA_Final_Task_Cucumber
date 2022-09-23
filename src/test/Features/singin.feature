Feature: SingIn
  As a user
  I want to test sing in functionality
  So that I can be cure that I can sign in

  @smoke
    @signin
  Scenario Outline: Check sign in with correct credentials
    Given User opens '<homePage>' page
    And User checks sign in link visibility
#    And User goes to sign in page
#    When User enter correct credentials '<login>' and '<password>'
#    Then User logged in successfully
    Examples:
      | homePage              | login              | password             |
      | https://www.ebay.com/ | sobol.mo@gmail.com | cvBleWXIMhfZ9nAUq6Y1 |

