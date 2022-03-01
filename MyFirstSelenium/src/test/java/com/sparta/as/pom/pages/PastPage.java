package com.sparta.as.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;


public class PastPage {

    WebDriver webDriver;
    By pageTop = By.className("pagetop");
    public PastPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean isDateYesterday() {
        LocalDate localDate = LocalDate.now();
        LocalDate yesterday = localDate.minusDays(1);
        String titleBar = webDriver.findElement(pageTop).getText();
        return titleBar.contains(yesterday.toString());
    }
    public String getUrl() {
        return webDriver.getCurrentUrl();
    }


}
