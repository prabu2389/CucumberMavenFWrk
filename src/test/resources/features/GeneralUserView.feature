Feature: General User View

  Scenario: Validate General user is able to view products without loggin in
    Given user navigates to online products page
    When User clicks on formal shoes dropdown
    Then User should be able to view the products
