package com.sparta.as;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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

        @AfterAll
    static void tearDownAll(){
        //driver.close(); // close all open windows but not driver
        //driver.quit(); // closes everything
        }

    }



