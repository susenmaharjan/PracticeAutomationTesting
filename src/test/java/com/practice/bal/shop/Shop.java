package com.practice.bal.shop;

import com.practice.environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Shop {
    private WebDriver _webDriver;

    public Shop(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@href='http://practice.automationtesting.in/product/learning-javascript-data-structures-and-algorithm/']")
    WebElement DSAProduct;

    public void FilterByPrice() {
        int offsetValue = 1;
        int temp;

        WebElement rightSlider = _webDriver.findElements(By.cssSelector(".ui-slider-handle")).get(1);

        do {
            WebElement toPrice = _webDriver.findElement(By.className("to"));
            String price = toPrice.getText().replace("₹", "");
            System.out.println(price);

            temp = Integer.parseInt(price);
            System.out.println(temp);
            System.out.println(offsetValue);
            {
                Actions builder = new Actions(_webDriver);
                builder.moveToElement(rightSlider).clickAndHold().perform();
            }
            {
                Actions builder = new Actions(_webDriver);
                builder.moveToElement(rightSlider, 0, offsetValue).perform();
            }
            {
                Actions builder = new Actions(_webDriver);
                builder.moveToElement(rightSlider).release().perform();
            }
            rightSlider.click();
            offsetValue++;
            System.out.println();

        } while (!(temp > 440 && temp < 460));

        //filter
        _webDriver.findElement(By.xpath("//div[@class='price_slider_amount']/button")).click();
        RunEnvironment.WaitDriver(5000);
    }

    public void SelectProduct() {
        DSAProduct.click();
    }

    public void SortProduct() {
        Select products = new Select(_webDriver.findElement(By.name("orderby")));

        products.selectByValue("popularity");
    }

    public void ReadMore() {
        _webDriver.findElement(By.linkText("READ MORE")).click();
    }

    public void SelectOnSale() {
        _webDriver.findElement(By.className("onsale")).click();
    }
}
