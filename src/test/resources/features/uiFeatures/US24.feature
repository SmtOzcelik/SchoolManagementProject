Feature: Admin, teacher must be created.

  Background:
    Given Kullanici "url" sayfasina gider
    Then Kullanici 3 saniye bekler
    Then Kullanici Login yazisina tiklar
    Then Kullanici User Name alanina "username" password alanina "password" degerini girip giris yapar
    Then Kullanici 2 saniye bekler
    Then Kullanici Menu tiklar
    Then Kullanici 2 saniye bekler
    Then Kullanici Teacher Management yazisina tiklar

  Scenario: Admin Teacher Olusturabilmeli
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then kullanici Add Teacher formu doldurur
    Then Kullanici 3 saniye bekler
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "Teacher saved successfully" yazisinin gorunurlugunu dogrular
