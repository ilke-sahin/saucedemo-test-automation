package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utilities.*;

public class OrderSteps {

    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutInformationPage infoPage = new CheckoutInformationPage();
    CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage completePage = new CheckoutCompletePage();

    @Given("User is on the Saucedemo login page")
    public void navigateToLoginPage() {
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @When("User logs in with valid credentials")
    public void loginWithValidCredentials() {

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.login(username, password);
    }

    @And("User adds {string} to the cart")
    public void addProductToCart(String productName) {
        inventoryPage.clickAddToCartButton(productName);
    }

    @And("User goes to the cart")
    public void navigateToCart() {
        inventoryPage.clickShoppingCartIcon();
    }

    @And("User validates that {string} is present in the cart")
    public void verifyProductInCart(String productName) {
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " was not found in the cart!");
    }

    @And("User validates that both items are present in the cart")
    public void verifyBothItemsInCart() {
        Assert.assertEquals(cartPage.getCartItemCount(), 2, "Number of items in the cart is not 2!");
    }

    @And("User proceeds to checkout")
    public void proceedToCheckout() {
        cartPage.clickCheckoutBtn();
    }

    @And("User fills the information form with {string}, {string}, {string}")
    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        infoPage.fillFormAndContinue(firstName, lastName, postalCode);
    }

    @And ("User validates the final price equals the sum of both product prices")
    public void verifyFinalPrice() {
        double expected = overviewPage.getCalculatedTotal();
        double actual = overviewPage.getDisplayedTotal();

        Assert.assertEquals(actual, expected, "Prices do not match!");
    }

    @And("User completes the checkout")
    public void completeCheckout() {
        overviewPage.clickFinishBtn();
    }

    @Then("User should see the success message {string}")
    public void verifySuccessMessage(String expectedMessage) {
        String actualMessage = completePage.getSuccessMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, "Success message did not match!");
    }
}