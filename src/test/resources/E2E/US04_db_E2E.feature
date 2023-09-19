@dean

Feature: US04 dean ekleme E2E test

    Scenario Outline: Pozitif Dean ekleme

      Given Kullanici ana sayfa url girer.
      Then  Kullanici Login  tiklar
      And   Kullanici User Name girer
      And   Kullanici Password girer
      And   Kullanici Login butonuna tiklar
      And   Kullanici Menu tiklar
      And   Kullanici Dean Management tiklar
      And   Kullanici girer "<name>","<surname>","<birth place>","<phone number>","<gender>","<birthday>","<ssn>","<username>","<password>"
      And   Kullanici submit butonu tiklar

  Examples:
    |name|surname|birth place|phone number|gender|birthday   |ssn        |username|password|
    |samet|ozcelik|canakkale|444 600 5879 |Male  |12-12-2012 |444-66-1256|samet123|Ab142700|

    Scenario: US04 dean databese dogrulama
      Given Kullanici datebase baglantisini oluşturur Dean
      Then  Kullanici dean datebase sorgulamasini gerceklestirir


    Scenario: kayit edilen dean i API ile silme
      Given Kullanici dean datasinin id sini api ile cagirir
      Then Kullanici dean datasini id ile siler











