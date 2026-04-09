package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class InventoryPage {

    public InventoryPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement shoppingCartIcon;

    public void clickAddToCartButton(String productName) {
        //  "Sauce Labs Backpack" -> "sauce-labs-backpack")
        String formattedName = productName.toLowerCase().replace(" ", "-");

        String dynamicId = "add-to-cart-" + formattedName;

        WebElement dynamicAddToCartBtn = DriverManager.getDriver().findElement(By.xpath("//button[@id='" + dynamicId + "']"));

        ReusableMethods.waitForElementClickable(dynamicAddToCartBtn, 5);
        dynamicAddToCartBtn.click();
    }
    public void clickShoppingCartIcon() {
        ReusableMethods.waitForElementClickable(shoppingCartIcon, 5);
        shoppingCartIcon.click();
    }
}