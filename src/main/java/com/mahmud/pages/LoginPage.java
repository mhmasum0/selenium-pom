package com.mahmud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//li[@list-select]")
    private List<WebElement> languages;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void visitLoginPage(String websiteURL){
        visitPage(websiteURL);
    }

    public void enterUsername(String username){
        sendKeys(userNameInput, username);

    }

    public void enterPassword(String password){
        sendKeys(passwordInput, password);
    }

    public void clickOnSubmitButton(){
        click(loginButton);
    }





}
