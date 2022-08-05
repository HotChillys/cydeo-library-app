
Feature: Login with parameters

  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password "fsRRgXxB"
    And click the sign in button
    Then dashboard should be displayed


  Scenario: Login as librarian 12
    Given I am on the login page
    When I enter username "librarian12@library"
    And I enter password "wHhJQDSK"
    And click the sign in button
    Then dashboard should be displayed
    And there should be "667" users
  #number can be whatever you have there
  @wip
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian11@library" and "fsRRgXxB"
    Then dashboard should be displayed
    And there should be "667" users
 #number can be whatever you have there
  # Expected “23” is symbolic number. This can change. Verify as what number you see