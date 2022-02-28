package com.sparta.as;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTests {

    private static WebDriver driver;

    @BeforeAll
    static void setupAll(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Checking the webdriver works")
    void checkingThatTheWebDriverWorks(){
        driver.get("http://news.ycombinator.com/");
        driver.findElement(By.linkText("past")).click();

        Assertions.assertEquals("https://news.ycombinator.com/front",driver.getCurrentUrl());
        }

    @Test
    @DisplayName("Checking that yesterday's date displays")
    void checkingPastDateIsDisplayed(){
        driver.get("https://news.ycombinator.com/front");
        String pastDate = driver.findElement(By.tagName("font")).getText().toString();

        Assertions.assertEquals("2022-02-27",pastDate);
    }

        @AfterAll
    static void tearDownAll(){
        //driver.close(); // close all open windows but not driver
        //driver.quit(); // closes everything
        }

    }



