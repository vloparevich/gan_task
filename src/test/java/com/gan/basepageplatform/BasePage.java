package com.gan.basepageplatform;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author vloparevich
 */
public abstract class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static Logger log;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
        this.actions = new Actions(this.driver);
        this.log = Logger.getLogger(this.getClass().getName());
    }

    public String getDriverInstanceName() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }

    public void selectByVisibleText(By locator, String text) {
        WebElement el = this.getElementByLocator(locator);
        Select options = new Select(el);
        options.selectByVisibleText(text);
    }

    protected String getAttributeValue(By locator, String attributeName) {
        waitForElementExplicitly(locator);
        return getElementByLocator(locator).getAttribute(attributeName);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void getElementByLocatorAndClick(By locator){
        this.getElementByLocator(locator).click();
    }


    public void clickElement(By locator) {
        if (getDriverInstanceName().equals("chrome")) {
            waitForElementExplicitly(locator);
            actions.moveToElement(getElementByLocator(locator)).click().build().perform();
        }
    }

    private void waitForElementExplicitly(By waitLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(waitLocator));
    }

    private void waitForElementPresentExplicitly(By waitLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(waitLocator));
    }

    public void sendKeys(By locator, String keys) {
        waitForElementExplicitly(locator);
        actions.moveToElement(getElementByLocator(locator)).click().sendKeys(keys).build().perform();
    }

    protected WebElement getElementByLocator(By locator) {
        waitForElementExplicitly(locator);
        return driver.findElement(locator);
    }

    protected WebElement getElementByLocatorWithPresence(By locator) {
        waitForElementPresentExplicitly(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> getElementsByLocator(By locator) {
        waitForElementExplicitly(locator);
        return driver.findElements(locator);
    }

    protected List<WebElement> getElementsWithNoWaitByLocator(By locator) {
        return driver.findElements(locator);
    }


    public String getTextAsString(By locator) {
        return getElementByLocator(locator).getText();
    }
}
