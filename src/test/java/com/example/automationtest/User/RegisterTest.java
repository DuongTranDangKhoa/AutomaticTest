package com.example.automationtest.User;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.Random;

public class RegisterTest {
    ChromeDriver chromeDriver;
    String user ;
    String  password ;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        user = "khoadang2002";
        password = "Khoa25112002@";
    }
    public String generateUsername(int length) {
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+<>?{}[]";
        Random random = new Random();
        StringBuilder user = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            user.append(charSet.charAt(randomIndex));
        }

        return user.toString();
    }
    public String generatePassword(int length) {
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+<>?{}[]";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);


        password.append(charSet.charAt(random.nextInt(52)));
        password.append(charSet.charAt(52 + random.nextInt(10)));
        password.append(charSet.charAt(62 + random.nextInt(28)));

        for (int i = 3; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            password.append(charSet.charAt(randomIndex));
        }


        for (int i = 0; i < password.length(); i++) {
            int j = random.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(j));
            password.setCharAt(j, temp);
        }

        return password.toString();
    }

    @Test
    public void RegisterVN(){
            chromeDriver.get("https://www.weallnet.com/vi/dang-ky");
            WebElement button = chromeDriver.findElement(By.cssSelector("button[type='submit']"));
            button.click();
            sleep(3000);
            WebElement username = chromeDriver.findElement(By.id("ctrlUserName"));
            sleep(3000);
            username.sendKeys(user);
            sleep(3000);
            WebElement pass = chromeDriver.findElement(By.id("ctrlPassword"));
            pass.sendKeys(password);
            sleep(3000);
            WebElement confPassword = chromeDriver.findElement(By.id("ctrlConfirmPassword"));
            confPassword.sendKeys(password);
            sleep(3000);
            WebElement email = chromeDriver.findElement(By.id("ctrlEmail"));
            email.sendKeys("khoa.duong@weallnet.com");
            sleep(3000);

            WebElement fullname = chromeDriver.findElement(By.id("ctrlFullName"));
            fullname.sendKeys("Dang Khoa");
            sleep(3000);
            WebElement checkbox = chromeDriver.findElement(By.id("check-box"));
            checkbox.click();
            sleep(3000);
            WebElement button2 = chromeDriver.findElement(By.cssSelector("button[data-bind='click:$root.submitRegisterAccount']"));
            button2.click();
        WebElement element = chromeDriver.findElement(By.id("Username"));
        WebElement element1= chromeDriver.findElement(By.id("ctrlPassword"));
        WebElement element2 = chromeDriver.findElement(By.name("button"));
        element.sendKeys(user);
        sleep(3000);
        element1.sendKeys(password);
        sleep(3000);
        element2.click();
        chromeDriver.quit();
    }
    @Test
    public void RegisterEN(){
        chromeDriver.get("https://www.weallnet.com/en/register");
        WebElement button = chromeDriver.findElement(By.cssSelector("button[type='submit']"));
        button.click();
        sleep(3000);
        WebElement username = chromeDriver.findElement(By.id("ctrlUserName"));
        sleep(3000);
        username.sendKeys(user);
        sleep(3000);
        WebElement pass = chromeDriver.findElement(By.id("ctrlPassword"));
        pass.sendKeys(password);
        sleep(3000);
        WebElement confPassword = chromeDriver.findElement(By.id("ctrlConfirmPassword"));
        confPassword.sendKeys(password);
        sleep(3000);
        WebElement email = chromeDriver.findElement(By.id("ctrlEmail"));
        email.sendKeys("khoaduongCreator@weallnet.com");
        sleep(3000);

        WebElement fullname = chromeDriver.findElement(By.id("ctrlFullName"));
        fullname.sendKeys("Duong Tran Dang Khoa");
        sleep(3000);
        WebElement checkbox = chromeDriver.findElement(By.id("check-box"));
        checkbox.click();
        sleep(3000);
        WebElement button2 = chromeDriver.findElement(By.cssSelector("button[data-bind='click:$root.submitRegisterAccount']"));
        button2.click();
        WebElement element = chromeDriver.findElement(By.id("Username"));
        WebElement element1= chromeDriver.findElement(By.id("ctrlPassword"));
        WebElement element2 = chromeDriver.findElement(By.name("button"));
        element.sendKeys(user);
        sleep(3000);
        element1.sendKeys(password);
        sleep(3000);
        element2.click();
        chromeDriver.quit();
    }
    @Test
    public void Login() {
        chromeDriver.get("https://www.weallnet.com");
        chromeDriver.get("https://auth.weallnet.com/vi/dang-nhap?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DWANBMS%26redirect_uri%3Dhttps%253A%252F%252Fwww.weallnet.com%252Fsignin-oidc%26response_type%3Dcode%2520id_token%26scope%3Dopenid%2520profile%2520offline_access%2520WANAPI%26response_mode%3Dform_post%26nonce%3D638299434489383602.NzdiZTkwODktZTZjZS00ZTEwLTlkOGEtODdhYjlhYzZkMDVhODk0ZmQ1ZTMtNWUxZS00ZGYxLThkYTgtN2FlZjMyN2IyODAz%26state%3DCfDJ8NPyX7F8XcxLnz6zSlziQShhR7fl0xcegY1zIypwZwIDNkKw_skYKzhzRWAt99Bwrc1tBWXzx9y8o3QjC6D3k0QU2dk9YVI2n6ZdId1sDSQ7mr-mXwN4UTO5abYr3B87PxvB2j1AH6tPe3Gjp8U5WQvVosHJ1GhDP37O_2IxiES4Khf0qiCm7zcqRblJ99KnNpOOoM_ThQAYYdUAM4sa97mKxh6xvzwMOzPgJ5z0VWTiRJpMw7QttLfh34_X-u4S-KxwZP6_IssQFRqRUasuagzXRC1DNfkACTVkqgpxYHz55Xig_iJMroy9_rbOp0KU9nWV50oWFr4Lp5MDjiMCn5dkXHDSIjVBk1pR-5Y_-iZw%26x-client-SKU%3DID_NETSTANDARD2_0%26x-client-ver%3D6.7.1.0");
        WebElement element = chromeDriver.findElement(By.id("Username"));
        WebElement element1= chromeDriver.findElement(By.id("ctrlPassword"));
        WebElement element2 = chromeDriver.findElement(By.name("button"));
        element.sendKeys(user);
        sleep(3000);
        element1.sendKeys(password);
        sleep(3000);
        element2.click();

    }
    @Test
    public void LoginbyGoogle(){
        chromeDriver.get("https://www.weallnet.com");
        chromeDriver.get("https://auth.weallnet.com/vi/dang-nhap?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DWANBMS%26redirect_uri%3Dhttps%253A%252F%252Fwww.weallnet.com%252Fsignin-oidc%26response_type%3Dcode%2520id_token%26scope%3Dopenid%2520profile%2520offline_access%2520WANAPI%26response_mode%3Dform_post%26nonce%3D638299434489383602.NzdiZTkwODktZTZjZS00ZTEwLTlkOGEtODdhYjlhYzZkMDVhODk0ZmQ1ZTMtNWUxZS00ZGYxLThkYTgtN2FlZjMyN2IyODAz%26state%3DCfDJ8NPyX7F8XcxLnz6zSlziQShhR7fl0xcegY1zIypwZwIDNkKw_skYKzhzRWAt99Bwrc1tBWXzx9y8o3QjC6D3k0QU2dk9YVI2n6ZdId1sDSQ7mr-mXwN4UTO5abYr3B87PxvB2j1AH6tPe3Gjp8U5WQvVosHJ1GhDP37O_2IxiES4Khf0qiCm7zcqRblJ99KnNpOOoM_ThQAYYdUAM4sa97mKxh6xvzwMOzPgJ5z0VWTiRJpMw7QttLfh34_X-u4S-KxwZP6_IssQFRqRUasuagzXRC1DNfkACTVkqgpxYHz55Xig_iJMroy9_rbOp0KU9nWV50oWFr4Lp5MDjiMCn5dkXHDSIjVBk1pR-5Y_-iZw%26x-client-SKU%3DID_NETSTANDARD2_0%26x-client-ver%3D6.7.1.0");
        WebElement buttongg = chromeDriver.findElement(By.className("logo-img"));
        buttongg.click();
        sleep(3000);
        WebElement email = chromeDriver.findElement(By.id("identifierId"));
        email.sendKeys("khoa.duong@weallnet.com");
        WebElement button = chromeDriver.findElement(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"));
        button.click();
        sleep(3000);
        WebElement password = chromeDriver.findElement(By.name("Passwd"));
        password.sendKeys("khoa25112002k");
        sleep(3000);
        WebElement buttonPass = chromeDriver.findElement(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"));
        buttonPass.click();
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
    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
