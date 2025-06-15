Feature: Flipkart Search

  @flipkart
  Scenario Outline: To verify the functionality of search element.
    Given User has launched ChromeBrowser.
    And User has navigated to Flipkart.
    When User search "<search>" in search element.
    Then Verify the "<title>" of the page
    And Close the browser.

    Examples: 
      | search     | title      |
      | Mobile     | Mobile     |
      | Smartwatch | Smartwatch |
      | Mouse      | Mouse      |
      | Keyboard   | Keyboard   |
      | Chair      | Chair      |
