package Step_Definition;

import Base.BaseClass;
import Pom.Cart_Page;
import Pom.Home_Page;
import Pom.VegPizza_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Base.BaseClass.driver;



    public class Step extends BaseClass {
        Home_Page home_page;
        Cart_Page cart_Page;
        VegPizza_Page vegPizza_page;

        @Given("User Launch {string} browser and url {string}")
        public void userLaunchBrowserAndUrl(String browser, String url) {
            BaseClass.initializeBrowser(browser);
            BaseClass.windowMax();
            BaseClass.launchBrowser(url);
            BaseClass.waitImplicitly();
            home_page = new Home_Page(driver);
            cart_Page = new Cart_Page(driver);
            vegPizza_page = new VegPizza_Page(driver);
        }

        @When("User click on order online now button")
        public void userClickOnOrderOnlineNowButton() throws InterruptedException {
            home_page.clickOrderOnBtn();
        }

        @And("User click the delivery address")
        public void userClickTheDeliveryAddress() throws InterruptedException {
            home_page.clickAddField();
        }

        @And("User click the Enter area\\/Locality")
        public void userClickTheEnterAreaLocality() throws InterruptedException {
            home_page.clickEnterField();
        }

        @And("User enter the pincode {string}")
        public void userEnterThePincode(String pinCode) throws InterruptedException {
            home_page.addPincode(pinCode);
        }

        @And("User select the first suggestion")
        public void userSelectTheFirstSuggestion() throws InterruptedException {
            home_page.clickOnFirstArea();
        }

        @Then("User should navigate to the product page")
        public void userShouldNavigateToTheProductPage() {
            String url = driver.getCurrentUrl();
            System.out.println(url);
        }

        @And("User adds two quantities of Margherita pizza")
        public void userAddsTwoQuantitiesOfMargheritaPizza() throws InterruptedException {
            vegPizza_page.addMargherita();
        }

        @And("User adds two quantities of Peppy Paneer pizza")
        public void userAddsTwoQuantitiesOfPeppyPaneerPizza() {
            vegPizza_page.addPeppyPaneer();
        }

        @And("User adds two quantities of Corn & Cheese pizza")
        public void userAddsTwoQuantitiesOfCornCheesePizza() {
            vegPizza_page.addCheeseCorn();
        }

        @And("User verifies subtotal value and sum of all product values are same")
        public void userVerifiesSubtotalValueAndSumOfAllProductValuesAreSame() {
            Assert.assertTrue(vegPizza_page.totalOfpizza());
        }

        @And("User adds tweleve quantities of pepsi")
        public void userAddsTweleveQuantitiesOfPepsi() {
            vegPizza_page.addPepsi();
        }

        @And("User verifies the subtotal value and sum of all product values are same")
        public void userVerifiesTheSubtotalValueAndSumOfAllProductValuesAreSame() throws InterruptedException {
            vegPizza_page.allProductPrice();
            Thread.sleep(2000);
            Assert.assertTrue(vegPizza_page.allProductPrice());
        }

        @And("User removes one quantity of Margherita pizza")
        public void userRemovesOneQuantityOfMargheritaPizza() {
            vegPizza_page.remMargPizza();
        }

        @And("User removes six quanties of pepsi")
        public void userRemovesSixQuantiesOfPepsi() {
            vegPizza_page.remPepsi();
        }

        @When("User click on checkout")
        public void userClickOnCheckout() {
            cart_Page.subPrice();
            cart_Page.clickCheckOut();
        }

        @And("User verifies the checkout subtotal value and place order subtotal are same")
        public void userVerifiesTheCheckoutSubtotalValueAndPlaceOrderSubtotalAreSame() {
            Assert.assertTrue(cart_Page.verifyAmount());
        }

        @Then("User close the browser")
        public void userCloseTheBrowser() {
            quit();
        }
    }


