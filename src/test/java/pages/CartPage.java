package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(id = "checkout")
    private WebElement btnCheckout;


    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartItems;

    @FindBy(className = "inventory_item_name")
    private WebElement product;

    public void clickCheckoutBtn() {
        ReusableMethods.waitForElementClickable(btnCheckout, 5);
        btnCheckout.click();
    }

    public boolean isProductDisplayed(String productName) {
            ReusableMethods.waitForVisibility(product, 5);
            return product.isDisplayed() && product.getText().equals(productName);
    }


    public int getCartItemCount() {

        return cartItems.size();
    }
}