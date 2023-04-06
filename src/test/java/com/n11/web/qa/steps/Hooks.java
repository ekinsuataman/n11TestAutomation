package com.n11.web.qa.steps;

import com.n11.web.qa.util.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;

import static com.n11.web.qa.webdriver.WebDriverFactory.getInstance;


public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void openBrowser() {
        System.out.println("Opening browser");
        webDriver = getInstance(BrowserType.CHROME);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void tearDown(Scenario scenario){
        File file;
        if (scenario.isFailed()) {
            String screenshotPath = System.getProperty("user.dir") + "\\target\\screenshots\\" + scenario.getName() + "\\";
            file = new File(screenshotPath);
            file.mkdir();
            try {
                final File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(screenshotPath + "screenshot.png"));

            } catch (final Exception e) {
                e.printStackTrace();
            }
            String failedScreenShot = screenshotPath + "screenshot.png";
            String url = "<img src=" + failedScreenShot + " alt='failed screenshot'>";
            scenario.embed(url.getBytes(), "png", "Click Here To See Screenshot");
        }
        webDriver.quit();

    }
}
