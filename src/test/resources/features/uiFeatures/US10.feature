Feature: Vice Dean should be able to see the Lesson list

  Background:
    Given Kullanici "url" sayfasina gider
    Then Kullanici 3 saniye bekler
    Then Kullanici Login yazisina tiklar
    Then Kullanici User Name alanina "usernameViceDean" password alanina "password" degerini girip giris yapar
    Then Kullanici 2 saniye bekler
    Then Kullanici acilan ekranda Lesson Program bolumune tiklar
    Then Kullanici 2 saniye bekler

  @Pozitif
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
    Then Kullanici "Created Lesson Program" yazisinin gorunurlugunu dogrular

  @Negatif
  Scenario: Vice Dean Zorunlu Alanlari Doldurmadan Ders Programi Olusturamamalı (Negatif test)
    Then Kullanici Submit Butonuna tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici Required alanlarinin gorunurlugunu dogrular
    Then Kullanici 3 saniye bekler

  @Negatif
  Scenario: Vice Dean Zorunlu Alanlari Doldurmadan Ders Programi Olusturamamalı (Negatif test)
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunden en ustteki dersi secer
    Then Kullanici 2 saniye bekler
    Then Kullanici Add Lesson Program alanindaki Start Time bolumune "09:30" degerini girer
    Then Kullanici Add Lesson Program alanindaki Stop Time bolumune "11:00" degerini girer
    Then Kullanici Submit Butonuna tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "You have entered an invalid value. Valid values are: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY" yazisinin gorunurlugunu dogrular
    Then Kullanici hata mesajinin ekran goruntusunu alir

  @Negatif
  Scenario: Vice Dean Zorunlu Alanlari Doldurmadan Ders Programi Olusturamamalı (Negatif test)
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunden en ustteki dersi secer
    Then Kullanici 2 saniye bekler
    Then Kullanici Add Lesson Program alanindaki Start Time bolumune "09:30" degerini girer
    Then Kullanici Add Lesson Program alanindaki Stop Time bolumune "11:00" degerini girer
    Then Kullanici Add Lesson Program alanindaki Choose Day menusunden "THURSDAY" secer
    Then Kullanici Submit Butonuna tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "Please select education term" yazisinin gorunurlugunu dogrular
    Then Kullanici hata mesajinin ekran goruntusunu alir

  @Negatif
  Scenario: Vice Dean Ders Programi pozitif test
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Select Lesson menusunden en ustteki dersi secer
    Then Kullanici 2 saniye bekler
    Then Kullanici Add Lesson Program alanindaki Choose Education Term menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Choose Education Term menusunden "FALL_SEMESTER" secer
    Then Kullanici Add Lesson Program alanindaki Choose Day menusunun erisilebilir oldugunu dogrular
    Then Kullanici Add Lesson Program alanindaki Choose Day menusunden "WEDNESDAY" secer
    Then Kullanici Add Lesson Program alanindaki Start Time bolumune "10:00" degerini girer
    Then Kullanici Add Lesson Program alanindaki Stop Time bolumune "09:00" degerini girer
    Then Kullanici 3 saniye bekler
    Then Kullanici Submit Butonuna tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "Error: start time must not be greater than or equal to stop time" yazisinin gorunurlugunu dogrular
    Then Kullanici hata mesajinin ekran goruntusunu alir
