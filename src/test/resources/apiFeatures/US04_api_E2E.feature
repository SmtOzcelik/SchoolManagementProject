@US04Api_E2E

  Feature: US04 E2E Test

    Scenario Outline: US04 Pozitif Dean Test

      Given Kullanici ana sayfa url girer
      Then  Kullanici Login  tiklar
      And   Kullanici User Name girer
      And   Kullanici Password girer
      And   Kullanici Login butonuna tiklar
      And   Kullanici Menu tiklar
      And   Kullanici Dean Management tiklar
      And   Kullanici verileri girer "<name>","<surname>","<birth place>","<phone number>","<gender>","<birthday>","<ssn>","<username>","<password>"
      And   Kullanici submit butonu tiklar

      Examples:
        |name|surname|birth place|phone number|gender|birthday   |ssn        |username|password|
        |samet|ozcelik|canakkale|444 600 5879 |Male  |12-12-2012 |444-66-1256|samet123|Ab142700|


      Scenario: US04 Pozitif Dean Api Test

        Given Kullanici kayitli dean verisinin ID numarasini alir
        Then Kullanici dean verilerini hazirlar ve ID ile cagirilir
        And  Kullanici dean bilgilerini dogrular


        Scenario: US04 Pozitif Dean DATABASE Test

          Given Kullanici kayitli dean ID ile sorgulanir
          Then Kullanici dean bilgilerini dogrular DB


        Scenario: Kayitli dean bilgisini API ile silme
          Given Kullanici dean verisini siler