Feature: User edits his/hers account

  Background:
    Given I am on the Log In Page
    And I enter email address
      | email               |
      | testemail@email.com |
    And I enter password
      | password    |
      | onetwothree |
    And I press Log In

  @elementsPresence
  Scenario:
    When I check elements are present
      | My Account         |
      | Edit Account       |
      | Password           |
      | Address Book       |
      | Wish List          |
      | Order History      |
      | Downloads          |
      | Recurring payments |
      | Reward Points      |
      | Returns            |
      | Transactions       |
      | Newsletter         |
      | Logout             |

  @edit
  Scenario: I edit account info
    When I click on Edit Account submenu
    And I edit following info
      | name | lastName | email               | phone  |
      | John | Doe      | testemail@email.com | 098765 |
    And I click Continue
    Then Success message appears

  @address
  Scenario: I add first Default Address
    When I click on Address book
    And I click on New Address button
    And I enter name, lastName, address, city, postCode
      | name | lastName | address         | city   | postCode |
      | John | Doe      | Street st, 40-2 | London | 123456   |
    And I choose country
      | country        |
      | United Kingdom |
    And I choose region
      | region |
      | Angus  |
    And I choose Yes option
    And I click Continue
    Then Success message appears


  @newaddress
  Scenario: I add second Default Address
    When I click on Address book
    And I click on New Address button
    And I enter name, lastName, address, city, postCode
      | name | lastName | address      | city        | postCode |
      | Jane | Doe      | Elm st, 40-2 | New Orleans | 5678     |
    And I choose country
      | country       |
      | United States |
    And I choose region
      | region  |
      | Alabama |
    And I choose Yes option
    And I click Continue
    And Success message appears
    Then I check new address is default
    And I check old address is not default
    And I delete old address

