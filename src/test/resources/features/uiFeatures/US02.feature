@guestuser
Feature: Guest_User_Goruntuleme_Silme
  Background:
    Given Admin olarak "url" adresine gider
    Then Admin olarak Login ikonunu tiklar
    And Admin olarak username kutusununa "username" girer
    And Admin olarak password kutusuna "password" girer
    And Admin olarak Login butonunu tiklar
    And Admin olarak Menu butonuna basar
    And Admin olarak Guest User linkini tiklar

  Scenario: US02 TC01 Admin, Guest User List bilgilerini gorebilmeli
    Given Admin Guest_User List'i gorur
    And Admin Guest_User Name bilgilerini gorur
    And Admin Guest_User Phone Number bilgilerini gorur
    And Admin Guest_User SSN bilgilerini gorur
    And Admin Guest_User User Name bilgilerini gorur

  Scenario: US02 TC02 Admin, Guest User List bilgilerini silebilmeli
    Given Admin Guest_User Delete butonunu gorur
    And Admin olarak Delete butonunu tiklar
    And Admin uyari mesajini gorerek silme isleminin tamamlandigini gorur