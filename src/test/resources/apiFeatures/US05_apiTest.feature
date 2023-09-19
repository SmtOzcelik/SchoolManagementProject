@admin
Feature:Admin olarak Dean dogrulama islemleri

  Scenario: Admin Dean leri gorebilmeli
    Given Kullanici kayitli dean verilerinin ID numaralarini alir ve dean verilerinin oldugunu dogrular


  Scenario Outline: Admin Dean leri guncelleyebilmeli
    Given Kullanici path params olusturur..
    And Kullanici expected data olusturur."<password>", username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"
    And kullanici request gonderir ve response alir
    Then Kullanici dogrulama yapar..
    Examples:
      | password  | username    | name      | surname  | birthDay   | ssn         | birthPlace | phoneNumber  | gender |
      | Aa123456. | ayseldidins | DeanTeam3 | Batch153 | 1984-11-27 | 443-72-8338 | Eskisehir  | 952 349 9301 | FEMALE |