package com.vytrack.pages.login_navigation;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("excplicitwait"))));

    @FindBy(id = "prependedInput")
    public WebElement usernameElement;

    @FindBy(name = "_password")
    public WebElement passwordElement;

    @FindBy(id = "_submit")
    public WebElement loginButtonElement;

    @FindBy(css = "span[class='custom-checkbox__icon']")
    public WebElement rememberMeElement;

    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "h2")
    public WebElement titleElement;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement errorMessageElement;

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password) {
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();

    }

    public void clickRememberMe() {
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
        if (!rememberMeElement.isSelected()) {
            rememberMeElement.click();
        }
    }
}