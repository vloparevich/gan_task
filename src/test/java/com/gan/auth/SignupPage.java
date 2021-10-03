package com.gan.auth;

import com.gan.basepageplatform.CommonImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author vloparevich
 */
public class SignupPage extends CommonImpl {
    private By titleDropDown = By.id("title");
    private By firstName = By.id("forename");
    private By lastName = By.xpath("//label[text() = 'Surname:']/following-sibling::*[1][@name='map(lastName)']"); // just for fun
    private By termsAndConditionsCheckBox = By.xpath("//input[@name='map(terms)' and @id='checkbox']");
    private By submitFormButton = By.xpath("//input[@type='submit' and @value='Join Now!']");
    private By requiredFieldText = By.xpath("//select[@name='map(dobYear)']/following-sibling::*[1][text()='This field is required']");
    private By joinNowSubmitButton = By.id("form");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage selectTitle(String text) {
        this.selectByVisibleText(titleDropDown, text);
        return this;
    }

    public SignupPage populateFirstNameInput(String firstNameText) {
        this.sendKeys(firstName, firstNameText);
        return this;
    }

    public SignupPage populateLastNameInput(String lastNameText) {
        this.sendKeys(lastName, lastNameText);
        return this;
    }

    public SignupPage checkBoxTermsAndConditions() {
        this.getElementByLocatorAndClick(termsAndConditionsCheckBox);
        return this;
    }

    public SignupPage submitSignupForm() {
        this.getElementByLocatorAndClick(submitFormButton);
        return this;
    }

    public List<WebElement> getRequiredFieldByInputName(String inputName) {
        By requiredText = By.xpath("//select[@name='map(" + inputName + ")']/following-sibling::*[1][text()='This field is required']");
        return this.getElementsByLocator(requiredText);
    }

    public List<WebElement> getAllRequiredFiledErrorMessages() {
        return this.getElementsByLocator(requiredFieldText);
    }

    public void clickJoinNowButton() {
        this.getElementByLocatorAndClick(joinNowSubmitButton);
    }
}
