package lt.basepage.framework.test;

import lt.basepage.calculator.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogoutPage extends BasePage {

    @FindBy (css = ".user-info .hidden-sm-down")
    WebElement signinButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSinginButtonOnNavBarVisible() {
            try {
                wait.until(ExpectedConditions.visibilityOf(signinButton));
                return signinButton.isDisplayed();
            } catch (Exception e) {
                return false;
            }
    }
}
