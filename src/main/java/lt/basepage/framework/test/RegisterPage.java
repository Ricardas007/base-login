package lt.basepage.framework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage{
    // Input fields
    @FindBy (id = "field-firstname")
    WebElement inputFirstName;

    @FindBy (css = "#field-lastname")
    WebElement inputLastName;

    @FindBy (css = "#field-email")
    WebElement inputEmail;

    @FindBy(css = "[name=\"password\"]")
    WebElement inputPassword;

    // Navigation buttons
    @FindBy (css = ".user-info")
    WebElement signInButton;

    @FindBy (css = "a .hidden-sm-down")
    WebElement accountOwnerNameButton;
    
    @FindBy (css = ".no-account")
    WebElement noAccountButton;

    @FindBy (css = "[data-link-action]")
    WebElement saveButton;

    //Checkmark button
    @FindBy (css = "#field-id_gender-1")
    WebElement genderMrButton;

    @FindBy (css = "[name='psgdpr']")
    WebElement termsAndConditionsButton;

    @FindBy (css = "[name='customer_privacy']")
    WebElement customerDataPrivacyButton;

    @FindBy (css = ".alert-danger")
    WebElement alertMessageText;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void pressSignInButton() {
        signInButton.click();
    }

    public void pressNoAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(noAccountButton)).click();
//        noAccountButton.click();
    }

    public void enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void enterUserEmail(String email) {
        inputEmail.sendKeys(email);
    }
    
    public void enterUserPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void pressGenderButton() {
        genderMrButton.click();
    }

    public void pressTermsAndConditionsButton() {
        termsAndConditionsButton.click();
    }

    public void pressCustomerDataPrivacyButton() {
        customerDataPrivacyButton.click();
    }

    public String accountOwnerName() {
        return accountOwnerNameButton.getText();
    }

    public String getAlertMessageText() {
        return alertMessageText.getText();
    }
}
