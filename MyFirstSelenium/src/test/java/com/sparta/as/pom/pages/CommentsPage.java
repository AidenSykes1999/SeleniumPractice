package com.sparta.as.pom.pages;
import org.openqa.selenium.WebDriver;
public class CommentsPage {


        WebDriver webDriver;
        public CommentsPage(WebDriver webDriver) {
            this.webDriver = webDriver;
        }
        public String getUrl() {
            return webDriver.getCurrentUrl();
        }
}
