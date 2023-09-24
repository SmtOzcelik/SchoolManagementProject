@US01DataBaseTest
Feature: Aday öğrenciler sisteme kayıt olabilmelidir.

  Scenario Outline: US01_GuestUser

    Given "<username>" ile guest useri cagir

    Then body sunlari icermeli: "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>"
    Examples:
      | name     | surname   | birthplace | phone        | gender | Date Of Birth | ssn         |  username  |
      |Vaery     |Kelby      | Venero     | 473-151-3861 | 1      | 2001-11-24    | 633-91-6131 |Vner8956    |

  @US02DataBaseNegative
  Scenario: Silinen guest useri dogrula
    Given silinen "Vner8956" ile guest useri cagir
    Then tablein bos oldugunu dogrula

