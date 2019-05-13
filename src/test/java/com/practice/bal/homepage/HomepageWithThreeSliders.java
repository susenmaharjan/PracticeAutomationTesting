package com.practice.bal.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomepageWithThreeSliders {
    private WebDriver _webDriver;

    public HomepageWithThreeSliders(WebDriver webDriver) {
        this._webDriver = webDriver;
    }

    @FindBy(className = "n2-ss-slider-3")
    WebElement sliderElement;

    public boolean IfHomePageHasThreeSliders() {
        List<WebElement> sliders = sliderElement.findElements(By.tagName("img"));

        if (sliders.size() == 3)
            return true;
        return false;
    }
}
