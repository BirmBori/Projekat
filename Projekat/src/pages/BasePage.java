package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    By pageTitleBy = By.xpath("//span[@class='base']");
    

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void waitElementToBeVisible(By elementBy)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitElementToBeClickable(By elementBy)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void clickOnElement(By elementBy)
    {
        waitElementToBeClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    public void enterText(By elementBy, String text)
    {
        waitElementToBeClickable(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void verifyNumberOfElements (int expNum, int actNum)
    {
        Assert.assertEquals(expNum, actNum);
    }

    public String readText(By elementBy)
    {
        waitElementToBeVisible(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void verifyTextIsTheSame(String expectedText, String actualText)
    {
        Assert.assertEquals(expectedText, actualText);
    }

    public void verifyElementIsVisible(By elementBy)
    {
        boolean isVisible;
        try {
            waitElementToBeVisible(elementBy);
            isVisible = driver.findElement(elementBy).isDisplayed();
        } 
        catch (Exception e) {
            isVisible = false;
        }
        
        Assert.assertTrue(isVisible);
    }

    public double convertTextToNumber(String text)
    {
        return Double.parseDouble(text);
    }

    public void verifyPrice (double expectedPrice, double actualPrice)
    {
        double allowDelta = 0.2;
        Assert.assertEquals(expectedPrice, actualPrice, allowDelta);
    }
}
