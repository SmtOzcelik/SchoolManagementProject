Feature: Admin, teacher must be created.

  Background:
    Given Kullanici "url" sayfasina gider
    Then Kullanici 3 saniye bekler
    Then Kullanici Login yazisina tiklar
    Then Kullanici User Name alanina "username" password alanina "password" degerini girip giris yapar
    Then Kullanici 2 saniye bekler
    Then Kullanici Menu tiklar
    Then Kullanici 2 saniye bekler
    Then Kullanici Teacher Management yazisina tiklar

  Scenario: Admin Teacher Olusturabilmeli TC01
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then kullanici Add Teacher formu doldurur
    Then Kullanici 3 saniye bekler
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "Teacher saved successfully" yazisinin gorunurlugunu dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin Zorunlu Alanlari Doldurmadan Teacher Oluşturamamalı (Negatif Test) TC02
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Kullanici submit butonu tiklar
    Then Required yazisini dogrula (Name)
    Then Required yazisini dogrula (Surname)
    Then Required yazisini dogrula (Birth Place)
    Then Required yazisini dogrula (Email )
    Then Required yazisini dogrula (Phone Number)
    Then Required yazisini dogrula (Date Of Birth)
    Then Required yazisini dogrula (Ssn )
    Then Required yazisini dogrula (UserName)
    Then Enter your password yazisini dogrula
    Then Kullanici sayfayi kapatir


  @Negatif
  Scenario: Admin Gender Doldurmadan Teacher Oluşturamamalı (Negatif Test) TC03
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Cinsiyet seçilmez.
    Then Doğum tarihi girilir.
    Then Geçerli SSN girilir.
    Then Username girilir.
    Then Geçerli password girilir.
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "You have entered an invalid value. Valid values are: MALE, FEMALE" yazisinin gorunurlugunu dogrular
    Then Kullanici sayfayi kapatir


  Scenario: Admin SSN bilgilerini geçersiz girdiğinde Teacher Oluşturamamalı (Negatif Test) TC04
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "12-345-6789" SSN degeri girer
    Then Username girilir.
    Then Geçerli password girilir.
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici "Please enter valid SSN number" yazisinin gorunurlugunu dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin SSN bilgilerini geçersiz girdiğinde Teacher Oluşturamamalı (Negatif Test) TC05
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123456789" SSN degeri girer
    Then Username girilir.
    Then Geçerli password girilir.
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici SSN uyari mesajinin gorunurlugunu dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin geçersiz password girdiğinde Teacher Oluşturamamalı (Negatif Test) TC06
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123-45-6710" SSN degeri girer
    Then Username girilir.
    Then Kullanici "Aa12345" password girer
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici hatali eksik password den dolayi giris yapilamadigini dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin geçersiz password girdiğinde Teacher Oluşturamamalı (Negatif Test) TC07
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123-45-6710" SSN degeri girer
    Then Username girilir.
    Then Kullanici "aa123456" password girer
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici hatali password buyuk harf olmadıgından dolayi giris yapilamadigini dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin geçersiz password girdiğinde Teacher Oluşturamamalı (Negatif Test) TC08
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123-45-6710" SSN degeri girer
    Then Username girilir.
    Then Kullanici "AA123456" password girer
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici hatali password kucuk harf olmadıgından dolayi giris yapilamadigini dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin geçersiz password girdiğinde Teacher Oluşturamamalı (Negatif Test) TC09
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123-45-6710" SSN degeri girer
    Then Username girilir.
    Then Kullanici "12345678" password girer
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici hatali password kucuk ve buyuk harf olmadıgından dolayi giris yapilamadigini dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin geçersiz password girdiğinde Teacher Oluşturamamalı (Negatif Test) TC10
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Geçerli telefon numarası girilir.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123-45-6710" SSN degeri girer
    Then Username girilir.
    Then Kullanici "Aabcdefgh" password girer
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici hatali password rakam olmadıgından dolayi giris yapilamadigini dogrular
    Then Kullanici sayfayi kapatir

  Scenario: Admin geçersiz phone girdiğinde Teacher Oluşturamamalı (Negatif Test) TC11
    Then Kullanici Choose Lessons'dan herhangi bir ders secer
    Then Name girilir.
    Then Surname girilir.
    Then Birth place girilir.
    Then Geçerli e-mail girilir.
    Then Kullanici "123-456-789" telefon numarasi girer.
    Then ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.
    Then Kullanici cinsiyet girer
    Then Doğum tarihi girilir.
    Then Kullanici "123-45-6710" SSN degeri girer
    Then Username girilir.
    Then Kullanici "Aa123456" password girer
    Then Kullanici submit butonu tiklar
    Then Kullanici 1 saniye bekler
    Then Kullanici hatali phone number den dolayi giris yapilamadigini dogrular
    Then Kullanici sayfayi kapatir






























































    #cenario Outline:TC02 Vice Dean ogretmen olusturabilmelidir.
# And kullanici "<Name>" "<Surname>" "<Birth Place>" "<Email>""<Phone>" "<Gender>" "<Date Of Birth>" "<Ssn>" "<User Name>" "<Password>" bilgilerini girer
# Then Kullanici 5 saniye bekler
# And kullanici  bos birakilan name alaninda Required uyari yazisi geldigini dogrular
# And kullanici  bos birakilan Surname alaninda Required uyari yazisi geldigini dogrular
# * kullanici  bos birakilan Birth Place alaninda Required uyari yazisi geldigini dogrular
# * kullanici  bos birakilan Email alaninda Required uyari yazisi geldigini dogrular
# * kullanici  bos birakilan Phone Number alaninda Required uyari yazisi geldigini dogrular
# * kullanici  bos birakilan Date Of Birth alaninda Required uyari yazisi geldigini dogrular
# * kullanici  bos birakilan SSN alaninda Required uyari yazisi geldigini dogrular
# * Kullanici Menu tiklar
# Then Kullanici LogOut'a tiklar
# Then Kullanici Yes'e tiklar ve cikis yapar
# Examples:
#   | Name    | Surname | Birth Place | Email             | Phone        | Gender | Date Of Birth | Ssn         | User Name  | Password     |
#   |         | can     | adana       | abcd@gmail.com    | 321-678-1400 | Male   | 09.12.1997    | 327-50-9610 | bahadir235 | Aa1234567.   |
#   | Bahadir |         | izmir       | abcde@hotmail.com | 670-410-8536 | Male   | 12.10.1999    | 974-10-2000 | bahadir007 | Ab123123123. |
# #| Name    | Surname |             | Email             | Phone        | Gender | Date Of Birth | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place |                   | Phone        | Gender | Date Of Birth | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place | abcd              | Phone        | Gender | Date Of Birth | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place | abcd@             | Phone        | Gender | Date Of Birth | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place | Email             |              | Gender | Date Of Birth | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place | Email             | Phone        |        | Date Of Birth | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place | Email             | Phone        | Gender |               | Ssn         | User Name  | Password     |
# #| Name    | Surname | Birth Place | Email             | Phone        | Gender | Date Of Birth |             | User Name  | Password     |
# #| Name    | Surname | Birth Place | Email             | Phone        | Gender | Date Of Birth | Ssn         |            | Password     |
# #| Name    | Surname | Birth Place | Email             | Phone        | Gender | Date Of Birth | Ssn         | User Name  |              |
























