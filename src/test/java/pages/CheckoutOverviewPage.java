package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class CheckoutOverviewPage {

    public CheckoutOverviewPage() {
        PageFactory.initElements(utilities.DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> itemPrices;

    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    private WebElement displayedSubTotalPrice;




    @FindBy(id="finish")
    private WebElement btnFinish;

    public void clickFinishBtn(){
        ReusableMethods.waitForElementClickable(btnFinish, 10);
        btnFinish.click();
    }


    public double getCalculatedTotal() {
        double total = 0.0;
        for (WebElement priceElement : itemPrices) {

            String priceText = priceElement.getText().replace("$", "").trim();
            total += Double.parseDouble(priceText);

        }
        return total;
    }


    public double getDisplayedTotal() {
        ReusableMethods.waitForVisibility(displayedSubTotalPrice, 5);

        String totalText = displayedSubTotalPrice.getText()
                .replace("Item total: ", "")
                .replace("$", "")
                .trim();

        return Double.parseDouble(totalText);
    }
}
