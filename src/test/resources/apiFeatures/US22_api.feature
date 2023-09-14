@US22_api

  Feature: US22 Api Doğrulama Testleri

    Scenario: US22 TC01 Pozitif Api Test

      Given Kullanici path params olusturur.
      Then  Kullanici expected data olusturur
      When Kullanici request gonderir ve response alir
      And Kullanici dogrulama yapar
