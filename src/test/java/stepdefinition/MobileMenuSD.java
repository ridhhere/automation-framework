package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AppiumWrapper;
import framework.mobilePages.FilterSessions;
import framework.mobilePages.HomeScreen;
import framework.mobilePages.MainMenu;
import framework.mobilePages.SignupPage;
import gherkin.lexer.Th;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class MobileMenuSD {

    private MainMenu mainMenu = new MainMenu();
    private HomeScreen homeScreen = new HomeScreen();
    private SignupPage signupPage = new SignupPage();
    private FilterSessions filterSessions = new FilterSessions();
    private AppiumWrapper driver = new AppiumWrapper();


    @Given("^I am on home page of the app$")
    public void verifyIamOnHomePage() throws InterruptedException {
        driver.restartApplication();
        homeScreen.tapOnSkipButton();
        Thread.sleep(1000);
        Assert.assertTrue(homeScreen.isHamburgerDisplayed());
    }

    @Given("^I am on Splash screen of the ionic conference app$")
    public void verifyIamOnSplashScreen(){
        driver.restartApplication();
        Assert.assertTrue(homeScreen.isSkipButtonDisplayed());
    }

    @Given("^I am on signup screen$")
    public void verifySinupScreen() throws InterruptedException {
        driver.restartApplication();
        homeScreen.tapOnSkipButton();
        Thread.sleep(1000);
        homeScreen.tapOnMainMenuButton();
        mainMenu.tapOnSignUpButton();
        Assert.assertTrue(signupPage.isSignupHeaderDisplayed());
    }

    @When("^I tap on skip button")
    public void clickOnSkipButton()  {
        homeScreen.tapOnSkipButton();
    }

    @When("^I click on hamburger menu$")
    public void clickOnMenuButton() throws InterruptedException {
        Thread.sleep(1000);
        homeScreen.tapOnMainMenuButton();
    }

    @When("^I tap on create button from signup screen$")
    public void tapOncreateButtonFromSignup(){
        signupPage.tapOnCreateButton();
    }

    @When("^I click on filter button$")
    public void clickOnfilterButton(){
        homeScreen.tapOnFilterButton();
    }

    @When("^I swipe right (.+) times on tutorials slides$")
    public void swipeRight3Times(int times) throws InterruptedException {
        homeScreen.swipeRight(times);
    }

    @And("^I disable 'Angular' option$")
    public void disableAngularOption() throws InterruptedException {
        filterSessions.tapONAngularButton();
    }

    @And("^I click on All Reset Filter button$")
    public void clickOnReset(){
        filterSessions.tapOnResetAllFilter();
    }

    @Then("^I verify all options are enabled")
    public void verifyOptionEnabled() throws InterruptedException {
        Assert.assertTrue(filterSessions.isAllFilterEnabled());
    }

    @Then("^I verify sidebar menu is displayed correctly$")
    public void verifySidebarMenu() {
        Assert.assertTrue(mainMenu.isMenuPresent());
    }

    @Then("^I verify invalid username text$")
    public void
    verifyInvalidUsername(){
        Assert.assertTrue(signupPage.usernameErrorDisplayed());
    }

    @Then("^I verify invalid password text$")
    public void verifyInvalidPassword(){
        Assert.assertTrue(signupPage.passwordErrorDisplayed());
    }

    @Then("^I verify continue button$")
    public void iverifyContinueButton(){
        Assert.assertTrue(homeScreen.isContinueButtonDisplayed());
    }



}
