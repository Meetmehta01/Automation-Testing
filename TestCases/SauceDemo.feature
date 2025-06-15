Feature: Login

  @valid
  Scenario: Verify login functionality.
    Given User launches ChromeBrowser.
    And User navigates to SauceDemo site.
    When User enters "standard_user" in username feild.
    And User enters "secret_sauce" in password feild.
    And User clicks on login button.
    Then User verifies login by checking Web page url.
    And User closes the Chrome browser.

  @invalid
  Scenario: Verify login functionality.
    Given User launches ChromeBrowser.
    And User navigates to SauceDemo site.
    When User enters "locked_out_user" in username feild.
    And User enters "secret_sauce" in password feild.
    And User clicks on login button.
    Then User verifies login by checking Web page url.
    And User closes the Chrome browser.
