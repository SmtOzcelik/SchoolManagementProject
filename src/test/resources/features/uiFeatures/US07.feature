@US07
Feature: US07 Dean's Message Process

  Background:
    Given User goes to "Url"

    Scenario: User logins as a Dean

      When User clicks to login button
      When User enters an Username as "DeanTeam11"
      When User enters a "password"
      When User waits 3 seconds
      When User clicks login button


  Scenario:Check to "Contact Get All"

    And User click to menu button
    And User click to "Contact get all" button
    And User tests the visibility of "Name" column
    And User tests the visibility of "Email" column
    And User tests the visibility of "Date" column
    And User tests the visibility of "Subject" column
    And User tests the visibility of "Message" column

  Scenario:Delete "Message"
    And User tests the visibility of "Delete" button
    And User clicks to "Delete" button
    And User tests if the message has been deleted
    And User closes driver




