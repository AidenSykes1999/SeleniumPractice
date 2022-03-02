package com.sparta.as.cucumber;

import com.sparta.as.pom.pages.HomePage;
import com.sparta.as.pom.pages.POMUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefs {

    private static WebDriver driver;
    private static ChromeOptions options;
    private static HomePage homePage;
    private static POMUtils logInPage;

    @BeforeAll
    static void setUp() {
        POMUtils.setDriverLocation();

        options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    void setUpAll() throws InterruptedException {
        homePage = new HomePage(driver);
        Thread.sleep(2000);
    }

    @Given("I go to the login page")
    public void iGoToTheLoginPage() {
        logInPage = homePage.goToLogInPage();
    }

    @When("I enter the correct login details and click the login button")
    public void iEnterTheCorrectLoginDetailsAndClickTheLoginButton() throws InterruptedException {
        logInPage.enterLogInDetails("dpbtest", "password");
    }

    @Then("I should be taken to the news page and logged in")
    public void iShouldBeTakenToTheNewsPageAndLoggedIn() {
        Assertions.assertTrue(logInPage.isLoggedIn());
    }
}



}
