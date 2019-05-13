package com.practice.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
    public static WebElement FindElementSafe(WebDriver webDriver, By by) {
        try {
            return webDriver.findElement(by);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
