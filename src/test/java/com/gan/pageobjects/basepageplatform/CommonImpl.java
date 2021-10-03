package com.gan.pageobjects.basepageplatform;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * @author vloparevich
 */
public class CommonImpl extends BasePage{
    public CommonImpl(WebDriver driver) {
        super(driver);
    }



    public static void getWideViewPort(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(2000, 1024));
    }

    public static void getSuperWideViewPort(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(3000, 1024));
    }

    public static void getStandardViewPort(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(1280, 1024));
    }

}
