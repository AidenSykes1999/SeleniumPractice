package com.sparta.as.pom.pages;

import org.openqa.selenium.chrome.ChromeDriverService;
import java.io.File;


public class POMUtils {


    public static void setDriverLocation(String pathToDriver) {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
    }
    public static ChromeDriverService setChromeDriverService(String pathToDriver) {
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(pathToDriver))
                .usingAnyFreePort()
                .build();
    }



}
