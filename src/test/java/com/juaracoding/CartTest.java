package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest {

    private WebDriver driver;

    private LoginPage loginPage;

    private HomePage homePage;

    private CartPage cartPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testAddProductToCart(){
        // Precondition
        loginPage.login("standard_user", "secret_sauce");
        // Steps - Assert
        homePage.setAddBtnToCart();
        Assert.assertEquals(homePage.getTxtRemoveFromCart(), "Remove");
        Assert.assertEquals(homePage.getTxtCartBadge(), "1");
        homePage.setCartBtn();
        Assert.assertEquals(cartPage.getTxtItemName(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

}
