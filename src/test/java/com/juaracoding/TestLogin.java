package com.juaracoding;

import com.juaracoding.Pages.LoginPage;
import com.juaracoding.Utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {

    static WebDriver driver;
    static ExtentTest extentTest;
    static LoginPage loginPage = new LoginPage();
        // ↑ biasanya yg bentuk bgini hanya bisa dipanggil di methode
        //   bukan di instance dalam class, triknya adalah dengan
        //   menggunakan Hooks dan nanti dipanggil di construtor

    //  ↓ begini contructornya
    // Kalau mau test feature yg lain, bagian ini di copas aja
    // dan features di RunnerTest juga harus di sesuaikan
    public TestLogin(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    //// Mulai panggil anotasi tesnya yg dipakai satu persatu sesuai test stepnya
    @Given("User enter url HRM")
    public void user_enter_url_hrm(){ // ← nama method bisa disamakan saja dgn featurenya, klo enggak jg gpp si
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"User enter url HRM");
    }
    @When("User enter valid username") // ← yg penting ini harus sama dgn yg ada difeature, dia case sensitif
    public void user_enter_valid_username(){
        loginPage.enterUsername(Constants.USERNAME);
        extentTest.log(LogStatus.PASS,"User enter valid username");
    }
    @And("User enter valid password")
    public void user_enter_valid_password(){
        loginPage.enterPassword(Constants.PASSWORD);
        extentTest.log(LogStatus.PASS,"User enter valid password");
    }
    @When("User enter invalid username")
    public void user_enter_invalid_username(){
        loginPage.enterUsername("Adminn");
        extentTest.log(LogStatus.PASS,"User enter invalid username");
    }
    @And("User enter invalid password")
    public void user_enter_invalid_password(){
        loginPage.enterPassword("admin1234");
        extentTest.log(LogStatus.PASS,"User enter invalid password");
    }
    @And("User click button login")
    public void user_click_button_login(){
        loginPage.clickBtnLogin();
        extentTest.log(LogStatus.PASS,"User click button login");
    }
    @Then("User get test title page dashboard")
    public void user_get_test_title_page_dashboard(){
        Assert.assertEquals(loginPage.getTextDashboard(), "Dashboard");
        extentTest.log(LogStatus.PASS,"User get test title page dashboard");
        //Langsung di logout aja
        loginPage.clickLogout();
    }
    @Then("User get message invalid credentials")
    public void user_get_message_invalid_credentials(){
        // ini sengaja dierrorkan utk test Screenshoot, coba cek RunnerTest.java cara lihatnya
        //Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Invalid credensial");

        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Invalid credentials");
        extentTest.log(LogStatus.PASS, "User get message invalid credentials");
        //habis tuh refresh
        loginPage.refresh();
    }
    @Then("User get message usename required")
    public void user_get_message_username_required(){
        Assert.assertEquals(loginPage.getTxtRequiredUname(), "Required");
        extentTest.log(LogStatus.PASS, "User get message required username");
        //habis tuh refresh
        loginPage.refresh();
    }
    @Then("User get message password required")
    public void user_get_message_password_required(){
        Assert.assertEquals(loginPage.getTxtRequiredPassword(), "Required");
        extentTest.log(LogStatus.PASS, "User get message required password");
        //habis tuh refresh
        loginPage.refresh();
    }
}
