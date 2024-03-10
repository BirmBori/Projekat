package tests;

import org.junit.Test;

import pages.HomePage;

public class HomepageTests extends BaseTest {
    
    @Test
    public void verifyNumberOfProducts()
    {
        HomePage homePage = new HomePage(driver);

        homePage.goToHomePage();
        homePage.compareNoOfItems();
    }

    
}
