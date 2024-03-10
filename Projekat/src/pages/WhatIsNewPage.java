package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhatIsNewPage extends BasePage{
    public WhatIsNewPage(WebDriver driver){
        super(driver);
    }

    By addProductSizeBy = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[3]/div/div/div[3]/div[1]/div/div[1]");
    By addProductColorBy = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[3]/div/div/div[3]/div[2]/div/div[1]");
    By addToCartBtnFunBy = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[3]/div/div/div[4]/div/div[1]/form/button/span");
    By noOfProductInCartBy = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]");
    By actualTextSCBy = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span");
    By viewAndEditCartBtnBy = By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[5]/div/a/span");
    String expectedTextWN = "What's New";

    public WhatIsNewPage verifyWhatsNewPage (String expectedText){
        String actualText = readText(pageTitleBy);
        verifyTextIsTheSame(expectedText, actualText);
        return this;
    }

    public WhatIsNewPage addProductSize()
    {
        clickOnElement(addProductSizeBy);
        return this;
    }

    public WhatIsNewPage addProductColor()
    {
        clickOnElement(addProductColorBy);
        return this;
    }

    public WhatIsNewPage addToCartBtnFun()
    {
        clickOnElement(addToCartBtnFunBy);
        return this;
    }

    public WhatIsNewPage productInCartBtnFun()
    {
        verifyElementIsVisible(noOfProductInCartBy);
        clickOnElement(noOfProductInCartBy);
        return this;
    }
    
    public WhatIsNewPage verifyProductInCart(String expectedTextSC)
    {
        productInCartBtnFun();
        String actuaTextSC = readText(actualTextSCBy);
        verifyTextIsTheSame(expectedTextSC, actuaTextSC);
        return this;
    }

    public WhatIsNewPage viewAndEditCartBtnFun()
    {
        clickOnElement(viewAndEditCartBtnBy);
        return this;
    }

    public WhatIsNewPage addToCart()
    {
        verifyWhatsNewPage(expectedTextWN);
        addProductSize();
        addProductColor();
        addToCartBtnFun();
        return this;
    }
    public WhatIsNewPage navigateToCart()
    {
        clickOnElement(viewAndEditCartBtnBy);
        return this;
    }
}
