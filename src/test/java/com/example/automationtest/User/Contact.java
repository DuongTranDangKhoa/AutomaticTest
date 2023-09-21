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

public class Contact extends BestFunction {
    ChromeDriver chromeDriver;
    private String Name = "Dang Khoa ";
    private String Email = "duongtrandangkhoa2511@gmail.com";
    private String Std = "0937997287";
    private String Mess = "khoadang";
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void Contact(){
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://weallnet.com/");
        WebElement element = chromeDriver.findElement(By.xpath("//li[@class='nav-item nav-hoptac']/a"));
        element.click();
        sleep(3000);
        WebElement name = chromeDriver.findElement(By.name("Name"));
        name.sendKeys(Name);
        sleep(3000);
        WebElement email = chromeDriver.findElement(By.name("Email"));
        email.sendKeys(Email);
        sleep(3000);
        WebElement std = chromeDriver.findElement(By.name("Mobile"));
        std.sendKeys(Std);
        sleep(3000);
        WebElement mess = chromeDriver.findElement(By.name("Message"));
        mess.sendKeys(Mess);
    }
    @Test
    public void Mess(){
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://weallnet.com/");
        WebElement element = chromeDriver.findElement(By.xpath("//li[@class='nav-item nav-lienhe']/a"));
        element.click();
        sleep(3000);
        WebElement name = chromeDriver.findElement(By.name("Name"));
        name.sendKeys(Name);
        sleep(3000);
        WebElement email = chromeDriver.findElement(By.name("Email"));
        email.sendKeys(Email);
        sleep(3000);
        WebElement std = chromeDriver.findElement(By.name("Mobile"));
        std.sendKeys(Std);
        sleep(3000);
        WebElement mess = chromeDriver.findElement(By.name("Message"));
        mess.sendKeys(Mess);
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
