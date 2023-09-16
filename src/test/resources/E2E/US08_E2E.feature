@admin
Feature: Vice Dean Lesson Create Process E2E

  Scenario: Admin create viceDean account
    Given User goes to "url"
    Then User waits 3 seconds
    Then User clicks to login button
    Then User enters an adminUsername, password and then is logged in.
    Then User waits 3 seconds
    Then User clicks to menu button
    Then User clicks on the Vice Dean Management option from Main Menu window
    Then User enters "Name" "Surname" "Birth Place" "Gender" "Birthday" "PhoneNumber"
    And User enters "ViceDeanSSNnNo" "ViceDeanUserName" "ViceDeanPassword"
    And User clicks submit buttton
    Then User verifies that viceDean is created

  Scenario: Verify viceDean that is created with API
    Given Get the ID number of the registered viceDean data
    And ViceDean's data is prepared
    And The registered "viceDean" is called with ID number
    Then Verify registered viceDean information