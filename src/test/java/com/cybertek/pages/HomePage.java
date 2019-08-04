package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signin;

    public void signToLoginPage(){
        signin.click();
    }

}
