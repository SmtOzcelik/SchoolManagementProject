@Contact
  Feature: Contact

    Background:
     Given Kullanici anasayfaya girer
     When Kullanici Contact butonuna tıklar


    Scenario:Pozitif Contact işlemi

      And Kullanici Your name kutucuguna gecerli name "samet" girer
      And Kullanici Your email kutucuguna gecerli mail "smt@gmail.com" girer
      And Kullanici Subject kutucuguna gecerli ders "java" girer
      And Kullanici Message kutucuguna gecerli mesaj "yeni mail adresim smt40.!-@gmail.com" girer
      And Kullanici Send Message butonuna tiklar
      And Kullanici Contact Message Created Successfully uyarisini gorunurlugunu test eder