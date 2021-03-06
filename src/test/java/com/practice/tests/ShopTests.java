package com.practice.tests;

import com.practice.bal.shop.Shop;
import com.practice.environment.EnvironmentManager;
import com.practice.environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShopTests {
    private static WebDriver _webDriver;
    private static Shop _shop;

    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://practice.automationtesting.in/shop/");
        _webDriver = RunEnvironment.GetWebDriver();
        _shop = PageFactory.initElements(_webDriver, Shop.class);
    }

    @AfterAll
    public static void TearDown() {
        EnvironmentManager.ShutDownDriver();
    }

    @AfterEach
    public void WaitDriver() {
        RunEnvironment.WaitDriver(2000);
    }

    @Test
    @Order(1)
    public void FilterByPrice() {
        _shop.FilterByPrice();
    }

    @Test
    @Order(2)
    public void SelectProduct() {
        _shop.SelectProduct();
        RunEnvironment.WaitAndNavigateBack();
    }

    @Test
    @Order(3)
    public void SortingProducts() {
        _shop.SortProduct();
    }

    @Test
    @Order(4)
    public void ReadMore() {
        _shop.ReadMore();
        RunEnvironment.WaitAndNavigateBack();
    }

    @Test
    @Order(5)
    public void SelectOnSale(){
        _shop.SelectOnSale();
        RunEnvironment.WaitAndNavigateBack();
    }
}
