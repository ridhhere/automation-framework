package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;

/**
 * Created by mohammadmuntakim.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|email mobile|new password) text fields on home screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail(anyText);
                break;
            case "password":
                homePage.enterPassword(anyText);
                break;
            case "firstname":
                homePage.enterFirstName(anyText);
                break;
            case "lastname":
                homePage.enterLastName(anyText);
                break;
            case "email mobile":
                homePage.enterEmailMobile(anyText);
                break;
            case "new password":
                homePage.enterNewPassword(anyText);
                break;
        }
    }

    @When("^I click on (email mobile|new password) text fields on home screen$")
    public void clickOnTextFields(String textFields) {
        switch (textFields) {
            case "email mobile":
                homePage.clickOnEmailMobileTextField();
                break;
            case "new password":
                homePage.clickOnNewPasswordTxtField();
                break;
        }
    }

    @When("^I click on (login|create account) button on home screen$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "create account":
                //Implement Create account object
                break;
        }
    }

    @When("^I select current month from (month|day|year) dropdown on home screen$")
    public void selectOnDropDown(String dropDown){
        switch ((dropDown)){
            case"month":
                homePage.selectCurrentMonthFromDropDown();

        }
    }

    @When("^I select month from (month) dropdown on home screen$")
    public void selectMonthOnDropDown(String dropDown){
        homePage.dropDownContainsDuplicate();
    }

    @Then("^I verify that i am an invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }

    @Then("^I verify invalid email error message$")
    public void verifyInvalidEmailErrorMessage(){
        Assert.assertEquals(homePage.getInvalidMobileNumberError(),"Please enter a valid mobile number or email address.");
    }

    @Then("^I verify current month is selected from month dropdown$")
    public void verifyCurrentMonth(){
        Assert.assertEquals(homePage.getSelectedMonthText(), homePage.getCurrentMonthTextFromCalendar());

    }
    @Then("^I verify if month doesn't contain duplicate value$")
    public void verifyDuplicateMonth(){
        Assert.assertFalse(homePage.verifyDropDownContainsDuplicate());
    }
}
