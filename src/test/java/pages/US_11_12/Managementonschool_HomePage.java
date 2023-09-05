package pages.US_11_12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class Managementonschool_HomePage {
    public Managementonschool_HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "[href='/register']")
    public WebElement mainMenuRegister;

    @FindBy(css = "[href='/login']")
    public WebElement mainMenuLogin;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginMenuLoginButon;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Menu']")
    public WebElement menuButton;

    @FindBy(xpath = "//a[text()='Admin Management']")
    public WebElement adminManagement;
    @FindBy(xpath = "//a[text()='Dean Management']")
    public WebElement deanManagement;
    @FindBy(xpath = "//a[text()='Vice Dean Management']")
    public WebElement viceDeanMangement;

    @FindBy(xpath = "//a[text()='Lesson Management']")
    public WebElement lessonManagement;

    @FindBy(xpath = "//a[text()='Teacher Management']")
    public WebElement teacherMangement;
    @FindBy(xpath = "//a[text()='Student Management']")
    public WebElement studentManagement;
    @FindBy(xpath = "//a[text()='Student Info Management']")
    public WebElement studentInfoManagement;
    @FindBy(xpath = "//a[text()='Meet Management']")
    public WebElement meetManagement;

    @FindBy(xpath = "//a[text()='Choose Lesson']")
    public WebElement chooseLessonManagement;

    @FindBy(xpath = "//a[text()='Contact Get All']")
    public WebElement contactMenu;
    @FindBy(xpath = "//a[text()='Guest User']")
    public WebElement guestUserMenu;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOut;

    @FindBy(id = "react-select-3-placeholder")
    public WebElement dropdownChooseLesson;

    @FindBy(id = "name")
    public WebElement name;

   @FindBy(id = "surname")
    public WebElement surname;

   @FindBy(id = "birthPlace")
    public WebElement birthPlace;

   @FindBy(id = "email")
    public WebElement email;

   @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;
    @FindBy(id = "ssn")
    public WebElement ssn;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement adminSubmit;

    @FindBy(xpath = "//input[@value='FEMALE']")
    public WebElement genderFemale;
    @FindBy(xpath = "//input[@value='MALE']")
    public WebElement genderMale;

    @FindBy(css = "[class='form-check']")
    public WebElement isAdvisorTeacher;

    @FindBy(id = "birthDay")
    public WebElement birthDay;
















































































































































































































































    @FindBy(xpath = "//a[contains(.,'Login')]")
    public WebElement adminMainMenuLogin;

    @FindBy(id = "advisorTeacherId")
    public WebElement teacherselectddm;

    @FindBy(xpath = "//input[@id='fatherName']")
    public WebElement fatherName;

    @FindBy(xpath = "//input[@id='motherName']")
    public WebElement motherName;

    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement adminSubmitButton;

    @FindBy(xpath = "//form[1]/div[1]/div[2]//div[@class='invalid-feedback']")
    public WebElement adminNameRequired;

    @FindBy(xpath = "//form[1]/div[2]/div[1]//div[@class='invalid-feedback']")
    public WebElement adminBirthPlaceRequired;

    @FindBy(xpath = "//form[1]/div[1]/div[3]//div[@class='invalid-feedback']")
    public WebElement adminSurnameRequired;

    @FindBy(xpath = "//div[@class='mb-3 pt-4']/div[@class='invalid-feedback']")
    public WebElement dobRequired;

    @FindBy(xpath = "//form[1]/div[3]/div[3]//div[@class='invalid-feedback']")
    public WebElement fatherNameRequired;

    @FindBy(xpath = "//form[1]/div[3]/div[2]//div[@class='invalid-feedback']")
    public WebElement userNameRequired;

    @FindBy(xpath = "//form[1]//div[4]//div[@class='invalid-feedback']")
    public WebElement motherNameRequired;

    @FindBy(xpath = "//form[1]/div[3]/div[1]//div[@class='invalid-feedback']")
    public WebElement ssnRequired;

    @FindBy(xpath = "//div[.='Minimum 8 character']")
    public WebElement passwordAlert;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']/div[.='You have entered an invalid value. Valid values are: MALE, FEMALE']")
    public WebElement genderAlert;

    @FindBy(xpath = "//button[@class='fw-semibold text-white bg-primary navbar-toggler collapsed']")
    public WebElement adminMenuButton;


    //Requiered Messages
    @FindBy(xpath = "//*[@id='name' and @class='form-control is-invalid']")public WebElement nameRequired;
    @FindBy(xpath = "//*[@id='surname' and @class='form-control is-invalid']")public WebElement surNameRequired;
    @FindBy(xpath = "//*[@id='birthPlace' and @class='form-control is-invalid']")public WebElement birthPlaceRequired;
    @FindBy(xpath = "//*[@id='email' and @class='form-control is-invalid']")public WebElement emailRequired;
    @FindBy(xpath = "//*[@id='phoneNumber' and @class='form-control is-invalid']")public WebElement phoneNumberRequired;
    @FindBy(xpath = "//*[@id='birthDay' and @class='form-control is-invalid']")public WebElement birthDayRequired;
    @FindBy(xpath = "//*[@id='ssn' and @class='form-control is-invalid']")public WebElement sSNRequired;
    @FindBy(xpath = "//*[@id='password' and @class='form-control is-invalid']")public WebElement passwordRequired;

    //Warning Messages
    @FindBy(xpath = "//div[text()='You have entered an invalid value. Valid values are: MALE, FEMALE']")public WebElement pleaseChooseLessonMessage;
    @FindBy(xpath = "//div[text()='Your name should be at least 2 characters']")public WebElement invalidNameWarning;
    @FindBy(xpath = "//div[text()='Your surname should be at least 2 characters']")public WebElement invalidSurNameWarning;    @FindBy(xpath = "//div[text()='Your surname must consist of the characters .']")public WebElement invalidSurNameWarning2;
    @FindBy(xpath = "//div[text()='You have entered an invalid value. Valid values are: MALE, FEMALE']")public WebElement invalidGengerSelectWarning;
    @FindBy(xpath = "//div[text()='Your birth place should be at least 2 characters']")public WebElement birthPlaceWarning;@FindBy(xpath = "//div[text()='Your birth place must consist of the characters .']")public WebElement birthPlaceWarning2;
    @FindBy(xpath = "//div[text()='Please enter valid email']")public WebElement pleaseEnterValidEmailMessage;
    @FindBy(xpath = "//div[text()='Your email should be between 5 and 50 characters']")public WebElement emailShouldBe5_50;
    @FindBy(xpath = "//div[text()='Phone number should be exact 12 characters']")public WebElement phoneNumber12Message;
    @FindBy(xpath = "//div[text()='Please enter valid phone number']")public WebElement pleaseEnterValidPhoneNumberMessage;
    @FindBy(xpath = "//div[text()='geçmiş bir tarih olmalı']")public WebElement dogumGunuGecmisBirTarihOlmali;
    @FindBy(xpath = "//div[text()='Please enter valid SSN number']")public WebElement pleaseEnterValidSSNNumberMessage;
    @FindBy(xpath = "//div[text()='Your username should be at least 4 characters']")public WebElement userNameMust4CharMessage;
    @FindBy(xpath = "//div[text()='Full authentication is required to access this resource']")public WebElement fullAuthenticationWanrning;
    @FindBy(xpath = "(//span[text()='Last'])[1]")public WebElement lastPageButton;
    @FindBy(xpath = "//span[@class='text-white']") public WebElement kullaniciIsmiTexti;
    @FindBy(xpath = "//div[@role='alert']")public WebElement teacherSavedMessage;
    @FindBy(css = " [class=' css-1xc3v61-indicatorContainer']") public WebElement selectLesson;
    @FindBy(xpath = "//*[@id='username' and @class='form-control is-invalid']")public WebElement usernameRequired;
    @FindBy(xpath = "//*[text()='Teacher saved successfully']")public WebElement teacherSavedMessage2;@FindBy(xpath = "//div[text()='Admin Saved']")public WebElement adminSaved;
    @FindBy (xpath = "//div[text()='Guest User registered.']") public WebElement GuestUser;
    @FindBy(xpath = "(//li[@class='page-item'])[4]")public WebElement lastPageButton2;
    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']")public WebElement table;
    @FindBy(xpath = "//button[text()='Register']")public WebElement registerButton;
    @FindBy(xpath = "(//button[text()='Submit'])[2]")public WebElement submitInEdit;
    @FindBy(xpath = "(//*[@id='username'])[2]")public WebElement usernameInEdit;
    @FindBy(xpath = "(//*[@id='password'])[2]")public WebElement passwordInEdit;
    @FindBy(xpath = "(//*[@id='email'])[2]")public WebElement emailPlaceInEdit;
    @FindBy(xpath = "(//*[@id='birthPlace'])[2]")public WebElement birthPlaceInEdit;
    @FindBy(xpath = "(//*[@id='surname'])[2]")public WebElement surnameInEdit;
    @FindBy(xpath = "(//*[@id='name'])[2]")public WebElement nameInEdit;
    @FindBy(xpath = "(//*[@id='ssn'])[2]")public WebElement ssnPlaceInEdit;
    @FindBy(xpath = "(//*[@id='phoneNumber'])[2]")public WebElement phoneNumberPlaceInEdit;
    @FindBy(xpath = "(//*[@id='birthDay'])[2]")    public WebElement birthDayInEdit;
    @FindBy(xpath = "(//input[@value='FEMALE'])[2]") public WebElement genderInEdit;
    @FindBy(xpath = "(//div[@class='col-lg-4']//div[@class=' css-b62m3t-container'])[2]")public WebElement chooseLessonInEdit;
    @FindBy(id = "react-select-2-input")
    public WebElement dropdownChooseLessonAdmin;



@FindBy(xpath = "//div[text()='Dean Saved']")public WebElement deanSaved;
@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[text()='Name']")public WebElement deanTableName;
@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[text()='Gender']")public WebElement deanTableGender;
@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[text()='Phone Number']")public WebElement deanTablePhoneNumber;
@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[text()='Ssn']")public WebElement deanTableSsn;
@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[text()='User Name']")public WebElement deanTableUserName;
@FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover']//tbody//tr//td//span//button[@type='button'])[1]")public WebElement deanTableEditButton;

}
