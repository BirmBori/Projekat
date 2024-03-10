package pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage (WebDriver driver){
        super(driver);
    }
    String expectedPageTitle = "My Account";

    public MyAccountPage verifySuccessfulCreating()
    {
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }
    
}
