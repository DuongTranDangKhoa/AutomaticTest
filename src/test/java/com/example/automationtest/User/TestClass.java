package com.example.automationtest.User;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TestClass {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void Login() {
            chromeDriver.get("https://www.weallnet.com");
            chromeDriver.get("https://auth.weallnet.com/vi/dang-nhap?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DWANBMS%26redirect_uri%3Dhttps%253A%252F%252Fwww.weallnet.com%252Fsignin-oidc%26response_type%3Dcode%2520id_token%26scope%3Dopenid%2520profile%2520offline_access%2520WANAPI%26response_mode%3Dform_post%26nonce%3D638299434489383602.NzdiZTkwODktZTZjZS00ZTEwLTlkOGEtODdhYjlhYzZkMDVhODk0ZmQ1ZTMtNWUxZS00ZGYxLThkYTgtN2FlZjMyN2IyODAz%26state%3DCfDJ8NPyX7F8XcxLnz6zSlziQShhR7fl0xcegY1zIypwZwIDNkKw_skYKzhzRWAt99Bwrc1tBWXzx9y8o3QjC6D3k0QU2dk9YVI2n6ZdId1sDSQ7mr-mXwN4UTO5abYr3B87PxvB2j1AH6tPe3Gjp8U5WQvVosHJ1GhDP37O_2IxiES4Khf0qiCm7zcqRblJ99KnNpOOoM_ThQAYYdUAM4sa97mKxh6xvzwMOzPgJ5z0VWTiRJpMw7QttLfh34_X-u4S-KxwZP6_IssQFRqRUasuagzXRC1DNfkACTVkqgpxYHz55Xig_iJMroy9_rbOp0KU9nWV50oWFr4Lp5MDjiMCn5dkXHDSIjVBk1pR-5Y_-iZw%26x-client-SKU%3DID_NETSTANDARD2_0%26x-client-ver%3D6.7.1.0");
            WebElement element = chromeDriver.findElement(By.id("Username"));
            WebElement element1= chromeDriver.findElement(By.id("ctrlPassword"));
            WebElement element2 = chromeDriver.findElement(By.name("button"));
            element.sendKeys("kd2002");
            sleep(5000);
            element1.sendKeys("Khoa25112002!");
            sleep(5000);
            element2.click();
    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}