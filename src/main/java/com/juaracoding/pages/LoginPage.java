package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // WebElement

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginBtn;

    // link register, link forgot password
    // msg error
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtError;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement attrLoginLogo;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }

    public String getTxtError(){
        return txtError.getText();
    }

    //get attribute
    public String getAttributeLoginLogo(){
        return attrLoginLogo.getAttribute("class");
    }


}
