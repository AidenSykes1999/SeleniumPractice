package com.sparta.as;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;

public class WebDriverTests {

    private static WebDriver driver;


    @BeforeEach
    void setup(){
        driver.get("http://news.ycombinator.com/");
    }


    @BeforeAll
    static void setupAll(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
        driver = new ChromeDriver();
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
    @DisplayName("Managing settings for the webdriver")
    void managingSettingsForTheWebdriver(){
        driver.findElement(By.linkText("past")).click();
        driver.navigate().forward();
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
    }

    @Test
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



        @AfterAll
    static void tearDownAll(){
        //driver.close(); // close all open windows but not driver
        //driver.quit(); // closes everything
        }

    }



