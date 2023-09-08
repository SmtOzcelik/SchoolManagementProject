@US_13_TC_01
Feature: Vice Dean should be able to create teacher

  Background: Sign in as vice dean
    Given Kullanici anasayfaya girer
    When Kullanici Login  tiklar
    And Kullanici User Name girer "Ilyas.Cnz"
    And Kullanici Password girer "03122009Fb"
    And Kullanici Login butonuna tiklar

  Scenario Outline:TC_01_create_teacher_successfully
    Given vice dean clicks on Teacher Management Option
    When vice dean enter "<lesson>"
    And vice dean enter "<name>","<surname>"
    And vice dean enter "<birthplace>" , "<email>" , "<phonenumber>"
    And vice dean choose gender
    And vice dean enter "<dateofbirth>", "<ssn>", "<username>" and "<password>"
    And vice dean click on the submitt button
    Then verify teacher saved successfully

    Examples:
      | lesson   | name  | surname | birthplace | email            | phonenumber  | dateofbirth | ssn         | username   | password |
      | Calculus | fatma | naz     | ulubey     | email102@email02 | 706-536-5584 | 02-10-1976  | 444-99-3373 | fatmanaz79 | 12345678Aa |

