Feature: US10 Vice Dean'in ders programi olusturma islemi
  Scenario: TC01 Vice Dean basarili bir sekilde ders programi olusturabilmeli
    Given ders programi olusturmak icin POST request hazirligi yapilir
    And gonderilecek ders programi bilgileri hazirlanir
    When ders programi olusturmak icin POST request gonderilir
    Then olusturulan ders programi bilgileri dogrulanir

