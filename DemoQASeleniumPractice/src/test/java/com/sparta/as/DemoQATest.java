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

public class DemoQATest
{
    private static WebDriver driver;
    private static ChromeOptions options;
    private static ChromeDriverService service;

    @BeforeEach
    void setup(){

        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
    @DisplayName("Get Title of Website")
    void getTitleOfTheWebsite(){
   String title =  driver.getTitle();
    Assertions.assertEquals(title, "ToolsQA");
}



    @Test
    @DisplayName("Checking the webdriver works")
    void checkingThatTheWebDriverWorks(){
        driver.findElement(By.name("Elements")).click();
        Assertions.assertEquals("https://demoqa.com/elements",driver.getCurrentUrl());
    }


    @AfterAll
    static void tearDownAll() {
        service.stop();
    }

}
