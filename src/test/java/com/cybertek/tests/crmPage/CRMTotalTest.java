package com.cybertek.tests.crmPage;

import com.cybertek.pages.CRMpage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMTotalTest extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigReader.get("url"));
        LoginPage loginPage = new LoginPage(ConfigReader.get("mgr_username"), ConfigReader.get("mgr_password"));
        CRMpage crmPage = new CRMpage();
        crmPage.goToModule("CRM");
    }

    @Test
    public void precondition(){

    }

}
