@vicedean
Feature:Dean olarak Vice Dean ile ilgili işlemler yapma

  Background:
    Given Kullanici "url" sayfasina gider.
    And Kullanici 2 saniye bekler
    And  kullanici logine tiklar
    And Kullanici 2 saniye bekler
    And Kullanici username alanina tiklar ve "deanUserName" girer
    And "password" girer
    And login butona tiklar ve sayfaya giris yaptigini dogrular
    And Kullanici 2 saniye bekler


  Scenario: Dean Vice Dean hesabı oluşturabilmeli (Pozitif Test)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And Kullanici "ViceDeanSSNnNo" girer. SSN; ucuncu ve besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPassword" girer.Password en az sekiz karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.
    And Kullanici submit butona tiklar
    Then Kullanici ekleme isleminin basarili olugunu dogrular

  Scenario Outline: DB ile Vice Dean hesabini dogrulama
    Given Data Base ile baglan
    When vice dean bilgilerini "<ssn>" ile al
    Then vice dean bilgilerini DB ile dogrula.username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"
    Examples:
      | ssn         | username       | name  | surname  | birthDay   | birthPlace | phoneNumber | gender |
      | 369-85-1456 | Salih Gultekin | salih | gultekin | 2000-01-01 | gebze      | 456-789-3574 | 0 |



