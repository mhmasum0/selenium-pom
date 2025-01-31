package com.mahmud.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertBoxHomePage extends BasePage{

    By alertBoxButton = By.xpath("//button[contains(text(),'alert box:')]");

    public AlertBoxHomePage(WebDriver driver){
        super(driver);
    }

    public void visitAlertBoxHomePage(String url){
        visitPage(url);

    }

    public void clickOnAlertBoxButton(){
        WebElement alertBoxButtonElement = driver.findElement(alertBoxButton);
        click(alertBoxButtonElement);
    }

    public String getAlertBoxData(){
        return getAlertBoxText();
    }

    public void acceptHomePageAlertBox(){
        acceptAlertBox();
    }

}
