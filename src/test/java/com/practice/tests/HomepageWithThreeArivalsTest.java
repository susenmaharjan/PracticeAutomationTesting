package com.practice.tests;

import com.practice.bal.homepage.HomepageWithThreeArrivals;
import com.practice.common.CommonHomepage;
import com.practice.environment.EnvironmentManager;
import com.practice.environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class HomepageWithThreeArivalsTest {
    private static WebDriver _webDriver;
    private static HomepageWithThreeArrivals _homePage;
    private static CommonHomepage _common;

    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://practice.automationtesting.in/");
        _webDriver = RunEnvironment.GetWebDriver();
        _homePage = PageFactory.initElements(_webDriver, HomepageWithThreeArrivals.class);
        _common = PageFactory.initElements(_webDriver, CommonHomepage.class);
    }

    @AfterEach
    public void WaitDriver() {
        RunEnvironment.WaitDriver(2000);
    }

    @AfterAll
    public static void TearUp() {
        EnvironmentManager.ShutDownDriver();
    }

    @Test
    @Order(1)
    public void ClickShopMenu() {
        _common.ClickShopMenu();
    }

    @Test
    @Order(2)
    public void ClickHome() {
        _common.ClickHome();
    }

    @Test
    @Order(3)
    public void CheckIfThreeArrivals() {
        boolean arrivalsSize = _homePage.CheckIfThreeArrivals();
        assertEquals(true, arrivalsSize);
    }

    @Test
    @Order(4)
    public void ClickImageAndAddToBasket() {
        boolean isSuccessfull = _homePage.ClickImageAndAddToBasket();
        assertEquals(true, isSuccessfull);
    }

}