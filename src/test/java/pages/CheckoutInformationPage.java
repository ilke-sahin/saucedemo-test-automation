package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;
import utilities.ReusableMethods;


public class CheckoutInformationPage {
    public CheckoutInformationPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @FindBy(id="continue")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCodeInput;


 public void clickbtnContinue(){
     ReusableMethods.waitForElementClickable(continueBtn, 10);
     continueBtn.click();
 }

 public void enterFirstName(String firstName){
     firstNameInput.sendKeys(firstName);
 }

 public void enterLastName(String lastName){
     lastNameInput.sendKeys(lastName);
 }

public void enterPostalCode(String postalCode){
     postalCodeInput.sendKeys(postalCode);
}

public void fillFormAndContinue(String firstName, String lastName, String postalCode) {
    enterFirstName(firstName);
    enterLastName(lastName);
    enterPostalCode(postalCode);
    clickbtnContinue();
}






}
