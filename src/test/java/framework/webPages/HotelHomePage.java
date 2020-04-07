package framework.webPages;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelHomePage extends BasePage{
    private By roomsSelectDropdown = By.xpath("//select[@id='qf-0q-rooms']");
    private By moreRoomsSelectDropdown = By.xpath("//*[@id='qf-0q-rooms']");
    private By selectedSizeRoomCheck = By.xpath("//div[@class='widget-query-group widget-query-room-options']");
    private By destinationSearchBar = By.xpath("//*[@id='qf-0q-destination']");
    private By suggestedAddress = By.xpath("//tr[@id='citysqm-asi0-s0']/td/div[2]");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By verifyLinkTextForDefaultSearch = By.linkText("Show recent searches");
    private By fiveStars = By.xpath("//*[@id='f-star-rating-5']");
    private By fourStars = By.xpath("//*[@id='f-star-rating-4']");
    private By threeStars = By.xpath("//*[@id='f-star-rating-3']");
    private By scrollToLoadingArea = By.xpath("//div[@id='resp-footer']/div[1]/div/h2");
    private By verifyStars = By.xpath("//div/span[contains(text(),'star')]");
    private By sortByLandMark = By.xpath("//*[@id='filter-landmarks']/legend/h3");
    private By sortByDistance = By.xpath("//*[@id='f-distance']");
    private By jfkAirport = By.xpath("//*[@id='f-label-lid-1662393']");
    private By nameOfHotelsNearJFK = By.xpath("//div[@class='description resp-module']/h3");
    private By distanceVerify = By.xpath("//div[@class='additional-details resp-module']//ul[@class='property-landmarks']/*[contains(text(),'JFK')]");
    private By todayDealPrice = By.xpath("//li[contains(@class,'hotel deal-of-the-day')]//ins");



    public boolean verifyDefaultSearchDestination() {
        boolean result = true;
        setValue(destinationSearchBar,"New York");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        clickOn(suggestedAddress);
        clickOn(searchButton);
        if(verifyLinkTextForDefaultSearch.toString().contains("Show recent search")){
        }

        return result;
    }

    public void selectMoreOptions()  {
        selectFromDropdown(roomsSelectDropdown,2);
    }

    public void clickOnFiveStar(){
        clickOn(fiveStars);
    }

    public void clickOnFourStar(){
        clickOn(fourStars);
    }

    public void clickOnThreeStar() {
        scrollToElement(threeStars);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        clickOn(threeStars);
    }

    public void selectRoom(String select){
        selectFromDropdown(moreRoomsSelectDropdown,select);
    }

    public int verifyRooms(){
        try {
            List<WebElement> verifyAllRooms = webAction(selectedSizeRoomCheck).findElements(selectedSizeRoomCheck);
            return verifyAllRooms.size();
        } catch (NoSuchElementException e) {
            return 0;
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public boolean verifyCorrectStars(String value){
        scrollSlowlyToElement(scrollToLoadingArea);
        boolean result = false;
        List<WebElement> verifyList = SharedSD.getDriver().findElements(verifyStars);
        ArrayList<String> verifyArray = new ArrayList<>();
        for(WebElement text :verifyList){
            verifyArray.add(text.getText());
            if(verifyArray.contains(value)){
                result = true;
            }
        }
        return result;
    }

    public boolean displayAllHotelNearJfk() throws InterruptedException {
        boolean result = false;
        scrollToElement(sortByLandMark);
        clickOn(sortByLandMark);
        clickOn(jfkAirport);
        selectFromDropdown(sortByDistance,"10 miles");
        scrollSlowlyToElement(scrollToLoadingArea);

        List<WebElement> distanceVerifyList = SharedSD.getDriver().findElements(distanceVerify);
        for(WebElement distance:distanceVerifyList){
            double distanceCompare = Double.parseDouble(distance.getText().replace(" miles to John F. Kennedy International Airport (JFK)",""));
            if(distanceCompare<=10){
                result = true;
            }
        }   return result;
    }

    public boolean verifyHiltonHotel()  {
        boolean result = false;
        List<WebElement> nameOfHotelList = SharedSD.getDriver().findElements(nameOfHotelsNearJFK);
        for(WebElement name:nameOfHotelList){
            if(name.getText().contains("Hilton")){
                result = true;
            }
        } return result;
    }

    public int verifyTodaysDeal() {
        clickOnThreeStar();
        int comparePrice = Integer.parseInt(getTextFromElement(todayDealPrice).replaceAll("[^\\d]",""));
        System.out.println(comparePrice);
        return comparePrice;
    }





}
