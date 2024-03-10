package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    String loginUrl = "https://magento.softwaretestingboard.com/customer/account/login/";
    By usernameInputBy = By.id("email");
    By passwordInputBy = By.id("pass");
    By loginButtonBy = By.id("send2");
    String invalidEmail = "asd@asd.asdd";
    String invalidPassword = "ASDasd1231";
    String expectedWrongPasswordMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

    public LoginPage login(String username, String password)
    {
        enterText(usernameInputBy, username);
        enterText(passwordInputBy, password);
        clickOnElement(loginButtonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin(String expectedError,By errorMessageBy)
    {
        String actualMessage = readText(errorMessageBy);
        verifyTextIsTheSame(expectedError, actualMessage);
        return this;
    }
    
}
