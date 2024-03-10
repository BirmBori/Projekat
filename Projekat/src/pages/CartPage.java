package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage (WebDriver driver){
        super(driver);
    }

    By itemsQtyBy = By.xpath("//th[@class='col qty']");
    By subtotalPriceBy = By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/td/span");
    By taxPriceBy = By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[2]/td/span");
    By orderPriceBy = By.xpath(" //*[@id=\"cart-totals\"]/div/table/tbody/tr[3]/td/strong/span");
    By removeItemBy = By.xpath("//a[@class='action action-delete']");

    public CartPage verifySucessfulAddToCart()
    {
        String actualPageTitle = readText(itemsQtyBy);
        verifyTextIsTheSame("Qty", actualPageTitle);
        return this;
    }
    
    public CartPage verificationOfTotalPrice(){
        String subtotalPriceText = readText(subtotalPriceBy).substring(1);
        double doubleSubtotalPrice = convertTextToNumber(subtotalPriceText);
        String taxPriceText = readText(taxPriceBy).substring(1);
        double doubleTaxPrice = convertTextToNumber(taxPriceText);
        String orderPriceText = readText(orderPriceBy).substring(1);
        double doubleOrderPrice = convertTextToNumber(orderPriceText);
        double actualprice = doubleSubtotalPrice + doubleTaxPrice;

        verifyPrice(actualprice, doubleOrderPrice);
        return this;
    }

    public CartPage removeItem()
    {
        clickOnElement(removeItemBy);
        return this;
    }
}
