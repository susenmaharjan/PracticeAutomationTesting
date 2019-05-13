package com.practice.tests;

import com.practice.bal.homepage.HomepageWithThreeSliders;
import com.practice.common.CommonHomepage;
import com.practice.environment.EnvironmentManager;
import com.practice.environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageWithThreeSlidersTest {

    private static WebDriver _webDriver;
    private static HomepageWithThreeSliders _homePage;
    private static CommonHomepage _common;

    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://practice.automationtesting.in/");
        _webDriver = RunEnvironment.GetWebDriver();
        _homePage = PageFactory.initElements(_webDriver, HomepageWithThreeSliders.class);
        _common = PageFactory.initElements(_webDriver, CommonHomepage.class);
    }

    @AfterAll
    public static void TearUp() {
        EnvironmentManager.ShutDownDriver();
    }

    @AfterEach
    public void WaitDriver() {
        RunEnvironment.WaitDriver(2000);
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
    public void CheckIfHomepageHasThreeSliders() {
        boolean hasThreeSliders = _homePage.IfHomePageHasThreeSliders();

        assertEquals(true, hasThreeSliders);
    }
}
