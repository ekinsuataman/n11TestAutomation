package com.n11.web.qa.steps.SearchItemsPage;

import com.n11.web.qa.pages.SearchItemsPage.SearchItemsPage;
import com.n11.web.qa.steps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItemsSteps {

        private WebDriver webDriver = Hooks.webDriver;;


    @And("user fills in SearchArea field with {string}")
    public void userFillsInSearchAreaFieldWith(String Item) throws InterruptedException {
        SearchItemsPage searchItemsPage = new SearchItemsPage(webDriver);
        searchItemsPage.getSearchArea().sendKeys(Item);
        Thread.sleep(3000);
    }


    @And("user clicks to Search Button")
    public void userClicksToSearchButton() throws InterruptedException {
            SearchItemsPage itemsPage = new SearchItemsPage(webDriver);
            itemsPage.getSearchBtn().click();
            Thread.sleep(4000);
    }

    @And("scroll down to page")
    public void scrollDownSearchResultsPage() {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0, 1000)");
        }

    @Then("user clicks to Add Basket Button for First Item")
    public void userClicksToAddBasketButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.clickFirstItemToAddBasket();
        Thread.sleep(3000);
    }

    @And("user clicks to Phone Color")
    public void userClicksToPhoneColorButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.clickSecondItemToChooseColor();
        Thread.sleep(3000);
    }

    @And("user clicks to Internal Memory")
    public void userClicksToInternalMemoryButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.clickFifthItemToChooseMemory();
        Thread.sleep(3000);
    }

    @And("user clicks to Add Basket Green Button")
    public void userClicksToAddBasketGreenButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.getAddBasketGreenBtn().click();
        Thread.sleep(3000);
    }

    @And("scroll down to end of page")
    public void scrollDownSearchResultsPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, 2500)");
    }

    @Then("user clicks to Add Basket Button for Last Item")
    public void userClicksToAddBasketButtonForLastItem() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.clickLastItemToAddBasket();
        Thread.sleep(3000);
    }

    @And("user clicks to White Basket Button")
    public void userClicksToWhiteBasketButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.getWhiteBasketBtn().click();
        Thread.sleep(3000);
    }

    @And("user clicks to Privacy Approval Button")
    public void userClicksToApprovalButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.getApprovalBtn().click();
        Thread.sleep(3000);
    }

    @And("user clicks to Buy Button")
    public void userClicksToBuyButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.getBuyBtn().click();
        Thread.sleep(3000);
    }

    @And("user selects Second Brand from Filter")
    public void userSelectSelectSecondBrandOption() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollBy(0, 300)",searchitemsPage.getFilterArea());
        searchitemsPage.clickSecondBrandToFilter();
        Thread.sleep(3000);
    }


    @And("user clicks to Sorting Button")
    public void userClicksToSortingButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.getSortingBtn().click();
        Thread.sleep(3000);
    }

    @And("user clicks to Sort by Comment Button")
    public void userClicksToSortByCommentButton() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        searchitemsPage.getSortByReviewsBtn().click();
        searchitemsPage.CheckRatingTextsIsDescending();
        Thread.sleep(3000);
    }

    @And("user selects to Free Shipping Filter")
    public void userSelectFreeShippingOption() throws InterruptedException {
        SearchItemsPage searchitemsPage = new SearchItemsPage(webDriver);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollBy(0, 900)",searchitemsPage.getFilterArea());
        searchitemsPage.getCargoFilterLabel().click();
        Thread.sleep(3000);
        searchitemsPage.clickFreeShippingCheckbox(webDriver);
        searchitemsPage.isEveryListedItemShippingFree();
    }

    @FindBy(css = "#breadCrumb a:nth-child(2) span")
    private WebElement storeNameText;
    public String getStoreNameTextLowercase() {
        return storeNameText.getText().toLowerCase();
    }




}


