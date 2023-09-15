package com.juaracoding.Pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPages {
    private WebDriver driver;

    //Penempatan Locator
    // @FindBy

    // Custom methode bisa ditulis di bagian ini
    // terkhusus yg berkaitan dgn halaman yg dimaksud
    public DashboardPages(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
}
