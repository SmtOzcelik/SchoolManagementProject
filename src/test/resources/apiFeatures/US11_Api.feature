@dean
Feature: US11 Vice Dean can to delete lesson in lesson program
  Scenario: Vice Dean send a post and delete this post
    Given send post lesson program day "MONDAY" , educationTermID 1 ,lessonidList 2 ,startTime "10:00", stopTime "11:00" as Vice Dean
    Then delete the posted lessonProgram
