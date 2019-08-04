package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public LoginPage(String username, String password) {
        this();
        login(username, password);
    }

    @FindBy(css = "input[id='login']")
    public WebElement username;


    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement loginBtn;

    public void login(String username, String password) {
        HomePage homePage = new HomePage();
        homePage.signToLoginPage();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
    }
}
