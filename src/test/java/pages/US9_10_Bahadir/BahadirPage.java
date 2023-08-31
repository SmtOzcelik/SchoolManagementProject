package pages.US9_10_Bahadir;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BahadirPage {
    public BahadirPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@href='/login']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonProgram']")
    public WebElement lessonProgram;

    @FindBy(xpath = "//*[text()='Select lesson']")
    public WebElement selectLesson;

    @FindBy(xpath = "(//tbody//td/span)[13]")
    public WebElement javaScriptDersi;









}
