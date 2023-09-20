@dean
Feature: US 12 Vice Dean can create a lesson program

  Scenario: Vice Dean creat a lesson program
    Given send post lesson program day "WEDNESDAY" , educationTermID 1 ,lessonidList 2 ,startTime "11:00", stopTime "13:00" as Vice Dean
    Then Do Assertion creat lesson program
