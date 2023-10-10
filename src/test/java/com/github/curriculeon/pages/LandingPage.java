package com.github.curriculeon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private By signUpLink = By.cssSelector("a[href*='/login']");
    private By inputName = By.cssSelector("input[data-qa*='signup-name']");
    private By inputEmail = By.cssSelector("input[data-qa*='signup-email']");
    private By signUpButton = By.cssSelector("button[data-qa*='signup-button']");
    private By newsLetterCheckBox = By.id("newsletter");

    private By inputPassword = By.cssSelector("input[data-qa*='password']");

    private By inputFirstName = By.cssSelector("input[data-qa*='first_name']");
    private By inputLastName = By.cssSelector("input[data-qa*='last_name']");

    private By inputAddress1 = By.cssSelector("input[name*='address1']");
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUpLink(){
        driver.findElement(signUpLink).click();
    }

    public void signUp(){
        clickSignUpLink();
    }
}