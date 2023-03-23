package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C07_SoftAssert extends TestBase {
    @Test
    public void test01(){
        //https://zero.webappsecurity.com/ adresine gidin
        driver.get("https://www.amazon.com");
        //Sign in butonuna basın
        //Login kutusuna username yazın
        //password kutusuna password yazın
        //Sign in tusuna basın
        //Online banking menusu içinde Pay Bills sayfasına gidin
        //"Purchase Foreign Currency" tusuna basın
        //"Currency" dropdown menusunden Eurozone'u secin
        WebElement ddo= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddo);
        select.selectByVisibleText("Arts & Crafts");
        //softAssert kullanarak "Eurozone(Euro)" secildiğini test edin
        SoftAssert softAssert=new SoftAssert();
        String secilenOptions=select.getFirstSelectedOption().getText();
        String expectedOptions="arts & Craftsss";
        softAssert.assertEquals(secilenOptions,expectedOptions,"secilen option uygun değil");
        //softAssert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement>optionList=select.getOptions();
        List<String>optionListText=new ArrayList<>();
        List<String>expectedList=new ArrayList<>();
        expectedList.add("All Departments");  expectedList.add("Arts & Crafts"); expectedList.add("Automotive"); expectedList.add("Baby");
        expectedList.add("Beauty & Personal Care"); expectedList.add("Books");  expectedList.add("Boys' Fashion"); expectedList.add("Computers");
        expectedList.add("Deals");expectedList.add("Digital Music");  expectedList.add("Electronics");expectedList.add("Girls' Fashion");
        expectedList.add("Health & Household");  expectedList.add("Home & Kitchen"); expectedList.add("Industrial & Scientific");expectedList.add("Kindle Store");
        expectedList.add("Luggage"); expectedList.add("Men's Fashion"); expectedList.add("Movies & TV"); expectedList.add("Music, CDs & Vinyl");
        expectedList.add("Pet Supplies");expectedList.add("Prime Video");expectedList.add("Software");  expectedList.add("Sports & Outdoors");
        expectedList.add("Tools & Home Improvement");  expectedList.add("Toys & Games");  expectedList.add("Video Games");
        expectedList.add("Video Games");  expectedList.add("Women's Fashion");
        for (WebElement each:optionList
             ) {
            System.out.println(each.getText());
            optionListText.add(each.getText());

        }

        System.out.println(optionListText);
        Assert.assertEquals(optionListText,expectedList);
        }

    }

