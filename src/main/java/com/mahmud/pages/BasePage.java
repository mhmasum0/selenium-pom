package com.mahmud.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class BasePage {
    protected WebDriver driver;

    public BasePage( WebDriver driver){
        this.driver = driver;
    }

    public void visitPage(String url){
        driver.get(url);
        Reporter.log("Visited: " + url);
    }

    public void sendKeys(WebElement element, String input){
        element.sendKeys(input);
    }

    public void click(WebElement element){
        Reporter.log("Clicked: " + element.getText());
        element.click();

    }

    public String getAlertBoxText(){
        return driver.switchTo().alert().getText();
    }

    public void acceptAlertBox(){
        driver.switchTo().alert().accept();
    }

    public void selectElementByText(WebElement selectElement, String selectOption){
        Select objSelect =new Select(selectElement);
        objSelect.selectByVisibleText(selectOption);
    }

    public void selectElementByIndex(WebElement selectElement, int index){
        Select objSelect =new Select(selectElement);
        objSelect.selectByIndex(index);
    }
}
