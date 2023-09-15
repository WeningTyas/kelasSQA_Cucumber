package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {
    //3. tambah "implement"
    //4. tulis "set", lalu enter

    @Override
    public WebDriver setStrategy() { //5. Tambah path chromeDrivernya
        String path = "E:\\Bootcam\\App\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions(); // ← ini setting chrome

        // ↓ ini untuk extensi chrome, mau pake atau gak?
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        
        return new ChromeDriver(options);
    }
}
