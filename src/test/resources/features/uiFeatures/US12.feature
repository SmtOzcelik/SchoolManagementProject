Feature: US-12 Vice dean can to assign teacher to lesson
  Background: Background: : To Lesson management menü
    Given go to <"managementonschoolUrl">
    Then Click To <"login">
    Then Enter<"ViceDeanUsernameAykut"> UserName
    And Enter<"ViceDeanPasswordAykut"> PassWord
    Then Click To <"LoginButtonInLoginMenu">
    Then Click To <"menuButton">
    Then Click To <"lessonManagementMenu">
    And Click_To_Lesson_Programs

  Scenario: TC-01 Vice DEan can to create lesson program
    Then Choose a lesson "Java" as Vice Dean in Lesson Program
    Then Choose a education term as Vice Dean in Lesson Program
    Then Choose a day as Vice Dean in Lesson Program
    Then Choose a start time "07:00" in Lesson Program
    Then Choose a Stop Time "09:00" in Lesson Program
    Then submit in add lesson program
    Then Lesson Created Alert ini gorur
    And Close Driver

  Scenario: TC-03 Vice Dean can assign a teacher to lesson
    Then Vice Dean select a lesson
    Then Vice Dean asign a teacher
    And Close Driver
