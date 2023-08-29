package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SametPage {

   public SametPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // yeni gel
    @FindBy(xpath = "//a[@href='/register']")
    public WebElement register;

}
