@US07
Feature: US07 Dean's Message Process

  Background:
    Given User goes to "url"
    Then User waits 3 seconds
    Then User clicks to login button
    Then User enters an username, password and then is logged in.
    Then User waits 3 seconds

  Scenario: Check to Contact Message
    And User clicks to menu button
    And User clicks to Contact get all button
