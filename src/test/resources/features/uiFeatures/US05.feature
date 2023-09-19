Feature:Admin Dean ile ilgili işlemler
  Background:
    Given Kullanici "url" sayfasina gider.
    And Kullanici 2 saniye bekler




  Scenario: Admin, Dean leri görebilmeli ve silebilmeli
    Then kullanici logine tiklar
    And username alanina tiklar ve "username" girer
    And "password" girer
    And login butona tiklar ve sayfaya giris yaptigini dogrular
    And Kullanici 2 saniye bekler
    And menu butonuna tiklar
    And Kullanici 1 saniye bekler
    And main menuden dean managemente tiklar ve dogrular
    And Dean'lerin Name, Gender, Phone Number, SSN, User Name bilgilerini gorebilmeli
    And Kullanici 2 saniye bekler

    And dean'leri guncelleyebilmeli ve guncellendigini dogrulamali
    And dean'leri silebilmeli ve silindigini dogrulamali
    And dean'leri guncelleyebilmeli ve guncellendigini dogrulamali


