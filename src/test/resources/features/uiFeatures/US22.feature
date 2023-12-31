@Admin
Feature: Admin kayit US22

  Background:
    Given Kullanici anasayfaya girer
    Then  Kullanici Login  tiklar
    And Kullanici User Name girer
    And Kullanici Password girer
    And Kullanici Login butonuna tiklar
    And Kullanici Name "samet" girer
    And Kullanici  Surname "ozcelik" girer
    And Kullanici Birth Place "karaman" girer
    And Kullanici Gender tiklar
    And Kullanici Date Of Birth "01-08-1991" girer

  Scenario:  Pozitif Admin tc01

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecerli Password "Ab142788." girer
    And Kullanici submit butonu tiklar
    And Kullanici Dean Saved uyarisinin görünürlügünü test eder

  Scenario: Negatif gecersiz eksik phone number tc02

    And Kullanici  gecersiz eksik "395 254 54"Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecerli Password "Ab142788." girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali phone number den dolayi giris yapilamadigini dogrular

  Scenario: Negatif gecersiz phone number tc03

    And Kullanici  gecersiz eksik "3954 2544 5444"Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecerli Password "Ab142788." girer
    And Kullanici submit butonu tiklar
    And Kullanici Please enter valid phone uyarisinin gorunurlugunu test eder

  Scenario: Negatif gecersiz eksik Ssn number tc04

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecersiz eksik "123-8-4" Ssn numarisi girer
    And Kullanici Name girer
    And Kullanici gecerli Password "Ab142788." girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali Ssn number den dolayi giris yapilamadigini dogrular

  Scenario: Negatif gecersiz Ssn number tc05

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecersiz "1234-8-4777" Ssn numarisi girer
    And Kullanici Name girer
    And Kullanici gecerli Password "Ab142788." girer
    And Kullanici submit butonu tiklar
    And Kullanici Please enter valid Ssn uyarisinin gorunurlugunu test eder

  Scenario: Negatif  gecersiz eksik Password tc06

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecersiz eksik "Ab142" password girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali eksik password den dolayi giris yapilamadigini dogrular

  Scenario:  Negatif  gecersiz büyük harf olmadan password tc07

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecersiz eksik "ab142797" password girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali password buyuk harf olmadıgından dolayi giris yapilamadigini dogrular

  Scenario:  Negatif  gecersiz kucuk harf olmadan password tc08

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecersiz eksik "A12B1478" password girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali password kucuk harf olmadıgından dolayi giris yapilamadigini dogrular

  Scenario:  Negatif  gecersiz kucuk ve buyuk harf olmadan password tc09

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecersiz eksik "12345678" password girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali password kucuk ve buyuk harf olmadıgından dolayi giris yapilamadigini dogrular

  Scenario: Negatif  gecersiz rakam olmadan password tc10

    And Kullanici  gecerli Phone numarasi girer
    And Kullanici gecerli Ssn numarasi girer
    And Kullanici Name girer
    And Kullanici gecersiz eksik "AbDakakg" password girer
    And Kullanici submit butonu tiklar
    And Kullanici hatali password rakam olmadıgından dolayi giris yapilamadigini dogrular