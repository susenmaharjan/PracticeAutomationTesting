package com.practice.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonHomepage {
    private WebDriver _webDriver;

    @FindBy(xpath = "//a[@href='http://practice.automationtesting.in']")
    WebElement homeLabel;


    @FindBy(xpath = "//a[@href='http://practice.automationtesting.in/shop/']")
    WebElement shopLabel;

    public CommonHomepage(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public void ClickHome(){
        homeLabel.click();
    }

    public void ClickShopMenu() {
        shopLabel.click();
    }
}
