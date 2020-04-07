package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyApiPage extends BasePage{

    private By signUpButton = By.xpath("//a[@class='button filled']");

    public void clickOnSignUpButton(){
        clickOn(signUpButton);
    }


}
