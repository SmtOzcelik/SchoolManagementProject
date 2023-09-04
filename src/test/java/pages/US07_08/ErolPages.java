package pages.US07_08;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ErolPages {

    public ErolPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='header_link ms-2']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//button[normalize-space()='Menu']")
    public WebElement menuButton;

    @FindBy(xpath = "(//a[@role='button'])[11]")
    public WebElement contactGetAllButton;













}
