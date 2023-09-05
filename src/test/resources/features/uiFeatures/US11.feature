Feature: US-11 Vice dean can to see created Lesson Program
#
  Background: : To Lesson management menü
    Given go to <"managementonschoolUrl">
    Then Click To <"login">
    Then Enter<"ViceDeanUsernameFatih"> UserName
    And Enter<"ViceDeanUserPasswordFatih"> PassWord
    Then Click To <"LoginButtonInLoginMenu">
    Then Click To <"menuButton">
    Then Click To <"lessonManagementMenu">
    And Click_To_Lesson_Program
 #

  Scenario: TC-01 Vice dean can to see lesson,lesson day,start time, stop time
    And Lesson is Display
    Then Day is Display
    Then Start Time is Display
    And Stop Time is Display
   # And Close Driver

  Scenario: TC-02 Vice Dean can to change in program list

    Then Vice Dean can not "change"

  Scenario: TC-03 Vice Dean can to delete in program list

    Then Vice Dean can not "delete"
