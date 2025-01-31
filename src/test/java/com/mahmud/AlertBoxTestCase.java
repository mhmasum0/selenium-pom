package com.mahmud;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mahmud.pages.AlertBoxHomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AlertBoxTestCase extends BaseTest {

    @Test
    public void alertBoxTest() throws InterruptedException, IOException {

        ExtentTest alertBoxTest = extentReports.createTest("alertBoxTest");

        AlertBoxHomePage alertBoxHomePage = new AlertBoxHomePage(driver);


        alertBoxHomePage.visitAlertBoxHomePage("https://demo.automationtesting.in/Alerts.html");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Screenshots/screenshot.png");
        FileUtils.copyFile(source, dest);

        alertBoxTest.addScreenCaptureFromPath( dest.getAbsolutePath() );


        alertBoxTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());



        Reporter.log("Visited: https://demo.automationtesting.in/Alerts.html" );
        alertBoxTest.log(Status.PASS, "Visited: https://demo.automationtesting.in/Alerts.html");


        Thread.sleep(2000);
        alertBoxHomePage.clickOnAlertBoxButton();
        Thread.sleep(3000);

        String alertMessage = alertBoxHomePage.getAlertBoxData();
        System.out.println(alertMessage);

        alertBoxHomePage.acceptHomePageAlertBox();
        Thread.sleep(3000);

    }

    @Test
    public void failedTest(){
        ExtentTest failedTest = extentReports.createTest("Failed test");

        failedTest.log(Status.INFO, "It's failed test method");
        Assert.assertTrue(1==1,"Failed");
    }
}
