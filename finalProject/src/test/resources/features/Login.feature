 Feature: Feature
Background:
    Given I am on the Log In Page

  @login
    Scenario: I log in
      When I enter email address
      And I enter password
      And I press Log In
      Then Account page is opened