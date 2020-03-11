@UserStory12

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
  Given I am one the HomePage

  @OpenProductPage
  Scenario: User is able to open product page
    When I click on Apple Cinema name
    Then I am redirected to Apple Cinema page
    Scenario:
    When I click on Apple Cinema image
    Then I am redirected to Apple Cinema page

  @SeeInfoAboutProduct
  Scenario: User is able to see information about product
    When I am redirected to Apple Cinema page
    Then Product <info> is visible
      | imageAppleCinema    |
      | nameAppleCinema     |
      | AddToWishListButton |
      | AddToCartButton     |
      | CompareButton       |
      | AvailableOptions    |
      | Description         |
      | Specification       |
      | Review              |
      | Price               |






