Feature: "Vice Dean ders listesini görebilmeli ve güncellemeler yapabilmelidir.
  (Lessons - Lesson List)"

  Background:
    Given Kullanici "url" sayfasina gider
    Then Kullanici 3 saniye bekler
    Then Kullanici Login yazisina tiklar
    Then Kullanici User Name alanina "usernameViceDean" password alanina "password" degerini girip giris yapar
    Then Kullanici 2 saniye bekler


  Scenario: "Vice Dean ders listesini görebilmeli ve güncellemeler yapabilmelidir.
  (Lessons - Lesson List)"
    Then Kullanici acilan ekranda Lessons bolumune tiklar
    Then Kullanici 2 saniye bekler
    Then Kullanici Lesson Name,Compulsory ve Credit Score gorundugunu dogrular
    Then Kullanici Ders Listesinin ekran goruntusunu alir
    Then Kullanici Java dersinin yanindaki silme butonuna tiklar
    Then Kullanici Java dersinin silinmedigini dogrular