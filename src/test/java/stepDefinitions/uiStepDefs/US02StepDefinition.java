package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US_01_02.AlperPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class US02StepDefinition {

    AlperPages alpg = new AlperPages();
    @Given("Admin olarak {string} adresine gider")
    public void adminOlarakAdresineGider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Then("Admin olarak Login ikonunu tiklar")
    public void adminOlarakLoginIkonunuTiklar() {
        ReusableMethods.clickElementByJS(alpg.anasayfaLogin);
        ReusableMethods.bekle(1);
    }

    @And("Admin olarak username kutusununa {string} girer")
    public void adminOlarakUsernameKutusununaGirer(String arg0) {
        alpg.username.sendKeys(ConfigReader.getProperty("usernameAdmin"));
    }
    @And("Admin olarak password kutusuna {string} girer")
    public void adminOlarakPasswordKutusunaGirer(String arg0) {
        alpg.password.sendKeys(ConfigReader.getProperty("password"));//,Keys.TAB,Keys.ENTER);
    }
    @And("Admin olarak Login butonunu tiklar")
    public void adminOlarakLoginButonunuTiklar() {
        ReusableMethods.clickElementByJS(alpg.loginButton);
        ReusableMethods.bekle(2);
    }
    @And("Admin olarak Menu butonuna basar")
    public void adminOlarakMenuButonunaBasar() {
        ReusableMethods.clickElementByJS(alpg.menuButon);
        ReusableMethods.bekle(2);
    }
    @And("Admin olarak Guest User linkini tiklar")
    public void adminOlarakGuestUserLinkiniTiklar() {
        ReusableMethods.clickElementByJS(alpg.guestUserButon);
        ReusableMethods.bekle(2);
    }
    @Given("Admin Guest_User List'i gorur")
    public void adminGuestUserListiGorur() {
        //ReusableMethods.arrowDown();
        Assert.assertTrue(alpg.guestUserListText.isDisplayed());
        ReusableMethods.bekle(1);
    }
    @And("Admin Guest_User Name bilgilerini gorur")
    public void adminGuestUserNameiGorur() {
        Assert.assertTrue(alpg.guestUserNameText.isDisplayed());
        ReusableMethods.bekle(1);
    }

    @And("Admin Guest_User Phone Number bilgilerini gorur")
    public void adminGuestUserPhoneNumberiGorur() {
        Assert.assertTrue(alpg.guestUserPhoneNumberText.isDisplayed());
        ReusableMethods.bekle(1);
    }

    @And("Admin Guest_User SSN bilgilerini gorur")
    public void adminGuestUserSSNyiGorur() {
        Assert.assertTrue(alpg.guestUserSsnText.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @And("Admin Guest_User User Name bilgilerini gorur")
    public void adminGuest_UserUserNameBilgileriniGorur() {
        ReusableMethods.pageUp();
        Assert.assertTrue(alpg.guestUserUserNameText.isDisplayed());
        ReusableMethods.bekle(6);
    }

    @Given("Admin Guest_User Delete butonunu gorur")
    public void adminGuest_UserDeleteButonunuGorur() {
        Assert.assertTrue(alpg.guestUserDeleteButonu.isDisplayed());
        ReusableMethods.bekle(1);
    }

    @And("Admin olarak Delete butonunu tiklar")
    public void adminOlarakDeleteButonunuTiklar() {
        ReusableMethods.clickElementByJS(alpg.guestUserDeleteButonu);
        ReusableMethods.bekle(1);
    }

    @And("Admin uyari mesajini gorerek silme isleminin tamamlandigini gorur")
    public void adminUyariMesajiniGorerekSilmeIslemininTamamlandiginiGorur() {
        Assert.assertTrue(alpg.guestUserDeletedUyariMesaji.isDisplayed());
        ReusableMethods.bekle(1);
    }

}
