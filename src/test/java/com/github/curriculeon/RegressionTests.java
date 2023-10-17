package com.github.curriculeon;

import com.github.curriculeon.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RegressionTests {

    @Test
    public void regressionTestSetUp(){
        // Use WebDriverManager to manage ChromeDriver
        WebDriverManager.firefoxdriver().setup();

        // Initialize the WebDriver
        final WebDriver driver = new FirefoxDriver();

        // Navigate to the web page
        driver.get("https://automationexercise.com/");

        // Instantiating SignUpPage
        final LandingPage signUpPage = new LandingPage(driver);

        //Find and click the Sign/login page
        signUpPage.clickSignUpLink();

        // Test for URL locations
        String actual_url = driver.getCurrentUrl();
        String expected = "https://automationexercise.com/login";
        Assert.assertEquals(expected, actual_url);

    } // END TEST

}
