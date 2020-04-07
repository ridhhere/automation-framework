package framework.webPages;


import gherkin.lexer.Ca;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

public class DarkSkyHomePage extends BasePage {
    private By darkSkyApi = By.xpath("/html/body/nav/div/a[4]");
    private By currentTimelineTempList = By.xpath("//*[@id='timeline']/div/div[4]/child::*");
    private By currentTemp = By.xpath("//*[@id='title']/span[1]/span[2]/span[1]");
    private By todayTimeline = By.xpath("//*[@id='week']/a[1]");
    private By todayTimelineDisplayedMinTemp = By.xpath("//*[@id='week']/a[1]/span[2]/span[1]");
    private By todayTimelineExpectedMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']/span[1]");
    private By todayTimelineDisplayedMaxTemp = By.xpath("//*[@id='week']/a[1]/span[2]/span[3]");
    private By todayTimelineExpectedMaxTemp = By.xpath("//*[@id='week']/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");
    private By currentTimelineTimeList = By.xpath("//*[@id='timeline']/div/div[3]/child::*");


    public void clickOnDarkSkyApi(){
        clickOn(darkSkyApi);
    }

    public boolean verifyCurrentTemp(){
        int currentCompareTemp = Integer.parseInt(getTextFromElement(currentTemp).replaceAll("[^\\d]",""));
        List<WebElement> currentTimelineTempWebList = webAction(currentTimelineTempList).findElements(currentTimelineTempList);
        ArrayList<Integer> currentTimelineTempInt = new ArrayList<>();
        for(WebElement temp:currentTimelineTempWebList){
            currentTimelineTempInt.add(Integer.parseInt(temp.getText().replaceAll("°","")));
        }
        int minimum = currentTimelineTempInt.get(0);
        for (int i : currentTimelineTempInt){
            minimum = minimum < i ? minimum : i;
        }
        int maximum = currentTimelineTempInt.get(0);
        for (int i : currentTimelineTempInt){
            maximum = maximum > i ? maximum : i;
        }
        return currentCompareTemp>=minimum && currentCompareTemp<=maximum;
    }

    public void clickOnTodayTimeline() {
        clickOn(todayTimeline);
    }

    public void scrollToTodayTimeline() throws InterruptedException {
        scrollByPixel(850);
    }

    public boolean verifyTodayTemp(){
        int displayedMinTemp = Integer.parseInt(getTextFromElement(todayTimelineDisplayedMinTemp).replaceAll("˚",""));
        int displayedMaxTemp = Integer.parseInt(getTextFromElement(todayTimelineDisplayedMaxTemp).replaceAll("˚",""));
        int expectedMinTemp = Integer.parseInt(getTextFromElement(todayTimelineExpectedMinTemp).replaceAll("˚",""));
        int expectedMaxTemp = Integer.parseInt(getTextFromElement(todayTimelineExpectedMaxTemp).replaceAll("˚",""));
        return displayedMinTemp==expectedMinTemp&displayedMaxTemp==expectedMaxTemp;
    }

    public boolean verifyTwoHours(){
        boolean result = false;
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("ha");
        calendar.add(Calendar.MINUTE,-5);
        List<WebElement> currentTimelineTimeWebList = webAction(currentTimelineTempList).findElements(currentTimelineTimeList);
        ArrayList<String> compareTime = new ArrayList<>();
        ArrayList<String> currentTimelineTimeArrayList= new ArrayList<>();

        for(int i=1;i<12;i++){
            calendar.add(Calendar.HOUR_OF_DAY, 2);
            compareTime.add(sdf.format(calendar.getTime()).replaceAll("PM","pm").replaceAll("AM","am"));
        }
        for(WebElement str:currentTimelineTimeWebList){
            currentTimelineTimeArrayList.add(str.getText());
        }
        currentTimelineTimeArrayList.removeAll(Collections.singleton(""));
        currentTimelineTimeArrayList.remove(0);

        if(compareTime.equals(currentTimelineTimeArrayList))
            result = true;

        return result;
    }


}
