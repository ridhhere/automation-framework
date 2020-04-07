package framework.mobilePages;

import framework.AppiumWrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class FilterSessions extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Angular']")
    private MobileElement angularButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Communication']")
    private MobileElement communicationButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Design']")
    private MobileElement designButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Documentation']")
    private MobileElement documentationButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Food']")
    private MobileElement foodButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Ionic']")
    private MobileElement ionicButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Navigation']")
    private MobileElement navigationButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Services']")
    private MobileElement servicesButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Tooling']")
    private MobileElement toolingButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Workshop']")
    private MobileElement workshopButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Reset All Filters ']")
    private MobileElement resetAllFilter;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@class='android.widget.CheckBox']")
    private MobileElement allButtonsInFilter;

    private String xpathForFilter = "//android.widget.CheckBox";

    public void tapONAngularButton(){
        tapOn(angularButton);
    }

    public boolean isAllFilterEnabled() throws InterruptedException {
        Thread.sleep(2000);
        List <MobileElement> filterButtonList = AppiumWrapper.getAppiumDriver().findElements(By.xpath(xpathForFilter));
        for (MobileElement filter : filterButtonList){
            return filter.isEnabled();
            }
        throw new IllegalArgumentException();
    }

    public void tapOnResetAllFilter(){
        tapOn(resetAllFilter);
    }

}
