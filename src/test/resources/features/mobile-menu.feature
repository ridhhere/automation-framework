@mobile @mobile-regression @menu @regression-ridh
Feature: Menu feature

  @menu-1
  Scenario: Verify sidebar validation
    Given I am on home page of the app
    When I click on hamburger menu
    Then I verify sidebar menu is displayed correctly


  @menu-2
  Scenario: Verify invalid signup
    Given I am on signup screen
    When I tap on create button from signup screen
    Then I verify invalid password text
    And I verify invalid username text

  @menu-3
  Scenario: Verify user should be able filter options
    Given I am on home page of the app
    When I click on filter button
    And I disable 'Angular' option
    And I click on All Reset Filter button
    Then I verify all options are enabled

  @menu-4
  Scenario: Verify user should be able to slide right on tutorial pages
    Given I am on Splash screen of the ionic conference app
    When I swipe right 3 times on tutorials slides
    Then I verify continue button
