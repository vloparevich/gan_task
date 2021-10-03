package com.gan.tests;

import com.gan.auth.SignupPage;
import com.gan.landing.LandingPage;
import com.gan.testplatfrom.BTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * @author vloparevich
 */
public class SignupTest extends BTest {
    private LandingPage landingPage = null;

    @BeforeClass
    public void setUpSignupTest() {
        landingPage = new LandingPage(driver);
    }

    @Parameters({"title", "firstName", "lastName", "inputName"})
    @Test
    public void validationMessageTest(String title, String firstName, String lastName, String inputName) {
        SignupPage sp = landingPage.clickJoinNowUnderLoginForm()
                .selectTitle(title)
                .populateFirstNameInput(firstName)
                .populateLastNameInput(lastName)
                .checkBoxTermsAndConditions();
        sp.clickJoinNowButton();
        List<WebElement> requiredFiled = sp.getRequiredFieldByInputName(inputName);
        assertTrue(requiredFiled.size() == 1);
    }
}
