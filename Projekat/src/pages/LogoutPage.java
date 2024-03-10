package pages;

import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    public LogoutPage(WebDriver driver){
        super(driver);
    }

    
    String expectedPageTitle = "You are signed out"; 

    public LogoutPage verifySuccessfulLogout()
    {
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }
}
