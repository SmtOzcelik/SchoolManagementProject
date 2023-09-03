Feature: Vice Dean should be able to see the Lesson list

  Background:
    Given Kullanici "url" sayfasina gider
    Then Kullanici 3 saniye bekler
    Then Kullanici Login yazisina tiklar
    Then Kullanici User Name alanina "usernameViceDean" password alanina "password" degerini girip giris yapar
    Then Kullanici 2 saniye bekler
    Then Kullanici acilan ekranda Lesson Program bolumune tiklar
    Then Kullanici 2 saniye bekler

  Scenario: Vice Dean Ders Programi pozitif test
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunden en ustteki dersi secer
    Then Kullanici 2 saniye bekler
    Then Kullanici Add Lesson Program alanindaki Choose Education Term menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Choose Education Term menusunden "SPRING_SEMESTER" secer
    Then Kullanici Add Lesson Program alanindaki Choose Day menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Choose Day menusunden "FRIDAY" secer
    Then Kullanici Add Lesson Program alanindaki Start Time bolumune "14:30" degerini girer
    Then Kullanici Add Lesson Program alanindaki Stop Time bolumune "15:00" degerini girer
    Then Kullanici 3 saniye bekler
    Then Kullanici Submit Butonuna tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici Created Lesson Program yazisinin gorunurlugunu dogrular

