Feature: User edits his/hers account
  Background:
    Given I am on the Log In Page
    And I enter email address
    And I enter password
    And I press Log In


    @edit
    Scenario Outline: I edit account info
    When I click on Edit Account submenu
    And I edit "<name>", "<lastName>", "<email>", "<phone>"
    And I click Continue
    Then Success message appears
      Examples:
      |name|lastName|email           |phone |
      |John|Doe     |newmail@test.com|098765|

