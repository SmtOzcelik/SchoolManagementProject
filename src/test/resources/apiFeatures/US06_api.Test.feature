@dean
Feature:  Dean olarak Vice Dean ile ilgili işlemler yapma

  Scenario Outline: Dean Vice Dean hesabı oluşturabilmeli(Pozitif Test)
    Given Kulllanici PathParam olusturur
    When Kullanici expected data olusturur! password="<password>", username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"
    And Kullanici requset gonderir ve response alir.
    Then Kullanici dogrulama yapar.
    Examples:
      | password  | username    | name   | surname | birthDay   | ssn         | birthPlace | phoneNumber  | gender |
      | Aa123456. | Salihgltknn | Salihh | gltknnn | 2000-09-07 | 435-64-9676 | Turkey     | 567-494-7765 | MALE   |


  Scenario Outline: Dean Vice Dean hesabı oluşturabilmeli(Negatif test)
    Given Kulllanici PathParam olusturur
    When Kullanici expected data olusturur! password="<password>", username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"
    And Kullanici requset gonderir ve response alir.
    Then Kullanici dogrulama yapar.(negatif Test)
    Examples:
      | password  | username    | name   | surname | birthDay   | ssn         | birthPlace | phoneNumber  | gender |
      | aa123456. | Salihgltknn | Salihh | gltknnn | 2000-09-07 | 435-64-9676 | Turkey     | 567-494-7765 | MALE   |


  Scenario Outline: Dean Vice Dean hesabı oluşturabilmeli(Negatif test)
    Given Kulllanici PathParam olusturur
    When Kullanici expected data olusturur! password="<password>", username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"
    And Kullanici requset gonderir ve response alir.
    Then Kullanici dogrulama yapar.(negatif Test)
    Examples:
      | password  | username    | name   | surname | birthDay   | ssn        | birthPlace | phoneNumber  | gender |
      | Aa123456. | Salihgltknn | Salihh | gltknnn | 2000-09-07 | 435-4-9676 | Turkey     | 567-494-7765 | MALE   |
