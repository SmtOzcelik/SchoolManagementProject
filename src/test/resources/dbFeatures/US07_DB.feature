Feature: Users can sent to messages from contact message page

  Scenario Outline: Verify message that is sent
    Given Take a message with "<email>" information
    Then Verify message information : name="<name>", email="<email>", subject="<subject>", message="<message>", date="<date>"
    Examples:
      | name     | email                    | subject   | message           | date       |
      | Charisse | easter.frami@hotmail.com | Miss Seth | Bachelor's degree | 2023-09-08 |
