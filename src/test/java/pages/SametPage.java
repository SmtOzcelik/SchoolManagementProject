package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SametPage {

   public SametPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement contactButon;

    @FindBy(xpath = "//label[text()=\"Your Name\"]")
    public WebElement yourNameBox;

    @FindBy(xpath = "//label[text()=\"Your Email\"]")
    public WebElement yourEmailBox;

    @FindBy(xpath = "//label[text()=\"Subject\"]")
    public WebElement subjectBox;

    @FindBy(xpath = "//label[text()=\"Message\"]")
    public WebElement messageBox;

    @FindBy(xpath = "//button[text()=\"Send Message\"]")
    public WebElement sendMessageButon;

    @FindBy(xpath = "//*[text()='Contact Message Created Successfully']")
    public WebElement successfullyText;

}
