package utilities;

import pages.US_9_10_24.BahadirPage;

public class Methods {
    BahadirPage bahadir = new BahadirPage();

    public Methods teacheradd(String nameValue, String surnameValue, String birthPlaceValue,
                              String eMailValue,
                              String phoneNumberValue, String genderValue, String birthDayValue,
                              String ssnValue, String userNameValue, String passwordValue) {
        if (nameValue != null) {
            bahadir.name.sendKeys(nameValue);
        }
        if (surnameValue != null) {
            bahadir.surname.sendKeys(surnameValue);
        }
        if (birthPlaceValue != null) {
            bahadir.birthPlace.sendKeys(birthPlaceValue);
        }
        if (eMailValue != null) {
            bahadir.email.sendKeys(eMailValue);
        }
        if (phoneNumberValue != null) {
            bahadir.phone.sendKeys(phoneNumberValue);
        }
        if (genderValue != null) {
            if (genderValue.equalsIgnoreCase("FEMALE")) {
                ReusableMethods.jsExecutorClick(bahadir.female);
            } else if (genderValue.equalsIgnoreCase("MALE")) {
                ReusableMethods.jsExecutorClick(bahadir.male);
            }
        }
        if (birthDayValue != null) {
            bahadir.birthday.sendKeys(birthDayValue);
        }
        if (ssnValue != null) {
            bahadir.ssn.sendKeys(ssnValue);
        }
        if (userNameValue != ".") {
            bahadir.username.sendKeys(userNameValue);
        }
        if (passwordValue != null) {
            bahadir.password.sendKeys(passwordValue);
        }
        return this;

    }


    public static boolean validateSSN(String ssn) {
        // SSN boş olamaz ve uzunluğu 11 olmalıdır (3 rakam, 1 '-', 2 rakam, 1 '-', 4 rakam)
        if (ssn != null && ssn.length() == 11) {
            // İstenen pozisyonlarda '-' karakteri olup olmadığını kontrol et
            if (ssn.charAt(3) == '-' && ssn.charAt(6) == '-') {
                // Rakamları kontrol et
                for (int i = 0; i < ssn.length(); i++) {
                    char c = ssn.charAt(i);
                    if (i == 3 || i == 6) {
                        continue; // '-' karakterlerini atla
                    }
                    if (!Character.isDigit(c)) {
                        return false; // Rakam değilse geçerli değil
                    }
                }
                return true; // Tüm kontrolleri geçtiyse geçerli
            }
        }
        return false; // Diğer koşulları sağlamıyorsa geçerli değil
    }
}

