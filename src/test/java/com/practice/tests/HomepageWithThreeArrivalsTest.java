package com.practice.tests;

import com.practice.bal.homepage.HomepageWithThreeArrivalsNavigation;
import com.practice.common.CommonHomepage;
import com.practice.environment.EnvironmentManager;
import com.practice.environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomepageWithThreeArrivalsTest {
    private static WebDriver _webDriver;
    private static HomepageWithThreeArrivalsNavigation _homePage;
    private static CommonHomepage _common;

    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://practice.automationtesting.in/");
        _webDriver = RunEnvironment.GetWebDriver();
        _homePage = PageFactory.initElements(_webDriver, HomepageWithThreeArrivalsNavigation.class);
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
        boolean isSuccessful = _homePage.ClickImageAndAddToBasket();
        assertEquals(true, isSuccessful);
    }

    @Test
    @Order(5)
    public void CheckDescription() {
        boolean success = _homePage.CheckDescription();
        assertEquals(true, success);
    }

    @Test
    @Order(6)
    public void CheckReviews() {
        boolean isSuccessful = _homePage.CheckReviews();
        assertEquals(true, isSuccessful);
    }

    @Test
    @Order(7)
    public void AddToBasket() {
        boolean isSuccessful= _homePage.AddToBasket();
        assertEquals(true,isSuccessful);
    }

    @Test
    @Order(8)
    public void AddMoreToBasket(){
        _homePage.AddMoreToBasket();
    }

    @Test
    @Order(9)
    public void ViewBasket(){
        _homePage.ViewBasket();
    }
}
