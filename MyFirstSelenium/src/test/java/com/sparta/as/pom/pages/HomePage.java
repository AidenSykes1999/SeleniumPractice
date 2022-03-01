package com.sparta.as.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    WebDriver webDriver; // Home page only!!!    By comments = new By.ByLinkText("comments"); //elements of the page you want to interact with    By past = new By.ByLinkText("past");
    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        goToHomePage();
    }
    private void goToHomePage() {
        webDriver.get("https://news.ycombinator.com/");
    }
    public CommentsPage goToCommentsPage() {
        webDriver.findElement(By.linkText("comments")).click();
        return new CommentsPage(webDriver);
    }
    public PastPage goToPastPage() {
        webDriver.findElement(past).click();
        return new PastPage(webDriver);
    }

}
