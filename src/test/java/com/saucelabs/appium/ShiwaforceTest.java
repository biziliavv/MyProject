package com.shiwa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class ShiwaforceTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        //Appium needs the path of app build
        //Set up the desired capabilities and pass the iOS SDK version and app path to Appium
        File app = new File("/Users/admin/Library/Developer/Xcode/DerivedData/karmaplatform-dlgwpadqmehxlpdcconqkavvsbun/Build/Products/Debug-iphonesimulator/karmaplatform.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "8.3");
        capabilities.setCapability("deviceName", "iPhone 5s");
        capabilities.setCapability("app", app.getAbsolutePath());
        //       capabilities.setCapability("app", "/Users/admin/Library/Developer/Xcode/DerivedData/karmaplatform-dlgwpadqmehxlpdcconqkavvsbun/Build/Products/Debug-iphoneos/karmaplatform.app");

//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AppiumDriver(new URL("http://127.0.0.1:1111/wd/hub"), capabilities) {


            public MobileElement scrollTo(String s) {
                return null;
            }

            public MobileElement scrollToExact(String s) {
                return null;
            }
        };


    }


    @Test
    public void myCompanytesting() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.name("Settings")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("Add URL")).click();
        Thread.sleep(1000);
        String url = "https://apps.karmaplatform.com";
        Thread.sleep(2000);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]")).sendKeys(url);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//UIATableCell[(@name='Add URL')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//UIATextField[(@value='Your email address')]")).sendKeys("biziliavv@gmail.com");
        driver.findElement(By.xpath("//UIASecureTextField[(@value='Your password')]")).sendKeys("123456");

        driver.findElement(By.xpath("//UIAButton[(@name='Log in')]")).click();
        System.out.println("User is logged in");

        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }

        try {
            driver.findElement(By.name("OK")).click();
        } catch (Exception e) {

        }


        driver.findElement(By.name("SKIP")).click();
        Thread.sleep(2000);
        System.out.println("My Company is opened");
        driver.findElement(By.xpath("//UIANavigationBar[1]/UIAButton[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("menu btn")).click();
        driver.findElement(By.name("Devices")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//UIAStaticText[(@name='MacBook Pro I')]")).click();
        driver.findElement(By.name("editingIcon")).click();
        driver.findElement(By.xpath("//UIATextView[1]")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//UIATextView[1]")).sendKeys("New MacBook Pro I");
        driver.findElement(By.name("checkOK")).click();
        System.out.println("Name of device is changed");
        WebElement changename = driver.findElement(By.xpath("//UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]"));
        Assert.assertEquals(true, changename.isDisplayed());
        driver.findElement(By.name("editingIcon")).click();
        driver.findElement(By.xpath("//UIATextView[1]")).clear();
        driver.findElement(By.xpath("//UIATextView[1]")).sendKeys("MacBook Pro I");
        driver.findElement(By.name("checkOK")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("comment")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("Write a Comment")).click();
        Thread.sleep(500);
        driver.findElement(By.name("close img")).click();
        Thread.sleep(500);
        WebElement com = driver.findElement(By.name("Notes"));
        Assert.assertEquals(true, com.isDisplayed());
        System.out.println("Sending comment is cancelled");
        driver.findElement(By.name("Write a Comment")).click();
        Thread.sleep(500);
        driver.findElement(By.name("Send")).click();
//            WebElement emptycomment = driver.findElement(By.xpath("//UIAStaticText[(@name='Sorry, you can't send blank comments')]"));
//            Thread.sleep(1000);
//            Assert.assertEquals(true, emptycomment.isDisplayed());
        Thread.sleep(1000);
        System.out.println("Trying of sending empty comment is done");
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
        driver.findElement(By.name("close img")).click();
        Thread.sleep(500);
        driver.findElement(By.name("Write a Comment")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//UIAScrollView[1]/UIAImage[5]")).click();
        driver.findElement(By.xpath("//UIATextView[1]")).sendKeys("My Comment");
        driver.findElement(By.name("Done")).click();
        driver.findElement(By.name("Send")).click();
        System.out.println("Comment is sent");
//            Assert.assertEquals(true, com.isDisplayed());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//UIANavigationBar[1]/UIAButton[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//UIANavigationBar[1]/UIAButton[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("menu btn")).click();
        driver.findElement(By.name("Staff")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//UIANavigationBar[1]/UIAButton[2]")).click();
        driver.findElement(By.xpath("//UIAStaticText[(@name='Box Manager')]")).click();
        Thread.sleep(2000);
        driver.swipe(264, 108, 80, 115, 1000);
        driver.findElement(By.name("Adappt Baby!")).click();
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(driver.findElement(By.xpath("//UIACollectionCell[2]"))).waitAction(1000).moveTo(driver.findElement(By.xpath("//UIACollectionCell[4]"))).release();
        touchAction.perform();
        Thread.sleep(2000);
        driver.findElement(By.name("checkOK")).click();
        System.out.println("Position line is moved down");
        Thread.sleep(2000);
        driver.swipe(264, 108, 80, 115, 1000);
        driver.findElement(By.name("Adappt Baby!")).click();
        touchAction.longPress(driver.findElement(By.xpath("//UIACollectionCell[4]"))).waitAction(1000).moveTo(driver.findElement(By.xpath("//UIACollectionCell[2]"))).release();
        touchAction.perform();
        Thread.sleep(1000);
        driver.findElement(By.name("checkOK")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//UIANavigationBar[1]/UIAButton[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("menu btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("Logout")).click();
        System.out.println("User is logged out");
        driver.closeApp();


    }

    @Test
    public void blatesting() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.runAppInBackground(2);
        driver.closeApp();
        Thread.sleep(5000);
        driver.getAppStrings();
    }
}




