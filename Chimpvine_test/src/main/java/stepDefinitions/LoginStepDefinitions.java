package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {

    WebDriver driver;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://np.chimpvine.com/login/");
    }

    @When("they enter valid username and password")
    public void enterValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("login_username"));
        WebElement passwordField = driver.findElement(By.id("login_password"));

        usernameField.sendKeys("UtsargaAdhikari");
        passwordField.sendKeys("Utsarga@101");
    }

    @And("click on the \"Login\" button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();
    }

    @Then("they should be redirected to the main landing page")
    public void verifyRedirectToMainLandingPage() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("https://np.chimpvine.com/")) {
            throw new AssertionError("Redirect to main landing page failed");
        }
        driver.quit();
    }
    @When("they enter invalid username and password")
    public void enterInvalidCredentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("invalid_username");
        passwordField.sendKeys("invalid_password");
    }

    @And("click on the \"Login\" button")
    public void clickLoginBtn() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("they should see an error message and login should not be successful")
    public void verifyErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();

    }

    @When("they leave both username and password fields empty")
    public void leaveEmptyFields() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @And("click on the \"Login\" button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("they should see an error message and login should not be successful")
    public void verifyErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }

    @When("they enter a valid username in different case")
    public void enterValidUsernameDifferentCase() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("Valid_Username_In_Different_Case");
        passwordField.sendKeys("valid_password");
    }

    @Then("they should be redirected to the main landing page")
    public void verifyRedirectToMainLandingPage() {
        assertTrue(driver.getCurrentUrl().contains("main-landing-page-url"));
        driver.quit();
    }

    @When("they enter a username with leading/trailing spaces")
    public void enterUsernameWithSpaces() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("  username_with_spaces  ");
        passwordField.sendKeys("valid_password");
    }

    @When("they enter a valid username")
    public void enterValidUsername() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("valid_username");
        passwordField.sendKeys("valid_password");
    }

    @And("check the \"Remember Me\" option")
    public void checkRememberMeOption() {
        WebElement rememberMeCheckbox = driver.findElement(By.id("rememberMeCheckbox"));
        rememberMeCheckbox.click();
    }

    @Then("they should be redirected to the main landing page with persistent login")
    public void verifyPersistentLogin() {
        assertTrue(driver.getCurrentUrl().contains("main-landing-page-url"));
        driver.quit();
    }

    @When("they enter an invalid username multiple times")
    public void enterInvalidUsernameMultipleTimes() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        for (int i = 0; i < 3; i++) {
            usernameField.sendKeys("invalid_username");
            passwordField.sendKeys("valid_password");
            loginButton.click();
            usernameField.clear();
            passwordField.clear();
        }
    }

    @When("they enter a valid username")
    public void enterValidUsernameAgain() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("valid_username");
        passwordField.sendKeys("valid_password");
    }

    @When("they toggle password visibility")
    public void togglePasswordVisibility() {
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement passwordVisibilityToggle = driver.findElement(By.id("passwordVisibilityToggle"));

        passwordField.sendKeys("valid_password");
        passwordVisibilityToggle.click();
    }

    @When("they enter a password with special characters")
    public void enterPasswordWithSpecialCharacters() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("valid_username");
        passwordField.sendKeys("password_with_special!characters");
    }

    @When("they enter a username with a locked status")
    public void enterLockedUsername() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("locked_username");
        passwordField.sendKeys("valid_password");
    }

    @Then("they should see an error message and login should not be successful")
    public void verifyErrorMessageDisplayedAgain() {
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }

    }

