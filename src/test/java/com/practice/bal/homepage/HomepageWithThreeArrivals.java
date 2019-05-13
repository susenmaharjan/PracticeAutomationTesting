package com.practice.bal.homepage;

import com.practice.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomepageWithThreeArrivals {
    private WebDriver _webDriver;

    public HomepageWithThreeArrivals(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    @FindBys(@FindBy(className = "woocommerce-LoopProduct-link"))
    List<WebElement> arrivals;

    public boolean CheckIfThreeArrivals() {

        if (arrivals.size() == 3) {
            return true;
        }
        return false;
    }

    public boolean ClickImageAndAddToBasket() {
        arrivals.get(0).click();

        //check if add to basket exist
        WebElement addToBasket = Common.FindElementSafe(_webDriver, By.className("single_add_to_cart_button"));

        if (addToBasket != null) {
            System.out.println(_webDriver.getCurrentUrl());
            return true;
        }
        return false;
    }
}