package tests.day21_reusableMethods_htmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        Set<String>windowhandleSeti=Driver.getDriver().getWindowHandles();
        String ikinciSyafam="";
        for (String each:windowhandleSeti
             ) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSyafam=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSyafam);
        System.out.println(Driver.getDriver().getTitle());
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
