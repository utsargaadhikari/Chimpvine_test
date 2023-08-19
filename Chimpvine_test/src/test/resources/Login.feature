Feature: User Login

  Scenario: Valid login with correct credentials
    Given the user is on the login page
    When they enter valid username and password
    And click on the "Login" button
    Then they should be redirected to the main landing page

  Scenario: Invalid login with incorrect credentials
    Given the user is on the login page
    When they enter invalid username and password
    And click on the "Login" button
    Then they should see an error message and login should not be successful

  Scenario: Login with empty fields
    Given the user is on the login page
    When they leave both username and password fields empty
    And click on the "Login" button
    Then they should see an error message and login should not be successful

  Scenario: Valid login with case-insensitive username
    Given the user is on the login page
    When they enter a valid username in different case
    And enter a valid password
    And click on the "Login" button
    Then they should be redirected to the main landing page

  Scenario: Valid login with leading/trailing spaces
    Given the user is on the login page
    When they enter a username with leading/trailing spaces
    And enter a valid password
    And click on the "Login" button
    Then they should be redirected to the main landing page

  Scenario: Valid login with "Remember Me" functionality
    Given the user is on the login page
    When they enter a valid username
    And enter a valid password
    And check the "Remember Me" option
    And click on the "Login" button
    Then they should be redirected to the main landing page with persistent login

  Scenario: Lockout after multiple failed attempts
    Given the user is on the login page
    When they enter an invalid username multiple times
    And enter an invalid password multiple times
    And verify that the login is locked out
    Then they should see an error message and login should be locked out

  Scenario: Password visibility toggle
    Given the user is on the login page
    When they enter a valid username
    And enter a valid password
    And toggle password visibility
    And click on the "Login" button
    Then the password visibility should toggle on and off

  Scenario: Login with special characters in password
    Given the user is on the login page
    When they enter a valid username
    And enter a password with special characters
    And click on the "Login" button
    Then they should be redirected to the main landing page

  Scenario: Login with locked account
    Given the user is on the login page
    When they enter a username with a locked status
    And enter a valid password
    And click on the "Login" button
    Then they should see an error message and login should not be successful
