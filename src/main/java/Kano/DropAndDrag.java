package Kano;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropAndDrag {

    public static WebDriver driver;


@Test
    public void dragAndDrop() {
//        Actions builder = new Actions(driver);
//        builder.keyDown(Keys.CONTROL).click().click().keyUp(Keys.CONTROL);
//        Action selectMultipal = builder.build();
//        selectMultipal.perform();

//        driver = new FirefoxDriver();
//        driver.get("http://jqueryui.com/droppable/#default");
//        WebElement dragFrom = driver.findElement(By.id("draggable"));
//        WebElement dragTo = driver.findElement(By.id("droppable"));
//        Actions builder1  = new Actions(driver);
//        Action dragAndDrop = builder1.clickAndHold(dragFrom)
//                .moveToElement(dragTo)
//                .release(dragTo)
//                .build();
//        dragAndDrop.perform();




        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://jqueryui.com/droppable/#default");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        // Script for dragging an element and dropping it in another place
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        System.out.println(iFrame.getSize());
        driver.switchTo().frame(iFrame);

        WebElement From = driver.findElement(By.id("draggable"));
        System.out.println(From.getLocation());

        WebElement To = driver.findElement(By.id("droppable"));
        System.out.println(To.getLocation());

        act.dragAndDrop(From, To).build().perform();


    }
}
