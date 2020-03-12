Feature: For different shipping zones setup different shipping price and taxes.

  Background: Product is added to cart.
    Given demoshop homepage is opened


  Scenario: assuring that Shipping Rate, Eco Tax, VAT differs for countries in different shipping zones
    When i have created product order in UK
    And i collect data about Shipping Rate
    And i collect data about Eco Tax
    And i collect data about VAT
    And i change target adress from UK to Latvia
    And i collect data about Shipping Rate again
    And i collect data about Eco Tax again
    And i collect data about VAT again
    Then i see that Shipping Rate differs between UK and Latvia
    And Eco Tax differs between UK and Latvia
    And  VAT differs between UK and Latvia