package com.n11.web.qa.pages.SearchStoresPage;

import com.n11.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


@Getter
public class SearchStoresPage extends BasePage {

    public static WebElement randomStore;

    @FindBy(css = "ul li:nth-child(4) h3")
    private WebElement SearchStoresBtn;

    @FindBy(css = "div.letters span[title='S']")
    private WebElement LetterBtn;

    @FindBy(css = ".sellerListHolder ul li")
    private List<WebElement> sellerList;

    public WebElement getRandomSeller() {
        if (sellerList.isEmpty()) {
            throw new IllegalStateException("Seller list is empty");
        }
        Random random = new Random();
        randomStore = sellerList.get(random.nextInt(sellerList.size()));
        return randomStore;
    }

    public static boolean checkSellerText(String parameterText) {
        String randomSellerName = randomStore.getText().toLowerCase();
        return parameterText.equals(randomSellerName);
    }


    public SearchStoresPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


}
