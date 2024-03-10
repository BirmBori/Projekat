package tests;

import org.junit.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;

public class CreateAccountTests extends BaseTest{
    @Test

    public void CreateNewCustomerTest(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createNewCustomerAccountPage = new CreateAccountPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        homePage.goToHomePage();
        homePage.navigateToCreateAccount();
        createNewCustomerAccountPage.createNewCustomerAccount();
        myAccountPage.verifySuccessfulCreating();
    }
}
