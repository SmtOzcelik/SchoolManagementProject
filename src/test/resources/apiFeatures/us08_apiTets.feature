@vicedean
Feature: Vice Dean can create lesson

  Scenario Outline: US08 Assert that created lesson
    Given Do get request with lessonName "<lessonName>"
    Then Verify lesson body that return: lessonId="<lessonId>", lessonName="<lessonName>", creditScore="<creditScore>",  compulsory="<compulsory>", message="<message>"
    Examples:
      | lessonId | lessonName | creditScore | compulsory | message                   |
      | 49       | Calculus   | 12          | true       | Lesson successfully found |