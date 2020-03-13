
Feature: Feature
  Background:
    Given I am on the Log In Page
    When I enter email address
    And I enter password
    And I press Log In
    And Account page is opened

    When I am on the IPhonePage
    And I click on Add to Cart Button
    Then IPhone is added to Cart

  @Checkout
  Scenario: Click checkout
    When I click on Checkout Button
    Then I am redirected to checkout page
    When I select Billing Details
    And I click Continue to Delivery Details
    And I select Delivery Details
    And I click Continue to Delivery Method
    And I select Delivery Method
    And click Continue to Payment Method
    And I select Cash On Delivery
    And I click Agree
    And I click Continue to Confirm Order
    And I click Confirm Order
    Then I see that My Order is placed