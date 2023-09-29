Feature: Search and place the order for Products

  Scenario: Search experience for product is same on homepage and top deals page

    Given User is on GreenKart landing page
    When user searched for shortname "Tom" and fetch the full name of product
    Then user searched for "Tom" shortname in top deals page
    And Compare full name of product fetched from both pages