package framework.mobilePages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomeScreen extends MobileBasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    private MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.widget.Button[1]")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement hamburger;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='options ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='CONTINUE arrow forward ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement continueButton;

    public void tapOnSkipButton()  {
        tapOn(skipButton);
    }

    public void tapOnMainMenuButton() {
        tapOn(hamburger);
    }

    public boolean isSkipButtonDisplayed(){
        return isElementDisplayed(skipButton);
    }

    public boolean isHamburgerDisplayed(){
        return isElementDisplayed(hamburger);
    }

    public void tapOnFilterButton(){
        tapOn(filterButton);
    }

    public void swipeRight(int times){
        swipeRightOnScreen(times);
    }

    public boolean isContinueButtonDisplayed(){
        return isElementDisplayed(continueButton);
    }
}
