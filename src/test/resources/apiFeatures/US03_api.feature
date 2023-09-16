@dean
  Feature: US03 Contact Messages API test

    Scenario Outline: Pozitif test

      Given Kullanici path params olusturur Contact
      Then  Kullanici expected data olusturur "<email>" "<message>" "<name>" "<subject>"
      When  Kullanici request gonderir response alir Contact
      And   Kullanici dogrulama yapar Contact Pozitif

      Examples:
      |email       |message      |name|subject|
      |st@gmail.com|Hello world@0|samet|java  |

    Scenario Outline: Negitif test
      Given Kullanici path params olusturur Contact
      Then  Kullanici expected data olusturur "<email>" "<message>" "<name>" "<subject>"
      When  Kullanici request gonderir response alir Contact
      And   Kullanici dogrulama yapar Contact negatif

      Examples:
        |email       |message      |name|subject|
        |stgmail.com|Hello world@0|samet|java  |