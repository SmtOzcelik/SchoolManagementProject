@Dean
  Feature: Dean kayit

    Background:
      Given Kullanici anasayfaya girer
      Then  Kullanici Login  tiklar
        And Kullanici User Name girer
        And Kullanici Password girer
        And Kullanici Login butonuna tiklar
        And Kullanici Menu tiklar
        And Kullanici Dean Management tiklar
        And Kullanici Name girer
        And Kullanici  Surname girer
        And Kullanici Birth Place girer
        And Kullanici Gender tiklar
        And Kullanici Date Of Birth girer


    Scenario:  Pozitif Dean tc05

        And Kullanici  gecerli Phone numarasi girer
        And Kullanici gecerli Ssn numarasi girer
        And Kullanici Name girer
        And Kullanici gecerli Password girer
        And Kullanici Submit butonuna tiklar
        And Kullanici Dean Saved uyarisinin görünürlügünü test eder


      Scenario: Negatif gecersiz eksik phone number tc06

        And Kullanici  gecersiz eksik Phone numarasi girer
        And Kullanici gecerli Ssn numarasi girer
        And Kullanici Name girer
        And Kullanici gecerli Password girer
        And Kullanici Submit butonuna tiklar