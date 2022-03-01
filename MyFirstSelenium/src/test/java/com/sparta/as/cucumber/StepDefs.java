package com.sparta.as.cucumber;

public class StepDefs {

    private static WebDriver driver;
    private static ChromeOptions options;
    private static HomePage homePage;
    private static LogInPage logInPage;

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
