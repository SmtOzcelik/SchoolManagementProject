@US23
Feature: US23 ViceDean Account Created Process

  Background:
    Given User goes to "url"
    Then User waits 3 seconds
    Then User clicks to login button
    Then User enters an adminUsername, password and then is logged in.
    Then User waits 3 seconds

  Scenario: Admin create viceDean account
    Then User enters "Name" "Surname" "Birth Place" "Gender" "Birthday" "PhoneNumber"
    And User enters "ViceDeanSSNnNo"
    And User enters "ViceDeanUserName"
    And User enters "ViceDeanPassword"
    And User clicks submit buttton
    And User waits 3 seconds
    Then User verifies that viceDean is created


  Scenario: Dean Vice Dean hesabı oluşturabilmeli (negatif test 1)
    Then Kullanici Name Surname Birth Place Cinsiyet Dogum tarihi Tel No bos birakarak girer
    And Kullanici ViceDeanSSNnNo  bos birakarak girer.
    And kullanici ViceDeanUserName  bos birakarak girer
    And kullanici ViceDeanPassword  bos birakarak girer.
    And Kullanici submit butona tiklar
    Then Kullanici hata mesajinin ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 2)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And Kullanici ViceDeanSSNnNo  bos birakarak girer.
    And kullanici ViceDeanUserName  bos birakarak girer
    And kullanici "ViceDeanPassword" girer.Password en az sekiz karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.
    And Kullanici submit butona tiklar
    Then Kullanici hata aldigini dogrular ve ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 3)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And  Kullanici "ViceDeanSSNnNo2" girer. SSN; ucuncu rakamdan sonra - icermeli besinci rakamdan sonra - icermemeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPassword" girer.Password en az sekiz karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.
    And Kullanici submit butona tiklar
    And Kullanici 2 saniye bekler
    Then Kullanici hata aldigini dogrular ve ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 4)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And  Kullanici "ViceDeanSSNnNo3" girer. SSN; ucuncu rakamdan sonra - icermemeli besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPassword" girer.Password en az sekiz karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.
    And Kullanici submit butona tiklar
    And Kullanici 2 saniye bekler
    Then Kullanici hata aldigini dogrular ve ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 5)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And Kullanici "ViceDeanSSNnNo" girer. SSN; ucuncu ve besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPassword" girer.Password en az yedi karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.
    And Kullanici submit butona tiklar
    And Kullanici 2 saniye bekler
    Then Kullanici at least eight yazisini gordugunu dogrular ve ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 6)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And Kullanici "ViceDeanSSNnNo" girer. SSN; ucuncu ve besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPasswordBuyukHarfYok" girer.Password en az sekiz karakterden olusmalidir,buyuk harf icermemeli, kucuk harf ve bir rakam icermelidir.
    And Kullanici submit butona tiklar
    And Kullanici 2 saniye bekler
    Then Kullanici One uppercase character yazisini gordugunu dogrular ve ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 7)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And Kullanici "ViceDeanSSNnNo" girer. SSN; ucuncu ve besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPasswordKucukHarfYok" girer.Password en az sekiz karakterden olusmalidir,buyuk harf ve bir rakam icermelidir.kucuk harf icermemeli
    And Kullanici submit butona tiklar
    And Kullanici 2 saniye bekler
    Then Kullanici One lowercase character yazisini gordugunu dogrular ve ekran goruntusunu alir.

  Scenario:Dean Vice Dean hesabı oluşturabilmeli (negatif test 8)
    Then Kullanici "Name" "Surname" "Birth Place" "Cinsiyet" "Dogum tarihi" "Tel No" girer
    And Kullanici "ViceDeanSSNnNo" girer. SSN; ucuncu ve besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.
    And kullanici "ViceDeanUserName" girer
    And kullanici "ViceDeanPasswordKucukHarfYok" girer.Password en az sekiz karakterden olusmalidir,buyuk harf ve kucuk harf icermeli rakam icermemelidir.
    And Kullanici submit butona tiklar
    And Kullanici 2 saniye bekler
    Then Kullanici One number yazisini gordugunu dogrular ve ekran goruntusunu alir.




