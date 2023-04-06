package com.n11.web.qa.steps.SearchStoresPage;

import com.n11.web.qa.pages.SearchItemsPage.SearchItemsPage;
import com.n11.web.qa.pages.SearchStoresPage.SearchStoresPage;
import com.n11.web.qa.steps.Hooks;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;


public class SearchStoresSteps {

     private WebDriver webDriver;

    public SearchStoresSteps() {
        webDriver = Hooks.webDriver;
    }

    @When("user clicks to AllStores")
    public void userClicksToAllStores() throws InterruptedException {
        SearchStoresPage SearchStorespage = new SearchStoresPage (webDriver);
        SearchStorespage.getSearchStoresBtn().click();
        Thread.sleep(2000);
    }

    @And("user clicks on stores starting with the S letter")
    public void userClicksOnStoresStartingWithTheLetter() throws InterruptedException {
        SearchStoresPage searchStoresPage = new SearchStoresPage(webDriver);
        searchStoresPage.getLetterBtn().click();
        Thread.sleep(3000);
    }


    @And("user randomly clicks on a store starting with the letter S")
    public void userRandomlyClicksOnAStoreStartingWithTheLetterS() throws InterruptedException {
        SearchStoresPage searchStoresPage = new SearchStoresPage(webDriver);
        SearchItemsPage searchItemsPage = new SearchItemsPage(webDriver);
        searchStoresPage.getRandomSeller().click();
        Thread.sleep(5000);
        SearchStoresPage.checkSellerText(searchItemsPage.getStoreNameTextLowercase());

    }
}
