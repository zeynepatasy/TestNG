package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage(){
        //class isimli constructor olusturduk,
        PageFactory.initElements(Driver.getDriver(),this); //bu classtaki driver'ı eşitle bu classla
    }
    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;
}
