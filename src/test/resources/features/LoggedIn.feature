Feature: LoggedIn User View

  @Smoke2
  Scenario Outline: Validate user is able to view after login
    Given user navigates to <url> online products page
    When User successfully enters the login details
    Then User should be able to view the product category page
    Examples:
      | url                                                           |
      | "https://anupdamoda.github.io/AceOnlineShoePortal/index.html" |
