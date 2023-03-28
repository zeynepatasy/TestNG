package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCars {
     public BlueRentalCars(){
         PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement FirstloginButonu;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailButon;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement twoLoginButton;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement kullanıcıProfilİsmi;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement girilemediYazısı;
}
