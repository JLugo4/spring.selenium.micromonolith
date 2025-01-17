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
public class DemoApplicationTests {

    @Test
    public void smoke_test_sign_up() {
        // Use WebDriverManager to manage ChromeDriver
        WebDriverManager.firefoxdriver().setup();

        // Initialize the WebDriver
        final WebDriver driver = new FirefoxDriver();

        // Navigate to the web page
        driver.get("https://automationexercise.com/");

        // Instantiating SignUpPage
        final LandingPage signUpPage = new LandingPage(driver);

        // Click on Signup/Login Button
        signUpPage.clickSignUpLink();

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

        // Test for URL locations
        String actual_url2 = driver.getCurrentUrl();
        String expected2 = "https://automationexercise.com/signup";
        Assert.assertEquals(expected2, actual_url2);

        // Make driver click the sign up for news letter checkbox
        driver.findElement(By.id("newsletter")).click();

        //Click Password field
        WebElement passwordField = driver.findElement(By.cssSelector("input[data-qa*='password']"));

        //Make Password credentials method
        String password = RandomStringUtils.randomAlphanumeric(10);

        //Print email/password for login later
//        System.out.println("THIS IS THE EMAIL" + randomName + "@TestEmail.com");
//        System.out.println("THIS IS THE PASSWORD" + password);

        //Enter password credentials into password field
        passwordField.sendKeys(password);

        //Click First name Field
        WebElement firstNameField = driver.findElement(By.cssSelector("input[data-qa*='first_name']"));

        //Generate a First name
        String firstName = RandomStringUtils.randomAlphabetic(10);

        //Enter first name into First Name field
        firstNameField.sendKeys(firstName);

        //Click Last name Field
        WebElement lastNameField = driver.findElement(By.cssSelector("input[data-qa*='last_name']"));

        //Generate a Last name
        String lastName = RandomStringUtils.randomAlphabetic(10);

        //Enter last name into Last Name field
        lastNameField.sendKeys(lastName);

        //Click address Field
        WebElement addressField = driver.findElement(By.cssSelector("input[name*='address1']"));

        //Make AddressStreet credentials method
        String addressStreet = RandomStringUtils.randomAlphabetic(8);

        //Make House number method
        String addressHouseNumber = RandomStringUtils.randomNumeric(3);

        //Make driver enter Address criteria
        addressField.sendKeys(addressHouseNumber + " " + addressStreet + " Rd.");

        // Select Country Drop bar and click it
        WebElement dropdown = driver.findElement(By.cssSelector("select[name='country']"));

        //Type "u" to select United States
        dropdown.sendKeys("u");

        //Study to properly understand drop down menu in selenium
        //driver.toSelect().selectByVisibleText("My identifer");


        //Find and select State field
        WebElement stateField = driver.findElement(By.cssSelector("input[data-qa*='state']"));

        //Enter State(Delaware)
        stateField.sendKeys("Delaware");


        //How can I create the myDriver object -- such that I can create a sendKeys method that can send these parameters?
//         myDriver.sendKeys("input[data-qa*='state']" , "Delaware"); // Create wrapper class

        //Find and select city field
        WebElement cityField = driver.findElement(By.cssSelector("input[data-qa*='city']"));

        //Enter city credentials
        cityField.sendKeys("Milford");

        //Find and select city field
        WebElement zipcodeField = driver.findElement(By.cssSelector("input[data-qa*='zipcode']"));

        //Enter zipcode credentials
        zipcodeField.sendKeys("19963");

        // Find Mobile Number field
        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[data-qa*='mobile_number']"));

        //Enter mobile number
        mobileNumberField.sendKeys("(555) 555 - 5555");

        // Create a JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by a specific number of pixels (e.g., 500 pixels)
        js.executeScript("window.scrollBy(0, 500)");

        //Find and click create account
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();


        // click continue
        driver.findElement(By.cssSelector("a[href*='/']")).click();

        // Close the WebDriver
//            driver.quit();

        // Extra code
        // _______________________________________________________________
        // Test for URL locations
//        String actual_url3 = driver.getCurrentUrl();
//        String expected3 = "https://automationexercise.com/account_created";
//        Assert.assertEquals(expected3, actual_url3);

        //Click continue and finish
//        driver.findElement(By.cssSelector("a[href*='/']")).click();
//        WebElement continueButton = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
//        continueButton.sendKeys(Keys.ENTER);

    } // End of Test
} // End of Class
