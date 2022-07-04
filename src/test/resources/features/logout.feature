@UPGNX-349
Feature: Upgenix app logout feature
  User Story:
  As a user, I should be able to log out.

  Background: For the scenarios in the feature file, user is expected to be logged in.
    Given User is on the upgenix login page
    And Posmanager enters valid email "posmanager15@info.com" - password "posmanager" and hits enter
    Then Posmanager login successfully verify that title contains "Odoo"
  @UPGNX-347
  Scenario: User can log out and ends up in login page.
    When User click on the profile icon
    And User verify that Log out link is visible
    And User clicks on the Log out link
    Then User verify that Log out is successful and the title contains "Login"
  @UPGNX-348
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When User click on the profile icon
    And User clicks on the Log out link
    Then User clicks to step back button and sees the "Odoo Session Expired" message