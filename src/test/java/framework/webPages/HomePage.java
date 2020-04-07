package framework.webPages;

import cucumber.api.java.cy_gb.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class HomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.xpath("//*[@id='login_form']/table/tbody/tr[2]/td[3]");
	private By firstNameTextField = By.xpath("//input[@id='u_0_f']");
	private By lastNameTextField = By.xpath("//input[@id='u_0_h']");
	private By emailMobileTextField = By.xpath("//input[@id='u_0_k']");
	private By newPasswordTextField = By.xpath("//input[@id='u_0_r']");
	private By errorMessage = By.id("errorMessage");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.id("");
	private By forgotAccountLink = By.xpath("//a[contains(text(),'Forgot account?')]");
	private By invalidMobileNumberError = By.xpath("//div[contains(text(),'valid mobile number or email')]");
	private By monthDropdownField = By.xpath("//select[@id='month']");



	public void clickOnLoginButton(){
		clickOn(loginButton);
	}

	public String getInvalidMobileNumberError(){
		return getTextFromElement(invalidMobileNumberError);
	}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void enterEmailMobile(String mobileNum) {
		setValue(emailMobileTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public boolean isGenderFemaleSelected() {
		return isElementSelected(femaleGender);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGender);
	}

	public boolean isGenderMaleSelected() {
		return isElementSelected(maleGender);
	}

	public void clickOnMaleGender() {
		clickOn(maleGender);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}

	public void clickOnForgotAccountLink(){
		clickOn(forgotAccountLink);
	}

	public void clickOnNewPasswordTxtField(){
		clickOn(newPasswordTextField);
	}

	public void clickOnEmailMobileTextField(){
		clickOn(emailMobileTextField);
	}


	public String getCurrentMonthTextFromCalendar(){
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM");
		return sdf.format(currentDate);
	}

	public void selectCurrentMonthFromDropDown(){
		selectFromDropdown(monthDropdownField, getCurrentMonthTextFromCalendar());
	}

	public String  getSelectedMonthText(){
		return getTextFromSelectedDropDown(monthDropdownField);
	}
	public void dropDownContainsDuplicate() {
		List<WebElement> monthsList = webAction(monthDropdownField).findElements(monthDropdownField);
		HashSet<String> monthsListDuplicate = new HashSet<>();
		ArrayList<String> duplicateValue = new ArrayList<>();
		for (WebElement month : monthsList) {
			if (monthsListDuplicate.add(month.getText()) == false){
				duplicateValue.add(month.getText());
			} else{
				monthsListDuplicate.add(month.getText());
			}
			System.out.println(duplicateValue);
		}
	}

	public boolean verifyDropDownContainsDuplicate() {
		return isDropDownHasDuplicates(monthDropdownField);

	}








}
