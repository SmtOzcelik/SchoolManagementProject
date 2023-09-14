@US04_api

Feature: US04 Api dogrulama testleri

  Scenario: US04 TC01 Pozitif Api Test

    Given Kullanici path params olusturur
    And   Kullanici expected data olusturur.
    When  Kullanici request gonderir response alir.
    And   Kullanici kayitlari dogrular.

