package com.github.curriculeon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.test.context.web.WebAppConfiguration;


import java.sql.DriverManager;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DemoApplicationTests {

    @Test
    public void test_sign_up() {
        // Use WebDriverManager to manage ChromeDriver
        WebDriverManager.firefoxdriver().setup();

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the web page
        driver.get("https://automationexercise.com/");

        // Click on Signup/Login Button
        driver.findElement(By.cssSelector("a[href*='/login']")).click();

            // Test for URL locations
            String actual_url = driver.getCurrentUrl();
            String expected = "https://automationexercise.com/login";
            Assert.assertEquals(expected, actual_url);

        //Make driver click the name field
        WebElement nameField = driver.findElement(By.cssSelector("input[data-qa*='signup-name']"));

        //Generate random name
        String randomName = RandomStringUtils.randomAlphabetic(10, 10).toLowerCase();

        //Send random name
        nameField.sendKeys(randomName);

        //Make driver click Email Address field
        WebElement emailField = driver.findElement(By.cssSelector("input[data-qa*='signup-email']"));

        //Make driver enter email criteria
        emailField.sendKeys(randomName + "@TestEmail.com");

        //Make driver click Signup button
        driver.findElement(By.cssSelector("button[data-qa*='signup-button']")).click();

            // click the sign up for news letter checkbox
//            driver.findElement(By.id("newsletter"));

            // Close the WebDriver
//            driver.quit();
    } // End of Test
} // End of Class
