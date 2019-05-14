package com.practice.bal.account;

import com.practice.environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
    private WebDriver _webDriver;

    public Login(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(name = "login")
    WebElement loginBtn;

    public void Login(String username, String password) {
        usernameInput.sendKeys(username);
        RunEnvironment.WaitDriver(2000);
        passwordInput.sendKeys(password);
        RunEnvironment.WaitDriver(2000);
        loginBtn.click();
    }

    public void Logout(){
        WebElement logoutBtn =  _webDriver.findElement(By.xpath("//a[@href='http://practice.automationtesting.in/my-account/customer-logout/']"));
        logoutBtn.click();
   }
}
