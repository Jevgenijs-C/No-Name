
Feature:
  As a user i want to be able see information about product:
  name,
  image,
  description,
  specification,
  review,
  price,
  available options
  and buttons ‘Compare’, “Add to Cart”, “Add to Wish list”

  As a user i want to be able:
  to open product page and add product to cart,
  to write review for product after purchase,
  to add product to compare list
Background:
  Given I am on the HomePage

  Scenario: User is able to open product page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page

  Scenario: User is able to see information about product

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see product name

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see product image

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see product price

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see available options

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see description

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see specification

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see review

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see Compare button

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see Add to Wish list button

    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    When I click on Components tab
    And I select Monitors
    And I click on Apple Cinema image
    Then I am redirected to Apple Cinema page
    And I am able to see Add to Cart button

  @AddToCart
  Scenario:
    When I am on the IPhonePage
    And I click on Add to Cart Button
    Then IPhone is added to Cart



