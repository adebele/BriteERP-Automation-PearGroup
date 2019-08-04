package com.cybertek.tests.crmPage;

import com.cybertek.pages.CRMpage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class CRMmoduleTest extends TestBase {

    String newOpporunity="CRMTestData";

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigReader.get("url"));

        // GIVE NAME OF THE TEST
       //extentLogger = report.createTest("Before method: Opening method");

        //extentLogger.info("Getting user credentials");
        //extentLogger.info("Go to CRM module");

    }

    @Test
    public void createOpportunity(){
        extentLogger = report.createTest("Precondition: Manager create an Opportunity on CRM Module");

        extentLogger.info("Getting user credentials");
        LoginPage loginPage = new LoginPage(ConfigReader.get("mgr_username"), ConfigReader.get("mgr_password"));
        CRMpage crmPage = new CRMpage();

        extentLogger.info("Go to CRM module");
        crmPage.goToModule("CRM");

         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        extentLogger.info("Clicking create button");
        crmPage.createBtn.click();

        extentLogger.info("Inputting Opportunity name, Revenue and priority");
        crmPage.name.sendKeys(newOpporunity);
        crmPage.sendTxtPlannedRvn("1255.00");
        crmPage.setPriority(2);
        extentLogger.info("Clicking on Submit");
        crmPage.createSubmit.click();



    }
    @Test(priority = 1)
    public void deleteOpportunity(){
        extentLogger = report.createTest("Positive test: Verifiying if Manager is able to delete an opportunity from action drop down list");

        extentLogger.info("Getting user credentials");

        LoginPage loginPage = new LoginPage(ConfigReader.get("mgr_username"), ConfigReader.get("mgr_password"));
        CRMpage crmPage = new CRMpage();

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        extentLogger.info("Go to CRM module");
        crmPage.goToModule("CRM");


        BrowserUtils.waitForClickablility(crmPage.listBtn,5);
        extentLogger.info("Clicking the list view");
        crmPage.listBtn.click();
        extentLogger.info("Selecting an Opporunity");
        crmPage.selectOpportunity(newOpporunity);
        extentLogger.info("Clicking Action drop down list");
        crmPage.actionBtn.click();
        extentLogger.info("Clicking Delete button from drop down list");
        crmPage.deleteBtn.click();
        extentLogger.info("Clicking OK button");
        crmPage.okDelBtn.click();
        BrowserUtils.waitFor(10);
    }

    @Test (priority = 2)
    public void viewList(){
        extentLogger = report.createTest("Positive Test: Verifing if manager is able to see the list view.");

        extentLogger.info("Getting user credentials");
        LoginPage loginPage = new LoginPage(ConfigReader.get("mgr_username"), ConfigReader.get("mgr_password"));
        CRMpage crmPage = new CRMpage();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        extentLogger.info("Go to CRM module");
        crmPage.goToModule("CRM");

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        extentLogger.info("Clicking the list view");
        crmPage.listBtn.click();




        BrowserUtils.waitFor(10);


    }


}
