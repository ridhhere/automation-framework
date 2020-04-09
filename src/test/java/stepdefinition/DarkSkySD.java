package stepdefinition;

import com.google.common.base.Verify;
import cucumber.api.java.cy_gb.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyApiPage;
import framework.webPages.DarkSkyHomePage;
import framework.webPages.DarkSkyRegisterPage;
import gherkin.lexer.Th;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;


public class DarkSkySD {
    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();
    DarkSkyApiPage darkSkyApiPage = new DarkSkyApiPage();
    DarkSkyRegisterPage darkSkyRegisterPage = new DarkSkyRegisterPage();

    @Given("^I am on Darksky Home Page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - Broadway, New York, NY");
    }

    @Given("^I am on the Darksky Register page$")
    public void iAmOnRegisterPage() {
        darkSkyHomePage.clickOnDarkSkyApi();
        darkSkyApiPage.clickOnSignUpButton();
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky API: Register");
    }

    @When("^I click on Register button$")
    public void clickOnRegisterButton(){
        darkSkyRegisterPage.clickOnRegisterButton();
    }

    @When("^I expand todays timeline$")
    public void expandTodayTimeline() {
        darkSkyHomePage.scrollToTodayTimeline();
        darkSkyHomePage.clickOnTodayTimeline();
    }

    @Then("^I verify error message$")
    public void verifyUnableToRegister(){
        Assert.assertEquals(darkSkyRegisterPage.verifyErrorMessage(),"Please fill out this field.");
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTemp(){
        Assert.assertTrue(darkSkyHomePage.verifyCurrentTemp());
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLowHighTempDisplayed(){
        Assert.assertTrue(darkSkyHomePage.verifyTodayTemp());
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimelineWithTwoHoursIncremented(){
        Assert.assertTrue(darkSkyHomePage.verifyTwoHours());
    }

}
