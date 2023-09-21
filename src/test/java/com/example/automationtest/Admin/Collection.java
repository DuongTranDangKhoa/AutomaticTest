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

public class Collection extends BestFunction {
    ChromeDriver chromeDriver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void addCollection(){
        MaxiumWin(chromeDriver);
        LogAdmin(chromeDriver);
        sleep(3000);
        chromeDriver.get("https://admin.weallnet.com/vi/bo-suu-tap/danh-sach");
        sleep(3000);
        //Click add Collection
        WebElement btaddCollection = chromeDriver.findElement(By.className("button-save"));
        btaddCollection.click();
        WebElement name = chromeDriver.findElement(By.id("ctrlName"));
        name.sendKeys("Khoa Review Phim");
        WebElement searchChannel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.startSearchPopupChannelProfile']"));
        searchChannel.click();
        sleep(3000);
        WebElement search = chromeDriver.findElement(By.cssSelector("input.form-control.reset-btn"));
        search.sendKeys("test kênh");
        sleep(5000);
        WebElement clickbutton = chromeDriver.findElement(By.className("search-icon-new"));
        clickbutton.click();
        sleep(3000);
        WebElement clickaddingchanel = chromeDriver.findElement(By.cssSelector("div[data-bind='click:$root.selectChannelProfile']"));;
        clickaddingchanel.click();
        sleep(3000);
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
