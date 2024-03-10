package tests;

import org.junit.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.WhatIsNewPage;

public class CartTests extends BaseTest{
    
    
    String expectedTextSC = "View and Edit Cart";

    @Test
    public void fromWhatsNewToCart()
    {
        HomePage homePage = new HomePage (driver);
        LoginPage loginPage = new LoginPage(driver);
        WhatIsNewPage whatIsNewPage = new WhatIsNewPage(driver);
        CartPage cartPage = new CartPage(driver);


        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        homePage.navigateToWhatIsNew();
        whatIsNewPage.addToCart();
        whatIsNewPage.verifyProductInCart(expectedTextSC);
        whatIsNewPage.navigateToCart();
        cartPage.verifySucessfulAddToCart();
        cartPage.verificationOfTotalPrice();
        cartPage.removeItem();
    }
}
