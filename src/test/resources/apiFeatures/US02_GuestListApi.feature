@US02Api @admin
Feature:Admin Guest User Listi gorebilmelidir.

  @US02ApiGet @admin
  Scenario Outline:US02 Admin Guest User'larin Name, Phone Number, SSN, User Name bilgilerini görebilmeli

    Given Admin tum Guest User bilgilerini gorebilir

    Then Admin Guest User List, "<name>" "<surname>" "<phoneNumber>" "<ssn>" "<username>" bilgilerini dogrular
    Examples:
      | name         | surname    |  phoneNumber    | ssn         | username      |
      | usame        |  emasu     |  246-663-6589   | 856-65-6559 | emasu21       |


  @US02ApiDelete @admin
  Scenario: US02 Admin Guest User silebilmeli

    Given Admin silecegi Guest User bilgilerini delete request yapar

    Then Guest Userin silindigini dogrular


