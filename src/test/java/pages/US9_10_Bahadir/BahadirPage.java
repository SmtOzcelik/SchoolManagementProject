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

    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonsList']")
    public WebElement lessonsButton;

    //@FindBy(xpath = "//*[text()='Select lesson']")
    //public WebElement selectLesson;

    @FindBy(xpath = "//*[@class=' css-b62m3t-container']")
    public WebElement selectLesson;

    @FindBy(xpath = "//select[@id='educationTermId']")
    public WebElement chooseEducationTerm;

    @FindBy(xpath = "(//tbody//td/span)[13]")
    public WebElement javaScriptDersi;

    @FindBy(xpath = "(//table)[2]")
    public WebElement lessonList;

    @FindBy(xpath = "//*[text()='Lesson List']")
    public WebElement lessonListYazisi;

    @FindBy(xpath = "(//*[@class='fa-solid fa-trash'])[3]")
    public WebElement javaDeleteButton;

    @FindBy(xpath = "(//*[text()='Java'])[1]")
    public WebElement javaYazisi;

    @FindBy(xpath = "//select[@class='mt-5 form-select']")
    public WebElement chooseEducationTermDDMenu;

    @FindBy(xpath = "//select[@id='day']")
    public WebElement chooseDayDDmenu;

    @FindBy(xpath = "//*[@id='startTime']")
    public WebElement startTime;

    @FindBy(xpath = "//*[@id='stopTime']")
    public WebElement stopTime;

    @FindBy(xpath = "(//*[text()='Submit'])[3]")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement createdLessonProgram;


}
