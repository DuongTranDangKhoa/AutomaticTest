package com.example.automationtest.User;

import com.example.automationtest.Library.BestFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class CheckSocial extends BestFunction {
    ChromeDriver chromeDriver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }
    public void SocialMedia(String[] media){
        for (String sm: media) {
            WebElement social = chromeDriver.findElement(By.id(sm));
            social.click();
            sleep(5000);
        }
    }
    @Test
    public void Social(){
        chromeDriver.get("https://www.weallnet.com");
       SocialMedia(new String[]{"facebook-footer", "linkedin-footer", "instagram-footer", "tiktok-footer", "youtube-footer"});
      chromeDriver.quit();
    }
    @AfterMethod
    public void takeScreenShotForFailures(ITestResult testResult){
        if(ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) chromeDriver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/"+ testResult.getName()+".png");
            try {
                FileHandler.copy(source, destination);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
