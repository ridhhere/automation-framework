package framework.mobilePages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignupPage extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Signup']")
    private MobileElement signUpHeader;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='CREATE ']")
    private MobileElement createButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Username is required']")
    private MobileElement usernameInvalidError;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Password is required']")
    private MobileElement passwordInvalidError;



    public boolean isSignupHeaderDisplayed(){
        return isElementDisplayed(signUpHeader);
    }

    public void tapOnCreateButton(){
        tapOn(createButton);
    }

    public boolean usernameErrorDisplayed(){
        return isElementDisplayed(usernameInvalidError);
    }

    public boolean passwordErrorDisplayed(){
        return isElementDisplayed(passwordInvalidError);
    }


}
