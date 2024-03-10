package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;
    String validUsername = "asd@asd.asd";
    String validPassword = "ASDasd123";

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
