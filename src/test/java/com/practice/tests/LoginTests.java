package com.practice.tests;

import com.practice.bal.account.Login;
import com.practice.environment.EnvironmentManager;
import com.practice.environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {
    private static WebDriver _webDriver;
    private static Login _login;


    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://practice.automationtesting.in/my-account/");
        _webDriver = RunEnvironment.GetWebDriver();
        _login = PageFactory.initElements(_webDriver, Login.class);
    }

    @AfterAll
    public static void TearDown() {
        RunEnvironment.WaitDriver(5000);
        EnvironmentManager.ShutDownDriver();
    }

    @AfterEach
    public void WaitDriver() {
        RunEnvironment.WaitDriver(2000);
    }

    @Test
    @Order(1)
    public void Login() {
        _login.Login("helloworld@helloworld.com", "Nepal@#123@#001");
    }

    @Test
    @Order(2)
    public void LoginWithIncorrectCredentials() {
        _login.Logout();
        RunEnvironment.WaitDriver(2000);
        _login.Login("whaat", "whaattttttttt");
    }

    @Test
    @Order(3)
    public void LoginWithValidUsernameEmptyPassword() {
        _login.Login("helloworld@helloworld.com", "");
    }

    @Test
    @Order(4)
    public void LoginWithEmptyUsernameValidPassword() {
        _login.Login("", "Nepal@#123@#001");
    }

    @Test
    @Order(5)
    public void LoginWithEmptyUsernameEmptyPassword() {
        _login.Login("", "");
    }

    @Test
    @Order(6)
    public void CaseSensitiveLogin() {
        _login.Login("HelloWorld@helloworld.com", "nePaL@#123@#001");
    }

    @Test
    @Order(7)
    public void AuthenticationTest() {
        _login.Login("helloworld@helloworld.com", "Nepal@#123@#001");
        RunEnvironment.WaitDriver(2000);

        _login.Logout();
        RunEnvironment.WaitDriver(2000);

        _webDriver.navigate().back();
    }

}
