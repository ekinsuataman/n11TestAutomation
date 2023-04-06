package com.n11.web.qa.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    private WebDriver webDriver;
    public BaseSteps() {
        webDriver = Hooks.webDriver;
    }

    @Given("user navigate to n11.com stores homepage")
    public void userNavigateToN11StoresHomepage() throws InterruptedException {
        System.out.println("User navigate to n11.com/stores homepage");
        String url = "https://www.n11.com/magazalar";
        webDriver.get(url);
        Thread.sleep(2000);
    }

    @Given("user navigate to n11.com homepage")
    public void userNavigateToN11Homepage() throws InterruptedException {
        System.out.println("User navigate to n11.com/ homepage");
        String url = "https://www.n11.com/";
        webDriver.get(url);
        Thread.sleep(4000);
    }
}
