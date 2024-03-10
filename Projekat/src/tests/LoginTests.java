package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTests extends BaseTest {

    String errorMessageEmptyLoginField = "This is a required field.";
    String errorMessageInvalidEmail = "Please enter a valid email address (Ex: johndoe@domain.com).";
    String invalidTypeEmail = "boris.b";
    String errorMessageInvalidWrongPassword = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    By emptyUsernameMessageBy = By.xpath("//div[@for='email']");
    By emptyPasswordMessageBy = By.xpath("//div[@for='pass']");
    By wrongPasswordMessageBy = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    
    @Test
    public void SucessfulLogin()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        homePage.verifySuccessfulLogin();
    }

    @Test 
    public void UnsucessfulLoginEmptyUsername()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login("", validPassword);
        loginPage.verifyUnsuccessfulLogin(errorMessageEmptyLoginField, emptyUsernameMessageBy);
    }

    @Test 
    public void UnsucessfulLoginEmptyPassword()
    {   
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login(validUsername, "");
        loginPage.verifyUnsuccessfulLogin(errorMessageEmptyLoginField, emptyPasswordMessageBy);
    }

    @Test
    public void UnsucessfulLogininvalidTypeEmail ()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login(invalidTypeEmail, validPassword);
        loginPage.verifyUnsuccessfulLogin(errorMessageInvalidEmail, emptyUsernameMessageBy);
    }

    @Test
    public void UnsucessfulLogininvalidTypePassword()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login(validUsername, invalidTypeEmail);
        loginPage.verifyUnsuccessfulLogin(errorMessageInvalidWrongPassword, wrongPasswordMessageBy);
    }
    @Test
    public void SucessfulLogout()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        LogoutPage logoutPage = new LogoutPage(driver);

        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        homePage.logout();
        logoutPage.verifySuccessfulLogout();
    }
}
