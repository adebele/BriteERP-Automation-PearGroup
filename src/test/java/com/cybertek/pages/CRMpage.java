package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRMpage extends NavigationBar {

    public CRMpage() { PageFactory.initElements(Driver.get(), this);  }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new']")
    public WebElement createBtn;

    @FindBy(css = "button[class='btn btn-sm btn-default o_button_import']")
    public WebElement importBtn;

    @FindBy(css = "button[class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public WebElement listBtn;

    @FindBy(css = "button[class='btn btn-icon fa fa-lg fa-th-large o_cp_switch_kanban active']")
    public WebElement kanbanBtn;

    @FindBy(css = "button[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")
    public WebElement pivotBtn;

    @FindBy(xpath = "//input[contains(@name,'name')]")
    public WebElement name;

    @FindBy(xpath = "//input[contains(@name,'planned_revenue')]")
    public WebElement plannedRev;

    @FindBy(xpath = "//span[.='Create']")
    public WebElement createSubmit;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionBtn;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteBtn;

    @FindBy(css = "button[class='btn btn-sm btn-primary']")
    public WebElement okDelBtn;

    public void sendTxtPlannedRvn(String s) {
        plannedRev.clear();
        plannedRev.sendKeys(s);
    }

    public void setPriority(int n) {
        Driver.get().findElement(By.xpath("//table[contains(@class,'o_group o_inner_group o_group_col_')]//a[" + n + "]")).click();
    }


    public List<WebElement> tablehdrListView() {
        listBtn.click();
        List<WebElement> tableheader = Driver.get().findElements(By.xpath("//thead//th"));
        return tableheader;
    }

    public void selectOpportunity(String oppo){
        String xpath = "//td[@class='o_data_cell o_required_modifier'][.='"+oppo+"']/..//input[@type='checkbox']";
        Driver.get().findElement(By.xpath(xpath)).click();
    }





    public void createOpportunity(String name, String rev, int star){
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        createBtn.click();
        this.name.sendKeys(name);
        plannedRev.clear();
        plannedRev.sendKeys(rev);
        Driver.get().findElement(By.xpath("//table[contains(@class,'o_group o_inner_group o_group_col_')]//a["+star+"]")).click();
        createSubmit.click();

    }


}
