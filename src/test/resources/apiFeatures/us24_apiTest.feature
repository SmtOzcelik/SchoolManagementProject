@admin
Feature: US24 Admin'in Ogretmen olusturma islemi
  Scenario: TC01 Admin öğretmen oluşturabilmelidir.
    Given Ogretmen olusturmak icin POST request hazirligi yapilir.
    And gonderilecek ogretmen bilgileri hazirlanir.
    When ogretmen olusturmak icin POST request gonderilir.
    Then olusturulan ogretmen bilgileri dogrulanir.

