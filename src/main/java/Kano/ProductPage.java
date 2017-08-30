package Kano;

import org.openqa.selenium.By;

public class ProductPage extends Utils {

    private By product_Title_Field = By.xpath("//h2[contains(.,'Computer Kit Bundle')]");
    private By buyNow_Button_Field = By.xpath("//span[contains(.,'Buy now')]");
    private By product_priceCurrency_field = By.xpath("//span[@itemprop='priceCurrency']");
    private By product_price_field = By.xpath("//span[@itemprop='price']");
    private By product_Quantity_field = By.cssSelector("#BundleDisplay-quantitySelector--kano-complete");



    public ProductDetails addProductToBasket(){


        String productTitle = gettingValue(product_Title_Field);
        System.out.println(productTitle);
        String currencySymbol = Utils.getTextFromElement(product_priceCurrency_field);
        int  quantity = Integer.parseInt(driver.findElement(product_Quantity_field).getAttribute("value"));
        double price = Double.parseDouble(Utils.getTextFromElement(product_price_field));

        ProductDetails productDetails = new ProductDetails(productTitle, currencySymbol, price,quantity);

       clickOnElement(buyNow_Button_Field);
        return productDetails;
    }

    public String gettingValue(By by){
        String abc=Utils.getTextFromElement(by);
        return abc;
    }
}
