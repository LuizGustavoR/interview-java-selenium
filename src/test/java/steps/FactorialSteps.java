package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import setup.SetupMyWebDriver;

public class FactorialSteps {

    private WebDriver webDriver;
    private HomePage homePage;

    @Before
    public void setUp(){
        webDriver = new SetupMyWebDriver().getWebDriver();
        homePage = new HomePage(webDriver);
    }

    @Given("The factorial page is displayed")
    public void theFactorialPageIsDisplayed() {
        webDriver.get("https://qainterview.pythonanywhere.com/");
    }

    @When("I search for {string}")
    public void iSearchForOperation(String operation) {
        homePage.search(operation);
    }

    @Then("results equals {string}")
    public void resultsEqualsResult(String result) {
        String current = homePage.getResult();
        Assert.assertEquals(current, result);
    }

    @After
    public void quit(){
        webDriver.quit();
    }

}
