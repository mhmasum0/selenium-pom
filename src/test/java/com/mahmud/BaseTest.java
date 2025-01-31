package com.mahmud;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    ExtentReports extentReports = new ExtentReports();

    @BeforeMethod
    public void setup() {
        // Extent report initialization
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("test-report/extent-report.html");
        extentReports.attachReporter(extentSparkReporter);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        extentReports.flush();
        driver.quit();
    }

}
