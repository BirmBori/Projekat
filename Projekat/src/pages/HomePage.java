package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    
    String baseUrl = "https://magento.softwaretestingboard.com/";
    By hotSellersImageBy = By.xpath("//img [@class = 'product-image-photo']");
    By loginButtonBy = By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']");
    By logoutButtonBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    By dropDownBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    By whatIsNewBy = By.id("ui-id-3");
    By createAnAccountBy = By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']");
    int expectedNumberOfItems = 6;
    By messageCreatedAccBy = By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']");
    String expectedPageTitle = "Home Page";


    public HomePage goToHomePage()
    {
        driver.get(baseUrl);
        return this;
    }

    public HomePage compareNoOfItems ()
    {
        List<WebElement> productList = driver.findElements(hotSellersImageBy);
        int actualNumberOfElements = productList.size();
        verifyNumberOfElements(expectedNumberOfItems, actualNumberOfElements);
        return this;
    }

    public HomePage goToLoginPage()
    {
        clickOnElement(loginButtonBy);
        return this;
    }

    public HomePage navigateToCreateAccount(){
        clickOnElement(createAnAccountBy);
        return this;
    }

    public HomePage verifySuccessfulLogin()
    {
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }
    public HomePage dropDown(){
        clickOnElement(dropDownBy);
        return this;
    }

    public HomePage logout()
    {
        clickOnElement(dropDownBy);
        clickOnElement(logoutButtonBy);
        return this;
    }
    public HomePage navigateToWhatIsNew()
    {
        clickOnElement(whatIsNewBy);
        return this;
    }


}
