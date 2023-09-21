@US01Api @Api @guest

Feature:  Aday öğrenciler sisteme kayıt olabilmelidir.

  Scenario Outline: Guest User US001

    Given tum guest userlar icin get request yap

    Then gelen bodyi dogrula "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>"
    Examples:
      | name     | surname | birthplace | phone        | gender | Date Of Birth | ssn         |username  |
      |Mel4      |Barrows  | Mel4       | 815-747-6238 | FEMALE | 1983-11-13    | 383-51-8589 |Lissette7 |


  @US01ApiNegative @guest
  Scenario: Guest User US001 Negative

    Given tum guest userlar icin get request yap

    Then username "Lissete7" ile yapilan filtremenin bos oldugunu dogrula
