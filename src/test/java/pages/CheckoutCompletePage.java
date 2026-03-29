package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class CheckoutCompletePage {
    public CheckoutCompletePage() {
        PageFactory.initElements(utilities.DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    private WebElement successMessage;


    public String getSuccessMessageText() {
        ReusableMethods.waitForVisibility(successMessage, 5);
        return successMessage.getText().trim();
    }
}

