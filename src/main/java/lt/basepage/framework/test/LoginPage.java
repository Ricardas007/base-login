package lt.basepage.framework.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(css = "input#field-email")
    WebElement inputEmail;

    @FindBy (css = "input#field-password")
    WebElement inputPassword;

    @FindBy (css = "[data-link-action='sign-in']")
    WebElement signInButton;

    @FindBy (css = ".page-footer [href]")
    WebElement accountPageSingOutBottomButton;

    @FindBy (css = "[title] .hidden-sm-down")
    WebElement desktopUserButton;

    @FindBy (css = ".hidden-sm-down.logout")
    WebElement signOutButton;

    @FindBy (css = ".alert-danger")
    WebElement alertLoginMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterUserPassward(String password) {
        inputPassword.sendKeys(password);
    }

    public void pressSignInButton() {
        signInButton.click();
    }

    public boolean isSignoutButtonVisible() {
        try {
             wait.until(ExpectedConditions.visibilityOf(accountPageSingOutBottomButton));
            return accountPageSingOutBottomButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToUserAccountPage() {
        desktopUserButton.click();
    }

    public void pressLogoutFromAccount() {
        signOutButton.click();
    }

    public String isAlertMessageIsVisible() {
        return alertLoginMessage.getText();
    }
}

