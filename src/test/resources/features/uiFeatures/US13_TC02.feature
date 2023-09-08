@US_13_TC_02
Feature: Vice Dean should be able to create teacher

  Background: Sign in as vice dean
    Given Kullanici anasayfaya girer
    When Kullanici Login  tiklar
    And Kullanici User Name girer "Ilyas.Cnz"
    And Kullanici Password girer "03122009Fb"
    And Kullanici Login butonuna tiklar


  Scenario: TC_01_missing_parameters_creating_teacher
    Given vice dean clicks on Teacher Management Option
    And vice dean click on the Submit button
    And vice dean verify the required texts displayed
