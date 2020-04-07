@web @regression @darksky
Feature: DarkSky


  @darksky-1
  Scenario: Verify invalid signup error message
    Given I am on the Darksky Register page
    When I click on Register button
    Then I verify error message


  @darksky-2
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Given I am on Darksky Home Page
    Then I verify current temp is not greater or less then temps from daily timeline
#    Including find web elements in Basepage

  @darksky-3
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly
#    Thread.sleep problem in scroll
#    Including find web elements in Basepage

  @darksky-4
  Scenario: Verify timeline is displayed in correct format
    Given I am on Darksky Home Page
    Then I verify timeline is displayed with two hours incremented
