Feature: User edits his/hers account
  Background:
  Given User is logged in

    When I click on Edit Account submenu
    And I edit user information
    And I click Continue
    Then Success message appears

