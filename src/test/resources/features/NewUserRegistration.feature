Feature: New User Registration View

  @Smoke3
  Scenario Outline: Validate New user is able to view after clicking on new Registration
    Given user navigates to <url> online products page
    When User clicks on New Registration button
    Then User should be able to view the Registration page
    Examples:
    |url|
    |"https://anupdamoda.github.io/AceOnlineShoePortal/index.html"|
