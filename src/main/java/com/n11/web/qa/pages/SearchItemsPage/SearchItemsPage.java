package com.n11.web.qa.pages.SearchItemsPage;

import com.n11.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
public class SearchItemsPage extends BasePage {

    @FindBy(id = "searchData")
    private WebElement SearchArea;

    @FindBy(className = "iconsSearch")
    private WebElement SearchBtn;

    @FindBy(className = "btnBasket")
    private List<WebElement> AddBasketBtnList;

    public void clickFirstItemToAddBasket(){
        WebElement firstElement = AddBasketBtnList.get(0);
        firstElement.click();
    }


    @FindBy(className = "skus-item")
    private List<WebElement>  SkusItemsList;

    public void clickSecondItemToChooseColor(){
        WebElement secondElement = SkusItemsList.get(1);
        secondElement.click();
    }

    @FindBy(css = "[data-name='Dahili Hafıza'] .skus-item")
    private List<WebElement>  MemoryItemsList;

    public void clickFifthItemToChooseMemory(){
        WebElement memoryElement = MemoryItemsList.get(0);
        memoryElement.click();
    }

    @FindBy(css = ".baseBtn-green")
    private WebElement AddBasketGreenBtn;


    public void clickLastItemToAddBasket(){
        int lastItemIndex = AddBasketBtnList.size()-1;
        WebElement firstElement = AddBasketBtnList.get(lastItemIndex);
        firstElement.click();

        if(MemoryItemsList.size()>0){
            clickSecondItemToChooseColor();
            clickFifthItemToChooseMemory();;
            AddBasketGreenBtn.click();
        }
    }

    @FindBy(css = ".iconsBasketWhite")
    private WebElement WhiteBasketBtn;


    @FindBy(css = ".btnHolder .btnBlack")
    private WebElement ApprovalBtn;

    @FindBy(css = ".btnHolder #js-buyBtn")
    private WebElement BuyBtn;

    @FindBy(css= "section.filter[data-hdfl='m'] .filterList a")
    private List<WebElement> filterBrandOptionsList;

    public void clickSecondBrandToFilter(){
        WebElement secondBrandElement = filterBrandOptionsList.get(1);
        secondBrandElement.click();
    }


    @FindBy(className = "selectedText")
    private WebElement sortingBtn;

    @FindBy(xpath="//div[@class='item i4'][@data-value='REVIEWS']")
    private WebElement sortByReviewsBtn;

    @FindBy(className = "ratingText")
    private List<WebElement> ratingTextsList;

    public boolean CheckRatingTextsIsDescending(){
        List<String> ratingStringsList = ratingTextsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Pattern pattern = Pattern.compile("\\((\\d+)\\)");
        Integer[] values = ratingStringsList.stream()
                .map(pattern::matcher)
                .filter(Matcher::find)
                .map(matcher -> Integer.parseInt(matcher.group(1)))
                .toArray(Integer[]::new);
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] < values[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @FindBy(css = "section.filter.cargoFilter.acc h2")
    private WebElement cargoFilterLabel;

    @FindBy(css =".filterArea")
    private WebElement filterArea;

    @FindBy(css = "#freeShipmentOption span")
    private WebElement freeShippingOption;

    public void clickFreeShippingCheckbox(WebDriver driver) {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(freeShippingOption));
        if (element.isEnabled()) {
            element.click();
        }
    }


    @FindBy(css="#listingUl .columnContent .pro")
    private List<WebElement> resultItemsList;

    @FindBy(css="#listingUl .columnContent .pro .cargoCampaign")
    private List<WebElement> resultItemsListWithFreeShipping;

    public boolean isEveryListedItemShippingFree() {
        int totalItemCount = resultItemsList.size();
        int freeShippingItemCount = resultItemsListWithFreeShipping.size();

        return totalItemCount == freeShippingItemCount;
    }


    @FindBy(css = "#breadCrumb a:nth-child(2) span")
    private WebElement storeNameText;
    public String getStoreNameTextLowercase() {
        return storeNameText.getText().toLowerCase();
    }







    public SearchItemsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


}
