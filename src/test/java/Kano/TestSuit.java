package Kano;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    public void userShouldAbleToVerifyCorrectProductInTheBasket(){
        homePage.userIsOnKanoHomePage();
        homePage.clickOnComputerKitBundle();
        ProductDetails details = productPage.addProductToBasket();
        cartPage.verifyProductDetailsInToCartPage(details);

    }

    @Test
    public void userShouldAbleToVerifyChangeOfCountryCurrencyInTheBasket(){
        homePage.userIsOnKanoHomePage();
        homePage.changeAnotherCountry("EU");
        homePage.clickOnComputerKitBundle();
        ProductDetails details = productPage.addProductToBasket();
        cartPage.verifyProductDetailsInToCartPage(details);
    }

    @Test
    public void verifyMenuBarAndFooterBarList(){
        homePage.userIsOnKanoProjectPage();
        homePage.checkMenu();
    }



}

