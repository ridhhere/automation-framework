package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelHomePage;
import org.testng.Assert;


public class HotelSD {
    HotelHomePage hotelHomePage = new HotelHomePage();



    @Given("^I am on hotel.com home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
    }

    @Given("^I am on default locations search result screen$")
    public void iAmOnDefaultSearchResult() {
        Assert.assertTrue(hotelHomePage.verifyDefaultSearchDestination());
    }

    @When("^I select more options$")
    public void iSelectMoreOption()  {
        hotelHomePage.selectMoreOptions();
    }

    @When("^I select property class (.+)$")
    public void iSelectPropertyClass(String anyText)  {
        switch (anyText){
            case "5-star":
                hotelHomePage.clickOnFiveStar();
                break;
            case "4-star":
                hotelHomePage.clickOnFourStar();
                break;
            case "3-star":
                hotelHomePage.clickOnThreeStar();
                break;
        }
    }

    @When("^I select (.+) from room dropdown$")
    public void iSelectFromRoomDropdown(String anyText) {
        hotelHomePage.selectRoom(anyText);
    }

    @Then("I verify system displays only (.+) hotels on search result$")
    public void verifySystemDisplayStars(String anyText) {
        Assert.assertTrue(hotelHomePage.verifyCorrectStars(anyText));
    }

    @Then("I verify system displays all hotels within 10 miles radius of airport$")
    public void verifyAllHotelNearJFK() throws InterruptedException {
        Assert.assertTrue(hotelHomePage.displayAllHotelNearJfk());
    }

    @Then("I verify todays deal is less than (.+)$")
    public void verifyTodaysDealIsLess(int price) {
        Assert.assertTrue(hotelHomePage.verifyTodaysDeal()<=price);
    }

    @Then("I verify (.+) is displayed$")
    public void iVerifyRooms(int anyText) {
        Assert.assertTrue(hotelHomePage.verifyRooms() == anyText);
    }


    @And("I verify Hilton Hotel is within radius$")
    public void verifyHiltonHotel() {
        Assert.assertTrue(hotelHomePage.verifyHiltonHotel());
    }

}
