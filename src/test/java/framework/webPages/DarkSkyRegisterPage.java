package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

public class DarkSkyRegisterPage extends BasePage {

    private By registerButton = By.xpath("//div[1]/form/div/div/fieldset/div[4]/div/button");
    private By pageTitle = By.xpath("//body/div[1]/h1");
    private By emailAddress = By.xpath("//body/div[1]/form/div/div/fieldset/div[1]/div/div/input");


    public void clickOnRegisterButton() {
        clickOn(registerButton);
    }

    public String verifyErrorMessage() {
        WebElement username = getWebElement(emailAddress);
        return username.getAttribute("validationMessage");
    }

}
