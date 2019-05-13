package com.practice.bal.homepage;

import com.practice.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomepageWithThreeArrivalsNavigation {
    private WebDriver _webDriver;

    public HomepageWithThreeArrivalsNavigation(WebDriver webDriver) {
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

    public boolean CheckDescription() {
        _webDriver.findElement(By.className("description_tab")).click();

        WebElement description = Common.FindElementSafe(_webDriver, By.id("tab-description"));

        if (description != null) {
            System.out.println(description.getText());
            return true;
        }
        return false;
    }

    public boolean CheckReviews() {
        _webDriver.findElement(By.className("reviews_tab")).click();

        WebElement reviews = Common.FindElementSafe(_webDriver,By.id("reviews"));

        if(reviews!=null){
            System.out.println(reviews.getText());
            return true;
        }
        return false;
    }

    public boolean AddToBasket() {
        _webDriver.findElement(By.className("single_add_to_cart_button ")).click();
        WebElement price = Common.FindElementSafe(_webDriver,By.className("woocommerce-Price-amount"));

        if(price!=null){
            System.out.println(price.getText());
            return true;
        }
        return false;
    }
}
