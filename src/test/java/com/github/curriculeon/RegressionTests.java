package com.github.curriculeon;

import com.github.curriculeon.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
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

        //Finding and clicking the name field
        WebElement nameField = driver.findElement(By.cssSelector("input[data-qa*='signup-name']"));

        //Generate the name with only 1 character to test
        String name = RandomStringUtils.randomAlphabetic(1);

        //Insert one character into name
        nameField.sendKeys(name);

        //Find Signup_email field
        WebElement signupEmailField = driver.findElement(By.cssSelector("input[data-qa*='signup-email']"));

        //Generate email
        String email = RandomStringUtils.randomAlphanumeric(8) + "@TestEmail.com";

        //Enter email into signupEmailField
        signupEmailField.sendKeys(email);

        //Find and click signup button
        driver.findElement(By.cssSelector("button[data-qa*='signup']")).click();

        // Test for URL locations
        String actual_signUpPage = driver.getCurrentUrl();
        String expected_signUpPage = "https://automationexercise.com/signup";
        Assert.assertEquals(expected, actual_url);

        //Select title(Mr. or Mrs.)
        driver.findElement(By.cssSelector("input[value*='Mr']")).click();

        //Find and click passwordField
        WebElement passwordField = driver.findElement(By.cssSelector("input[data-qa*='password']"));

        //Generate password
        String password = RandomStringUtils.randomAlphanumeric(10);

        //Enter credentials into password field
        passwordField.sendKeys(password);

        //Click Day drop down
        WebElement daysDropDown = driver.findElement(By.cssSelector("select[data-qa*='days']"));

        //Pick day
        daysDropDown.sendKeys("31");

        //Select month drop down
        WebElement monthDropDown = driver.findElement(By.cssSelector("select[data-qa*='months']"));

        //Pick month
        monthDropDown.sendKeys("de");

        // Select year drop down
        WebElement yearDropDown = driver.findElement(By.cssSelector("select[data-qa*='years']"));

        //Enter year and select year
        yearDropDown.sendKeys("1990");

        // Select "Sign up for our newsleter!" box
        driver.findElement(By.cssSelector("input[name*='newsletter']")).click();

        //Select "Receive special offers from our partners!"
        driver.findElement(By.cssSelector("input[name*='optin']")).click();

        WebElement firstNameField = driver.findElement(By.cssSelector("input[data-qa*='first_name']"));

        firstNameField.sendKeys("DeanDre");

        WebElement lastNameField = driver.findElement(By.cssSelector("input[data-qa*='last_name']"));

        lastNameField.sendKeys("WallsDavis");

        WebElement companyField = driver.findElement(By.cssSelector("input[data-qa*='company']"));

        companyField.sendKeys("123456");

        WebElement addressField = driver.findElement(By.cssSelector("input[data-qa*='address']"));

        addressField.sendKeys("SomeAddressWithNoRdOrAveOrNumbers");

        WebElement address2Field = driver.findElement(By.cssSelector("input[data-qa*='address2']"));

        address2Field.sendKeys("SomeOtherAddressWithNoNumbers");

        WebElement countryDropDown = driver.findElement(By.cssSelector("select[data-qa*='country']"));

        countryDropDown.sendKeys("un");

        WebElement stateField = driver.findElement(By.cssSelector("input[data-qa*='state']"));

        stateField.sendKeys("DelawareMaryland");

        WebElement cityField = driver.findElement(By.cssSelector("input[data-qa*='city']"));

        cityField.sendKeys("12345678");

        WebElement zipcodeField = driver.findElement(By.cssSelector("input[data-qa*='zipcode']"));

        zipcodeField.sendKeys("notAZipCode");

        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[data-qa*='mobile_number']"));

        mobileNumberField.sendKeys("NotNumbers");

        // Create a JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by a specific number of pixels (e.g., 500 pixels)
        js.executeScript("window.scrollBy(0, 500)");

        //Find and click create account
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        // click continue
        driver.findElement(By.cssSelector("a[href*='/']")).click();
    } // END TEST

}
