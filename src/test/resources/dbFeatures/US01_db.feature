@US01DataBaseTest
Feature: Aday öğrenciler sisteme kayıt olabilmelidir.

  Scenario Outline: US01_GuestUser

    Given "<username>" ile guest useri cagir

    Then body sunlari icermeli: "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>"
    Examples:
      | name     | surname   | birthplace | phone        | gender | Date Of Birth | ssn         |  username  |
      |Eric9     |Kertzmann  | Eric9      | 473-150-3860 | 1      | 2001-11-24    | 633-93-6139 |Viki8       |

  @US02DataBaseNegative
  Scenario: Silinen guest useri dogrula
    Given silinen "Viki8" ile guest useri cagir
    Then tablein bos oldugunu dogrula

