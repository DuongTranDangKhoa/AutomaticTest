package com.example.automationtest.Admin;

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

public class Media extends BestFunction {
    ChromeDriver chromeDriver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void Movie(){
        MaxiumWin(chromeDriver);
        LogAdmin(chromeDriver);
        sleep(3000);
        chromeDriver.get("https://admin.weallnet.com/vi/Movie/List");
        WebElement link = chromeDriver.findElement(By.cssSelector("a.button-save"));
        link.click();
        WebElement Title = chromeDriver.findElement(By.id("ctrlTitle"));
        Title.sendKeys("Phim moi.net");
        WebElement searchChannel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.startSearchPopupChannelConfig']"));
        searchChannel.click();
        WebElement buttonchamel = chromeDriver.findElement(By.cssSelector("div[data-bind=\"visible:$root.movieVM().movie()!=null,click:$root.selectChannelConfig\"]"));


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
