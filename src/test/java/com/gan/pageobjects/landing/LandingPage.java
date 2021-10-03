package com.gan.pageobjects.landing;

import com.gan.pageobjects.auth.SignupPage;
import com.gan.pageobjects.basepageplatform.CommonImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author vloparevich
 */
public class LandingPage extends CommonImpl {
    private By joinNowUnderButtonLogin = By.xpath("//a[@class='newUser green' and text()='Join Now!']");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage clickJoinNowUnderLoginForm() {
        this.getElementByLocator(joinNowUnderButtonLogin).click();
        return new SignupPage(driver);
    }
}
