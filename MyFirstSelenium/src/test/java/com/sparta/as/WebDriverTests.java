package com.sparta.as;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class WebDriverTests {

    private static WebDriver driver;
    private static ChromeOptions options;
    private static ChromeDriverService service;

    @BeforeEach
    void setup(){

        driver.get("http://news.ycombinator.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @BeforeAll
    static void setupAll(TestInfo testInfo){
System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        System.out.println(testInfo.getDisplayName());
        options = new ChromeOptions();
        //options.addArguments("headless");

        service = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();


        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service, options);

    }

    @Test
    @DisplayName("Checking the webdriver works")
    void checkingThatTheWebDriverWorks(){
        driver.findElement(By.linkText("past")).click();
        Assertions.assertEquals("https://news.ycombinator.com/front",driver.getCurrentUrl());
        }

    @Test
    @DisplayName("Checking that yesterday's date displays")
    void checkingPastDateIsDisplayed(){

        driver.findElement(By.linkText("past")).click();
        String pastDate = driver.findElement(By.xpath("//font")).getText();

        Assertions.assertEquals(LocalDate.now().minusDays(1).toString(),pastDate);
    }

    @Test
    @DisplayName("Test that the search box works")
    void testSearchBoxWorks(){
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
    }


    @Test
    @DisplayName("Test that tabs can be created")

    void changingTabs(){

        String originalTab = driver.getWindowHandle();
        System.out.println("First tab: " + driver.getWindowHandle());
        driver.findElement(By.linkText("past")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        System.out.println("Second tab: " + driver.getWindowHandle());
        System.out.println("All Tabs: " + driver.getWindowHandles());

        for (String tab: driver.getWindowHandles()){
            if(!originalTab.contains(tab)){
                driver.switchTo().window(tab);
                break;
            }
        }
    }


    @Test
    @DisplayName("Check if the newest page has 30 articles")
    void checkIfNewestPageHas30Articles(){

        driver.findElement(By.linkText("new")).click();
        int count = driver.findElements(By.className("athing")).size();
        Assertions.assertEquals(count,30);



    }

    @Test
    @DisplayName("Check if the past page has 30 articles")
    void checkIfPastPageHas30Articles(){

        driver.findElement(By.linkText("past")).click();
        int count = driver.findElements(By.className("athing")).size();
        Assertions.assertEquals(count,30);



    }

@Test
@DisplayName("Check if you need to be logged in to submit requests")
void checkIfNeedsToBeLoggedIn(){

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.linkText("submit")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Boolean canLogin = driver.getPageSource().startsWith("You have to be logged in to submit.");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Assertions.assertTrue(canLogin);



}


@ParameterizedTest
@DisplayName("Test Buttons On the Main Page")
@CsvSource({"new,https://news.ycombinator.com/newest"
        , "comments,https://news.ycombinator.com/newcomments"

})

void testForButtonWorking(String value, String site){

        driver.findElement(By.linkText(value)).click();
        Assertions.assertEquals(site, driver.getCurrentUrl());


}





        @AfterAll
    static void tearDownAll(){
        service.stop();
        //driver.close(); // close all open windows but not driver
        //driver.quit(); // closes everything
        }

    }



