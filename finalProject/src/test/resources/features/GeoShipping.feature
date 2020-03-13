Feature: For different shipping zones setup different shipping price and taxes.

  Background: user is on demoshop homepage
    Given demoshop homepage is opened


  Scenario: assuring that Shipping Rate differs for countries in different shipping zones
    When i have created product order in UK
    And i change target adress from UK to Latvia
    And i collect data about Shipping Rate again
    Then i see that Shipping Rate differs between UK and Latvia

  Scenario: assuring that Eco Tax differs for countries in different shipping zones
    When i have created product order in UK
    And i collect data about Eco Tax
    And i change target adress from UK to Latvia
    And i collect data about Eco Tax again
    Then Eco Tax differs between UK and Latvia

  Scenario: assuring that VAT differs for countries in different shipping zones
    When i have created product order in UK
    And i collect data about VAT
    And i change target adress from UK to Latvia
    And i collect data about VAT again
    Then i see that Shipping Rate differs between UK and Latvia
