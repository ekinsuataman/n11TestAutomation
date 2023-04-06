package com.n11.web.qa.webdriver;

import com.n11.web.qa.util.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverFactory {

    private WebDriverFactory() {

    }

    public static WebDriver getInstance(BrowserType browser) {
        WebDriver webDriver;

        switch (browser) {
            default:
            case CHROME:
                webDriver = new ChromeDriver(setChromeOptions());
                break;
            case EDGE:
                webDriver = new EdgeDriver(setEdgeDriver());
                break;
        }
        return webDriver;
    }

    public static ChromeOptions setChromeOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");

        return options;
    }

    public static EdgeOptions setEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        return options;
    }


}



