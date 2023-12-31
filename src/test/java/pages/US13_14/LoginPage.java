package pages.US13_14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /*  -- sample --
    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginLink;
     */
    @FindBy(id="username")
    public WebElement userName;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(xpath = "(//*[@type='button'])[3]")
    public WebElement loginButton;



}
