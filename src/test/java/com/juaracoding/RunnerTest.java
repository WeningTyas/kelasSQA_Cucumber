package com.juaracoding;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                    // klik kanan, copy relative path, tambahkan "src/main/resources/"
                    "src/main/resources/features/Login.feature"
                    },
                    // ↑ feature akan dijalankan berdasarkan alfabetis

        //klo features ada > 2 dipisahkan pakai koma (,)
        glue = "com.juaracoding", // ← nama package di project ini
        plugin = {"pretty", "html:target/cucumber-report.html",
                            "json:target/cucumber.json"}
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}


/*KALAU MAU RUN BUKA FILE INI!*/


/*Kalau mau lihat file hasil SSnya:
* - di folder target
* - buka extent report
* - klik kanan > Show in Explorer
* - klik 2x file yg dimaksud*/
