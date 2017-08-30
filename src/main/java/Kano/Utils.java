package Kano;

import org.openqa.selenium.By;

public class Utils extends BasePage{


    // re-usable method to click on element
    public static void clickOnElement(By by){

        driver.findElement(by).click();
    }


    //Reusable method for getText
    public static String getTextFromElement(By by){     //return type as String - why? to store and return the test we are receving from the element
        String text =  driver.findElement(by).getText();                                                          // so we can reuse the text
        return text;
    }
}
