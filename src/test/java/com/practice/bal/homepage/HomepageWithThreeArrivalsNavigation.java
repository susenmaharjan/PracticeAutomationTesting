package com.practice.bal.homepage;

import com.practice.common.Common;
import com.practice.environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        WebElement reviews = Common.FindElementSafe(_webDriver, By.id("reviews"));

        if (reviews != null) {
            System.out.println(reviews.getText());
            return true;
        }
        return false;
    }

    public boolean AddToBasket() {
        _webDriver.findElement(By.className("single_add_to_cart_button ")).click();
        WebElement price = Common.FindElementSafe(_webDriver, By.className("woocommerce-Price-amount"));

        if (price != null) {
            System.out.println(price.getText());
            return true;
        }
        return false;
    }

    public void AddMoreToBasket() {
        WebElement inputText = _webDriver.findElement(By.className("input-text"));
        inputText.clear();
        inputText.sendKeys("700");
        WebElement addToCartBtn = _webDriver.findElement(By.className("single_add_to_cart_button "));
        addToCartBtn.click();

        RunEnvironment.WaitDriver(3000);
        inputText.clear();
        inputText.sendKeys("2");
        addToCartBtn.click();
    }

    public void ViewBasket() {
        _webDriver.findElement(By.className("wc-forward")).click();
    }

    public void ApplyCoupon(String couponCode) {
        WebElement couponCodeText = _webDriver.findElement(By.id("coupon_code"));
        couponCodeText.sendKeys(couponCode);
        _webDriver.findElement(By.name("apply_coupon")).click();
    }

    public void RemoveProduct() {
        WebElement removeBtn = _webDriver.findElement(By.xpath("//td[@class='product-remove']/a"));
        Actions actions = new Actions(_webDriver);
        actions.moveToElement(removeBtn).click();
     }

    public void FailedApplyCoupon() {
        _webDriver.findElement(By.xpath("//a[@href='http://practice.automationtesting.in/product/html5-forms/']")).click();
        RunEnvironment.WaitDriver(2000);
        _webDriver.findElement(By.xpath("//button[@type='submit'] ")).click();
        RunEnvironment.WaitDriver(2000);
        _webDriver.findElement(By.className("wc-forward")).click();
        RunEnvironment.WaitDriver(2000);
        ApplyCoupon("krishnasakinala");
    }
}
