package pages.sauceDemo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebUtils;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private Duration timeout = Duration.ofSeconds(10);

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> prices;

    @FindBy(xpath = "//div[.='Sauce Labs Bike Light']/parent::a/parent::div/following-sibling::div//button")
    private WebElement SauceLabsBackpackItem;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement itemInTheCart;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebUtils.setDriver(driver);
    }

    public boolean itemsPriceCheck(Double expectedPrice){
        for (WebElement element : prices){
            // $29.00
            // trim
            // replace
            String priceText = element.getText().replace("$", "").trim();
            double price = Double.parseDouble(priceText);
            if (price > expectedPrice){
                return true;
            }
        }
        return false;
    }


    public void clickOnItem(List<String> items, String targetItem){ //Sauce Labs Backpack
        for (String item : items){ //Sauce Labs Backpack
            if (item.equals(targetItem)){
                WebElement element = driver.findElement(By.xpath("//div[.='" + item + "']/parent::a/parent::div/following-sibling::div//button"));
                WebUtils.clickElement(element, timeout);
                break;
            }
        }
    }

    public void clickOnItem(List<String> items){
        for (String item : items) {
            WebElement element = driver.findElement(By.xpath("//div[.='" + item + "']/parent::a/parent::div/following-sibling::div//button"));
            WebUtils.clickElement(element, timeout);
        }
    }

    public void clickCart(){
        WebUtils.clickElement(cartButton, timeout);
    }

    public void compareItem(String expectedItem){
         String actualItem = WebUtils.waitForElement(itemInTheCart, timeout).getText();
         Assert.assertEquals(expectedItem, actualItem);
    }
}










