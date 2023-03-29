package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPages {
    public HotelMyCampPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@class='secondary-button small-link']")
    public WebElement gelişmişButon;

    @FindBy(xpath = "//a[@id='proceed-link']")
    public WebElement güvenliDeğil;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement loginButon;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement ikinciLoginButon;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement managerButonu; ////span[@class='username username-hide-on-mobile']

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement managementButon;

    @FindBy(xpath = "//a[@href=\"/admin/HotelAdmin\"]")
    public WebElement hotelList;

    @FindBy(xpath = "//*[@class='btn btn-circle btn-default']")
    public WebElement addHotel;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeButon;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement ddm;

    @FindBy(xpath = "(//button[@class='btn blue'])[2]")
    public WebElement saveButon;

    @FindBy(xpath = "(//div[@class='modal-body'])[2]")
    public WebElement kayıtBasarılı;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButon;
}
