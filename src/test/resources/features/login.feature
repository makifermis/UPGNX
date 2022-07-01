Feature: Upgenix app login feature
  User Story:
  As a user, I should be able to log in so that I can land on homepage.

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given User is on the upgenix login page

  Scenario Outline: Login as salesmanager with valid credentials
    When Salesmanager enters valid email "<email>" and password "<password>"
    And  Salesmanager-Posmanager clicks the login button
    Then Salesmanager login successfully verify that title contains "Odoo"
    Examples:
  | email                   | password     |
  | salesmanager5@info.com  | salesmanager |
  | salesmanager33@info.com | salesmanager |
  | salesmanager34@info.com | salesmanager |
  | salesmanager35@info.com | salesmanager |

  Scenario Outline: Login as posmanager with valid credentials
    When Posmanager enters valid email "<email>" and password "<password>"
    And  Salesmanager-Posmanager clicks the login button
    Then Posmanager login successfully verify that title contains "Odoo"
    Examples:
  | email                 | password   |
  | posmanager5@info.com  | posmanager |
  | posmanager6@info.com  | posmanager |
  | posmanager15@info.com | posmanager |
  | posmanager35@info.com | posmanager |

  Scenario Outline: Login as posmanager with invalid credentials (valid email-invalid password)
    Given Posmanager enters valid email "<email>" and invalid password "<password>"
    And   Salesmanager-Posmanager clicks the login button
    Then  Salesmanager-Posmanager sees "Wrong login/password" text above the "Log in" button
    Examples:
  | email                 | password  |
  | posmanager6@info.com  | psmanager |
  | posmanager15@info.com | posnager  |
  | posmanager35@info.com | posmanag  |

  @wip
  Scenario Outline: Login as salesmanager with invalid credentials (invalid email-valid password)
    Given Salesmanager enters invalid email "<email>" and valid password "<password>"
    And   Salesmanager-Posmanager clicks the login button
    Then  Salesmanager-Posmanager sees "Wrong login/password" text above the "Log in" button
    Examples:
  | email                 | password     |
  | salesmanager@info.com | salesmanager |
      | salesmanager35@in.com | salesmanager |
      | salesmanager45@info.c | salesmanager |

  Scenario Outline: Login as posmanager with invalid credentials (invalid email-valid password)
    Given Posmanager enters invalid email "<email>" and valid password "<password>"
    And   Salesmanager-Posmanager clicks the login button
    Then  Salesmanager-Posmanager sees "Wrong login/password" text above the "Log in" button
    Examples:
      | email              | password   |
      | posmanag6@info.com | posmanager |
      | posmanager15@i.com | posmanager |
      | posmanager35@info  | posmanager |

  Scenario Outline: Login as salesmanager with invalid credentials (valid email-invalid password)
    Given Salesmanager enters valid email "<email>" and invalid password "<password>"
    And   Salesmanager-Posmanager clicks the login button
    Then  Salesmanager-Posmanager sees "Wrong login/password" text above the "Log in" button
    Examples:
      | email                   | password  |
      | salesmanager6@info.com  | psmanager |
      | salesmanager15@info.com | posnager  |
      | salesmanager35@info.com | 1234      |
  Scenario: Verification of "Please fill out this field" message
    Given Salesmanager-Posmanager clicks the login button
    Then Please fill out this field message should be displayed

  Scenario: User land on the ‘reset password’ page after clicking on the "Reset password" link
    Given Salesmanager-Posmanager clicks on the reset password link
    Then Salesmanager-posmanager sees "Reset password" in the title


  Scenario:Verification of seeing the password in bullet signs by default
    Then Salesmanager-Posmanager sees the bullet signs while writing the password

  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When Posmanager enters valid email "posmanager15@info.com" - password "posmanager" and hits enter
    Then Posmanager login successfully verify that title contains "Odoo"


