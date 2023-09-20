@vicedean @US08DB
Feature: ViceDean can create lesson

  Scenario Outline: Verify lesson that is created
    Given Take lesson that name is "<lesson name>"
    Then Verify the lesson : lessonId="<lessonId>", lessonName="<lessonName>", creditScore="<creditScore>",  compulsory="<compulsory>"
    Examples:
      | lessonId | lessonName | creditScore | compulsory |
      | 49       | Calculus   | 12          | true       |
