package pages.US05_06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SalihPages {
    public SalihPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@href='/login']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//h3")
    public WebElement adminManagementDogrulama;

    @FindBy(xpath = "//*[@type='button']")
    public WebElement menuButton;

    @FindBy(xpath = "(//*[@role='button'])[11]")
    public WebElement DeanManagementMenuButton;

    @FindBy(xpath = "//*[@class='table table-striped table-bordered table-hover']")
    public WebElement deanTablo;

    @FindBy(xpath = "//h5")
    public WebElement deanListYazisi;


    @FindBy(xpath = "//tbody/tr[1]/td[6]/span[1]/button[1]")
    public WebElement deanTeam11Edit;

    @FindBy(xpath = "//*[@type='text']")
    public WebElement ViceDeanName;

    @FindBy(id = "//*[@id='surname']")
    public WebElement ViceDeanSurname;

    @FindBy(id = "//*[@id='birthPlace']")
    public WebElement ViceDeanDogumYeri;

    @FindBy(xpath = "(//*[@name='gender'])[2]")
    public WebElement ViceDeanGender;

    @FindBy(xpath = "//*[@type='date']")
    public WebElement ViceDeanDogumTarihi;

    @FindBy(xpath = "(//*[@type='text'])[5]")
    public WebElement ViceDeanSSNnNo;

    @FindBy(xpath = "(//*[@type='text'])[6]")
    public WebElement ViceDeanUserName;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement ViceDeanPassword;

    @FindBy(xpath = "(//*[@type='button'])[5]")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement alertMessage;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[6]")
    public WebElement ssnRequiredYazisi;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[8]")
    public WebElement atLeastEightCharacters; //salih


    @FindBy(xpath = "//*[@id=root]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[7]/td[6]/span/button")
    public WebElement deanTeam11Edit;



}
