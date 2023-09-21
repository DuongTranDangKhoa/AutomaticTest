package com.example.automationtest.Library;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class BestFunction {


    public void Login(String user, String password, ChromeDriver Driver) {
        Driver.get("https://www.weallnet.com");
        Driver.get("https://auth.weallnet.com/vi/dang-nhap?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DWANBMS%26redirect_uri%3Dhttps%253A%252F%252Fwww.weallnet.com%252Fsignin-oidc%26response_type%3Dcode%2520id_token%26scope%3Dopenid%2520profile%2520offline_access%2520WANAPI%26response_mode%3Dform_post%26nonce%3D638299434489383602.NzdiZTkwODktZTZjZS00ZTEwLTlkOGEtODdhYjlhYzZkMDVhODk0ZmQ1ZTMtNWUxZS00ZGYxLThkYTgtN2FlZjMyN2IyODAz%26state%3DCfDJ8NPyX7F8XcxLnz6zSlziQShhR7fl0xcegY1zIypwZwIDNkKw_skYKzhzRWAt99Bwrc1tBWXzx9y8o3QjC6D3k0QU2dk9YVI2n6ZdId1sDSQ7mr-mXwN4UTO5abYr3B87PxvB2j1AH6tPe3Gjp8U5WQvVosHJ1GhDP37O_2IxiES4Khf0qiCm7zcqRblJ99KnNpOOoM_ThQAYYdUAM4sa97mKxh6xvzwMOzPgJ5z0VWTiRJpMw7QttLfh34_X-u4S-KxwZP6_IssQFRqRUasuagzXRC1DNfkACTVkqgpxYHz55Xig_iJMroy9_rbOp0KU9nWV50oWFr4Lp5MDjiMCn5dkXHDSIjVBk1pR-5Y_-iZw%26x-client-SKU%3DID_NETSTANDARD2_0%26x-client-ver%3D6.7.1.0");
        WebElement element = Driver.findElement(By.id("Username"));
        WebElement element1 = Driver.findElement(By.id("ctrlPassword"));
        WebElement element2 = Driver.findElement(By.name("button"));
        element.sendKeys(user);
        sleep(3000);
        element1.sendKeys(password);
        sleep(3000);
        element2.click();
    }

    public void Googlemail(ChromeDriver chromeDriver) {
        WebElement buttongg = chromeDriver.findElement(By.className("logo-img"));
        buttongg.click();
        sleep(3000);
        WebElement email = chromeDriver.findElement(By.id("identifierId"));
        email.sendKeys("khoa.duong@weallnet.com");
        sleep(3000);
        WebElement button = chromeDriver.findElement(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"));
        button.click();
        sleep(3000);
        WebElement password = chromeDriver.findElement(By.name("Passwd"));
        password.sendKeys("khoa25112002k");
        sleep(3000);
        WebElement buttonPass = chromeDriver.findElement(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"));
        buttonPass.click();
    }

    public void LogAdmin(ChromeDriver chromeDriver) {
        chromeDriver.get("https://admin.weallnet.com/");
        WebElement btlogin = chromeDriver.findElement(By.cssSelector("span.explore"));
        btlogin.click();
        sleep(3000);
        Googlemail(chromeDriver);

    }

    public void MaxiumWin(ChromeDriver chromeDriver) {
        chromeDriver.manage().window().maximize();
    }

    public void simulateEnter() {
        try {
            Robot robot = new Robot();
            // Simulate a key press
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void copycatch(String string) {
        StringSelection str = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
    }

    public void quitChrome(ChromeDriver chromeDriver) {
        chromeDriver.quit();
    }

    public void takeScreenShotForFailures(ITestResult testResult, ChromeDriver chromeDriver) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) chromeDriver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/" + testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}