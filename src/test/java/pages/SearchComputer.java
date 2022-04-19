package pages;

import com.nivelics.commons.methods.web.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchComputer extends Method {

    @FindBy(xpath = "//body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/input[1]")
    private WebElement search;

    @FindBy(xpath = "//body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/span[1]/input[1]")
    private WebElement clickSubmitButton;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div/div/div[2]" +
            "/div/div/div[1]/h2/a/span")
    private WebElement computerHp;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[9]/div[6]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]" +
            "/div[1]/div[1]/div[1]/div[1]/div[8]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/span[1]/span[1]")
    private WebElement clickAmount;

    @FindBy(xpath = "//a[@id='quantity_1']")
    private WebElement clickTwoButton;

    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    private WebElement clickagreeCartButton;


    public SearchComputer Search(String text) {
        WAIT_INTERFACE.waitForElementToClickeable(10, 2, search);
        SEN_KEYS_INTERFACE.sendKeys(search, text);
        UTILS_INTERFACE.clickElement(clickSubmitButton);
        WAIT_INTERFACE.waitForElementToClickeable(10, 4, computerHp);
        UTILS_INTERFACE.clickElement(computerHp);
        Assert.assertEquals(webDriverFacade.getWebDriver().findElement
                        (By.xpath("//*[@id=\"availability\"]/span")).getText(),
                "Disponible.", "Fallo el Assert");
        WAIT_INTERFACE.waitForElementToClickeable(10, 2, clickAmount);
        UTILS_INTERFACE.clickElement(clickAmount);
        WAIT_INTERFACE.waitForElementToClickeable(10, 2, clickTwoButton);
        UTILS_INTERFACE.clickElement(clickTwoButton);
        UTILS_INTERFACE.clickElement(clickagreeCartButton);
        Assert.assertEquals(webDriverFacade.getWebDriver().findElement
                        (By.xpath("//*[@id=\"sw-atc-details-single-container\"]/div[2]/div[1]/span")).getText(),
                "Agregado al carrito", "Fallo el Assert");

        return this;
    }
}
