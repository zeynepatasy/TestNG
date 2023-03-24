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
        String[]arr={"All Departments", "Arts & Crafts", "Automotive", "Baby", "Beauty & Personal Care","Books", "Boys' Fashion", "Computers", "Deals","Digital Music", "Electronics", "Girls' Fashion", "Health & Household", "Home & Kitchen", "Industrial & Scientific", "Kindle Store", "Luggage", "Men's Fashion", "Movies & TV", "Music, CDs & Vinyl", "Pet Supplies","Prime Video", "Software", "Sports & Outdoors", "Tools & Home Improvement", "Toys & Games", "Video Games", "Women's Fashion"};

        List<String>expectedList=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            expectedList.add(arr[i]);
        }

        for (WebElement each:optionList
             ) {
            System.out.println(each.getText());
            optionListText.add(each.getText());

        }

        System.out.println(optionListText);
        Assert.assertEquals(optionListText,expectedList);
        }

    }

