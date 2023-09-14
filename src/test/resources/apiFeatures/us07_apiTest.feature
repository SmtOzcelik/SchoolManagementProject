@US07Api @Api @US07E2E

  Feature: Dean can see message that users sent
  Scenario Outline: US07 Verify get contact message
    Given Take all of messages with Get request
    Then Verify body : name="<name>", email="<email>", subject="<subject>", message="<message>", date="<date>"
    Examples:
      | name  | email           | subject  | message                                              | date       |
      | merve | merve@gmail.com | schedule | Can you give me information about 15th May schedule? | 2023-09-12 |