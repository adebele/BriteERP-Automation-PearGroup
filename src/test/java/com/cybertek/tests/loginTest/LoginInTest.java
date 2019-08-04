package com.cybertek.tests.loginTest;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginInTest extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigReader.get("url"));
    }

    @Test
    public void loginMGR(){
        String username = ConfigReader.get("mgr_username");
        String password = ConfigReader.get("mgr_password");

        LoginPage loginPage = new LoginPage(username,password);

        Assert.assertTrue(driver.getTitle().contains("#Inbox - Odoo"));
    }
}
