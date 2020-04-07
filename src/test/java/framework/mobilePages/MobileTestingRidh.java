package framework.mobilePages;

import framework.AppiumWrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTestingRidh {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    private MobileElement skipButton;

    @AndroidFindBy(id = "3b080b12-95bd-4405-afee-df421b4580ca")
    private MobileElement searchMaps;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    private MobileElement skipButtonApp;





    AppiumDriver driver;

    @Test
    public void appiumEmulatorApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Pixel3_API27");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1.0");
        cap.setCapability("appPackage", "com.applause.automation.ionicconference");
        cap.setCapability("appActivity", "com.applause.automation.ionicconference.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, cap);
        Thread.sleep(10000);
        MobileElement skipButton = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc='SKIP ']"));
        skipButton.click();
        Thread.sleep(4000);
    }

    @Test
    public void appiumAppCalculator() throws MalformedURLException {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "Alcatel JOY TAB");
            cap.setCapability("udid", "BQNBB6TOQOVWHAEA");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "9");
            cap.setCapability("appPackage", "com.tct.tablet.calculator");
            cap.setCapability("appActivity", "com.tct.calculator.Calculator");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AppiumDriver<MobileElement>(url, cap);



//            skipButton.click();

    }

    @Test
    public void appiumFacebookInTab() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Alcatel JOY TAB");
        cap.setCapability("udid", "BQNBB6TOQOVWHAEA");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("appPackage", "com.google.android.apps.maps");
        cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, cap);

        Thread.sleep(6000);

        MobileElement search = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Search here ']"));
        search.sendKeys("Manhattan");

    }

}
