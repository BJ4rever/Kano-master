package Kano;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomePage extends Utils {

    private By select_Product_Field = By.xpath("//a[@id='ButtonLink--30']/span");
    private By regionPointer_field = By.xpath("//div[@class='current-region style-scope kano-cart']");

    private By _i_Want_Superpower_Window_Alert = By.xpath("//paper-dialog[@id='modal']/div/img");
    private By _primary_Menu_Element = By.xpath("//ul[@id='primary-nav-items']");
    private By _menu_Item_List = By.xpath("//ul[@id='primary-nav-items']/li/a");
    private By _authorisation_Menu_Element = By.xpath("//ul[@class='auth-menu style-scope kano-user-menu']");
    private By _authorisation_Menu_List = By.xpath("//ul[@class='auth-menu style-scope kano-user-menu']/li");
    private By _Footer_Item_Container = By.xpath("//div[@class='stats style-scope kw-app']");
    private By _Footer_Item_List = By.xpath("//div[@class='stats style-scope kw-app']/kw-stat-card/div/div/p");


    public void userIsOnKanoHomePage(){

        driver.get("https://kano.me/");
    }

    public void clickOnComputerKitBundle(){


        clickOnElement(select_Product_Field);

    }


    public void changeAnotherCountry(String countryName){

        //click on region selector drop down menu
        Utils.clickOnElement(regionPointer_field);

        // select desired country
        driver.findElement(By.xpath("//span[contains(.,'"+countryName+"')]")).click();

        //driver.findElement(By.xpath("//span[contains(.,'US')]")).click();
        System.out.println(driver.getCurrentUrl());

        // Click on Location Selection Modal - Go To your country
        driver.findElement(By.xpath("//div[@class='LocationModal']/div[2]/div[2]/div/div/a")).click();

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(driver.findElement(By.xpath("//nav[@id='navbar']/div/div[4]/kano-cart/div/div/span")).getText(),countryName);

    }

    public void userIsOnKanoProjectPage(){
        driver.get("https://world.kano.me/projects");

    }


    public void checkMenu() {

        Utils.clickOnElement(_i_Want_Superpower_Window_Alert);
        driver.findElement(_i_Want_Superpower_Window_Alert).click();

        System.out.println("************************");
        System.out.println("Menu Item List displayed on the Kano Product page are as below : ");
        System.out.println("************************");

        // Storing primary menu list items as WebElements - and getting all menu item texts

        WebElement primary_menu_element = driver.findElement(_primary_Menu_Element);

        List<WebElement> menu_item_list = primary_menu_element.findElements(_menu_Item_List);

        java.util.Iterator<WebElement> x = menu_item_list.iterator();

        // Storing auth menu list items as WebElements - and getting all auth-menu item texts

        WebElement auth_menu_element = driver.findElement(_authorisation_Menu_Element);
        List<WebElement> auth_menu_list = auth_menu_element.findElements(_authorisation_Menu_List);

        // Joining both menu lists in one - totalMenuList

        List<WebElement> totalMenuList = new ArrayList<WebElement>();
        totalMenuList.addAll(menu_item_list);
        totalMenuList.addAll(auth_menu_list);

        java.util.Iterator<WebElement> z = totalMenuList.iterator();

        // Printing the totalMenuItems
        while (z.hasNext()) {
            WebElement menuName = z.next();
            System.out.println(menuName.getText());
        }


        System.out.println("************************");
        System.out.println("Footer Item List displayed on the Kano Product page are as below : ");
        System.out.println("************************");

        // Getting the footer info text in form of list

        // Storing the expected footer_info_list in form of Collections

        Collection expected_footer_list = new ArrayList(){{
            add ("Connected Kanos");
            add("Lines of code");
            add("Creations shared");
            add("Online Today");

        }};

        // Getting the actual footer_info_list
        Collection actual_footer_list = new ArrayList() {{
            add ("");
        }};

        WebElement footer_item_container = driver.findElement(_Footer_Item_Container);
        List<WebElement> footer_item_list = footer_item_container.findElements(_Footer_Item_List);
        for (int i = 1; i <= footer_item_list.size() ; i++) {
            final String footer_item = driver.findElement(By.xpath("//div[@class='stats style-scope kw-app']/kw-stat-card["+i+"]/div/div/p")).getText();

            actual_footer_list = new ArrayList(){{
                add(footer_item);
            }};
            System.out.println(actual_footer_list);

            // Print all footer items info
            //System.out.println(footer_item);
        }
        // expected_footer_list.removeAll(actual_footer_list);
        //System.out.println("missing value" +expected_footer_list);

        Assert.assertTrue(actual_footer_list == expected_footer_list,"The expected footer items are NOT visible in Kano.Project Footer ");
//        System.out.println("The difference in list" +expected_footer_list);

        }
    }

