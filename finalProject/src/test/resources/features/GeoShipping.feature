Feature: For different shipping zones setup different shipping price and taxes.

  Background: Product is added to cart. User is on "checkout" page in section "Step 6: Confirm Order", all previous
  steps are completed, selected country in section "Step 2: Billing Details" is United Kingdom, unit price details
  "Sub-Total", "Flat Shipping Rate", "Eco Tax", "VAT", "Total" are displayed and user collects their values. Then in
  section "Step 2: Billing Details" user selects country Latvia, and selects Region / State "Adazu novads", and in
  section "Step 6: Confirm Order" user collects values of unit price details "Sub-Total", "Flat Shipping Rate",
  "Eco Tax", "VAT", "Total" after country update.

    Given demoshop homepage is opened


  Scenario: assuring that Shipping Rate, Eco Tax, VAT differs for countries in different shipping zones
    When i have created product order in UK
    And i collect data about Shipping Rate
    And i collect data about Eco Tax
    And i collect data about VAT
    And i change target adress from UK to Latvia
    And i collect data about Shipping Rate
    And i collect data about Eco Tax
    And i collect data about VAT
    Then i see that Shipping Rate differs between UK and Latvia
    And Eco Tax differs between UK and Latvia
    And  VAT differs between UK and Latvia