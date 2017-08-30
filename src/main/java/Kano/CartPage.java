package Kano;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class CartPage extends Utils {

    SoftAssert softAssert = new SoftAssert();
    private By cartPage_Itemname_field = By.xpath("//h3[@class='CartPage-itemName']/a");
    private By cartPage_ItemPrice_field = By.xpath("//div[@class='CartPage-itemPrice']");
    private By cartPage_ItemQuantity_field = By.xpath("//input[@class='CartPage-quantityValue CartPage-quantityValue--valid']");
    private By cartPage_totalPrice_field = By.xpath("//div[@class='CartPage-summaryItemValue CartPage-summaryItemValue--total']");
    private By buyNow_Button_Field = By.xpath("//span[contains(.,'Buy now')]");


    public void verifyProductDetailsInToCartPage(ProductDetails productDetails ){

        System.out.println(Utils.getTextFromElement(cartPage_Itemname_field));
        System.out.println(Utils.getTextFromElement(cartPage_ItemPrice_field));
        System.out.println(Utils.getTextFromElement(cartPage_ItemQuantity_field));
        System.out.println(Utils.getTextFromElement(cartPage_totalPrice_field));

        String actualSymbol = Utils.getTextFromElement(cartPage_ItemPrice_field).substring(0,1);
        int actualQty = Integer.parseInt(driver.findElement(cartPage_ItemQuantity_field).getAttribute("value"));
        double actualPrice = Double.parseDouble(Utils.getTextFromElement(cartPage_totalPrice_field).replaceAll("[^0-9.]",""));

        softAssert.assertEquals(Utils.getTextFromElement(cartPage_Itemname_field),productDetails.GetProductDetail(),"\nProduct title not matching");
        softAssert.assertEquals(actualSymbol, productDetails.GetSymbol(),"\nIncorrect currency symbol");
        softAssert.assertEquals(actualQty, productDetails.GetQty(),"\nIncorrect quantity");
        softAssert.assertEquals(actualPrice, productDetails.GetPrice(),"\nIncorrect price");
        softAssert.assertAll();
        System.out.println("All the product details on CartPage are correct");



    }
}
