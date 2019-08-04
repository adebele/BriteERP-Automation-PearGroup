package com.cybertek.tests.crmPage;

import com.cybertek.pages.CRMpage;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BriteERPCRM2 extends CRMmoduleTest{

List<String> oppList = new ArrayList<>();
List<String> headerList = new ArrayList<>();


    @Test
    public void precondition() {

        CRMpage crMpage = new CRMpage();

        BrowserUtils.waitFor(2);
        crMpage.createOpportunity("Book", "240.00", 1);

        BrowserUtils.waitFor(2);
        crMpage.createOpportunity("Book2", "300.00", 2);

        BrowserUtils.waitFor(2);
        crMpage.createOpportunity("Book3", "350.00", 3);


//        BrowserUtils.waitFor(2);
//        ((JavascriptExecutor)driver).executeScript("argument[0].click;",crMpage.listBtn);
    }

    @Test
            public void precondition2(){
        CRMpage crMpage = new CRMpage();
       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        crMpage.listBtn.click();
        oppList = BrowserUtils.getElementsText(driver.findElements(By.xpath("//table//tbody/tr/td[3]")));
        headerList = BrowserUtils.getElementsText(driver.findElements(By.xpath("//table//thead//th")));
        System.out.println(oppList);
        System.out.println(headerList);
        int idxRow = getColumnIndex(oppList, "Book");
        int idxColumn = getColumnIndex(headerList, "Expected Revenue");
        System.out.println("row:"+idxRow+" col:"+idxColumn);

        String list = driver.findElement(By.xpath("//table/tbody/tr[" + idxRow + "]/td[" + (idxColumn+1) + "]")).getText();
        System.out.println(list);
        double listView = Double.parseDouble(list);

        driver.findElement(By.xpath("//button[@data-view-type='pivot']")).click();

        driver.findElement(By.xpath("//th[@class='o_pivot_header_cell_closed hidden-xs']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Opportunity')]")).click();

        BrowserUtils.waitFor(10);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    private int getColumnIndex(List<String> cols, String col) {

        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i).equals(col)) {
                return i + 1;
            }
        }
        return 0;
    }
}
