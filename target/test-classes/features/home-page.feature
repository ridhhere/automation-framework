@web @regression @homework
Feature: Homepage

  Background:
    Given I am on home page

  @homework-1
  Scenario Outline: Verify Invalid Login
    When I enter ridh into firstname text fields on home screen
    And I enter gurung into lastname text fields on home screen
    And I enter <invalidemail> into email mobile text fields on home screen
    And I click on new password text fields on home screen
    And I click on email mobile text fields on home screen
    Then I verify invalid email error message
    Examples:
      |            invalidemail          |
      |            plainaddress          |
      |          #@%^%#$@#$@#.com        |
      |            @example.com          |
      |   Joe Smith <email@example.com>  |
      |          email.example.com       |
      |     email@example@example.com    |
      |          .email@example.com      |
      |          email.@example.com      |
      |      email..email@example.com    |
      |      あいうえお@example.com        |
      |  email@example.com (Joe Smith)   |
      |           email@example          |
      |        email@-example.com        |
      |         email@example.web        |
      |     email@111.222.333.44444      |
      |        email@example..com        |
      |        Abc..123@example.com      |


  @homework-2
  Scenario: Select Current Month From Drop Down and Verify
    When I select current month from month dropdown on home screen
    Then I verify current month is selected from month dropdown

  @homework-3
  Scenario: Find out if dropdown contains duplicate values
    When I select month from month dropdown on home screen
    Then I verify if month doesn't contain duplicate value
