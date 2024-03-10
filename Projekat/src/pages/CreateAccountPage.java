package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage (WebDriver driver){
        super(driver);
    }

    By InputByFirstName = By.id("firstname");
    By InputByLastName = By.id("lastname");
    By InputByEmail = By.id("email_address");
    By InputByPassword = By.id("password");
    By InputByConfirmPassword = By.id("password-confirmation");
    
    String firstName = "Dule";
    String lastName = "Vujosevic";
    String validEmail = "dule.dudule@gmail.com";
    String validPassword = "DusanKecman007";
    By CreateAnAccountBtnBy = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");
    
    public CreateAccountPage createNewCustomerAccount(){
        enterText(InputByFirstName, firstName);
        enterText(InputByLastName, lastName);
        enterText(InputByEmail, validEmail);
        enterText(InputByPassword, validPassword);
        enterText(InputByConfirmPassword, validPassword);
        clickOnElement(CreateAnAccountBtnBy);
        return this;
    }

}
