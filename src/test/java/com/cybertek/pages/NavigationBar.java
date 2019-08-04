package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class NavigationBar {

    public void goToModule(String module) {
        String xpath = "//span[@class='oe_menu_text'][contains(text(),'" + module + "')][1]";
        Driver.get().findElement(By.xpath(xpath)).click();
    }
}
