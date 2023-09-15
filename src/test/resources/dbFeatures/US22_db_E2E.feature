@dean

Feature: US22 Admin ekleme E2E test

  Scenario Outline: Pozitif Admin ekleme

    Given Kullanici ana sayfa "https://managementonschools.com/" girer
    Then  Kullanici Login  tiklar
    And   Kullanici User Name girer
    And   Kullanici Password girer
    And   Kullanici Login butonuna tiklar
    And   Kullanici girer "<name>","<surname>","<birth place>","<phone number>","<gender>","<birthday>","<ssn>","<username>","<password>"
    And   Kullanici submit butonu tiklar

    Examples:
      |name|surname|birth place|phone number|gender|birthday   |ssn        |username|password|
      |samet|ozcelik|canakkale|444 600 5879 |Male  |12-12-2012 |444-66-1256|samet123|Ab142700|

  @database
  Scenario: Database de Admin ekleme dogrulama

    Given Kullanici datebase baglantisini oluştururAdmin
    Then Kullanici username ile sorgulama yapar

