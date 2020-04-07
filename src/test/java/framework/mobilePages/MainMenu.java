package framework.mobilePages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainMenu extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Menu']")
    private MobileElement sidebarHeader;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='person add Signup ']")
    private MobileElement signUpButton;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@class='android.widget.Button']")
    private MobileElement menuOptions;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='hammer Show Tutorial ']")
    private MobileElement showTutorial;



    public boolean isMenuPresent() {
        return isElementDisplayed(sidebarHeader);
    }

    public void tapOnSignUpButton(){
        tapOn(signUpButton);
    }

    public void tapOnMenuOption(){
        tapOn(menuOptions);
    }

    public void tapOnShowTutorial(){
        tapOn(showTutorial);
    }
}
