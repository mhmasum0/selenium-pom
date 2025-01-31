package com.mahmud;

import com.mahmud.pages.LoginPage;
import com.mahmud.utils.DataFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "login-data")
    public void testLogin(String username, String password){

        LoginPage loginPage = new LoginPage( driver );

        loginPage.visitLoginPage("https://www.saucedemo.com/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnSubmitButton();
    }

    @DataProvider(name = "login-data")
    public Object[][] loginData() throws IOException {
        Object[][] data = DataFromExcel.getDataFromExcel("all-users-credentials.xlsx", "Sheet1", 2);
        return data;
    }
}
