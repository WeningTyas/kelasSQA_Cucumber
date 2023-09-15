package com.juaracoding;

import com.juaracoding.Utils.Constants;
import com.juaracoding.Utils.TestCases;
import com.juaracoding.Utils.Utils;
import com.juaracoding.drivers.DriverSingleton;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Hooks {

    static WebDriver driver; // ← pakai static
    static ExtentTest extentTest; // File test nanti akan tergenerate di folder ini ↓
    static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public void setUp(){
        //.... Berisi setting awal
        // ↑ ini dieksekusi di setiap test case dimulai
        DriverSingleton.getInstance(Constants.BROWSER);
        driver = DriverSingleton.getDriver();
        TestCases[] test = TestCases.values();
        extentTest = reports.startTest(test[Utils.testCount].getTestCasesName());
        Utils.testCount++;
    }

    //Ini bagian screenshot
    @AfterStep
    public void getResultStatus(Scenario scenario) throws IOException {
        //.... Berisi hasil screenshoot setelah selesai melakukan testing
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver, scenario.getName());
            extentTest.log(LogStatus.FAIL, scenario.getName() + "\n"
                        + extentTest.addScreenCapture(screenshotPath));
        }
    }
    // Kelebihan cucumber daripada testNG karena disini ada method utk eksekusi
    // di setiap step testing dgn menggunakan AfterStep

    @AfterStep
    public void endTestCase(){
        // .... Hasil eksekusi setiap skenario
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void finish(){ // ← pakai static
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    // ↓ Fungsi delay & scroll bisa ditambah di sini
    public static void delay(long detik){
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public static void scrollBy(int x, int y) {
        // (0,500) ke bawah; (0,-500) ke atas;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = String.format("window.scrollBy(%d, %d);", x, y);
        jse.executeScript(script);
    }
    public static void KeyboardAction(WebElement element, String action, int count) {
        for (int i = 0; i < count; i++) {
            switch (action.toUpperCase()) {
                case "ENTER":
                    element.sendKeys(Keys.ENTER);
                    break;
                case "ARROW_DOWN":
                    element.sendKeys(Keys.ARROW_DOWN);
                    break;
                default:
                    throw new IllegalArgumentException("Tindakan keyboard tidak valid: " + action);
            }
        }

    }
}
