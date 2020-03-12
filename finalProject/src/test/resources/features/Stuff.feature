Feature: User edits his/hers account

  Background:
    Given I am on the Log In Page
    And I enter email address
    And I enter password
    And I press Log In

  @elementsPresence
    Scenario:
    When I check elements are present
    |My Account        |
    |Edit Account      |
    |Password          |
    |Address Book      |
    |Wish List         |
    |Order History     |
    |Downloads         |
    |Recurring payments|
    |Reward Points     |
    |Returns           |
    |Transactions      |
    |Newsletter        |
    |Logout            |

  @edit
  Scenario: I edit account info
    When I click on Edit Account submenu
    And I edit following info
      | name | lastName | email            | phone  |
      | John | Doe      | newmail@test.com | 098765 |
    And I click Continue
    Then Success message appears
#    Examples:
#      | name | lastName | email            | phone  |
#      | John | Doe      | newmail@test.com | 098765 |

  @address
  Scenario Outline: I add first Default Address
   When I click on Address book
   And I click on New Address button
   And I enter "<name>", "<lastName>", "<address>", "<city>", "<postCode>"
   And I choose "<country>" and "<region>"
   And I choose Yes option
   And I click Continue
   Then Success message appears
   Examples:
     | name | lastName | address         | city   |postCode|country       |region  |
     | John | Doe      | Street st, 40-2 | London |123456  |United Kingdom|Aberdeen|

    @address2
    Scenario Outline: I add second Default Address
      When I click on Address book
      And I click on New Address button
      And I enter "<name>", "<lastName>", "<address>", "<city>", "<postCode>"
      And I choose "<country>" and "<region>"
      And I choose Yes option
      And I click Continue
      And Success message appears
      Then I check new address is default
      And I check old address is not default
      Examples:
        | name | lastName | address         | city         |postCode|country       |region  |
        | Jane | Doe      | Elm st, 40-2    | New Orleans  |5678    |United States |Alabama |
