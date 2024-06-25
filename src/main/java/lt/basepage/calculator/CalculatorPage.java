package lt.basepage.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage{

    @FindBy(css = "input[name='number1']")
    WebElement inputCalculatorFirstNumber;

    @FindBy (css = "input[name='number2']")
    WebElement inputCalculatorSecondNumber;

    @FindBy (css = "[name='function']")
    WebElement dropDownMeniu;

    @FindBy (css = "input#calculate")
    WebElement pressCalculateButton;

    @FindBy (css = "span#answer")
    WebElement outputCalculatorResult;

    public CalculatorPage(WebDriver driver) {
            super(driver);
    }

    public void enterFirstNumber(int number1) {
        inputCalculatorFirstNumber.sendKeys(String.valueOf(number1));
    }

    public void enterSecondNumber(int number2) {
        inputCalculatorSecondNumber.sendKeys(String.valueOf(number2));
    }

    public void performCountAction(String action) {
        Select se = new Select(dropDownMeniu);
        se.selectByVisibleText(action);
        wait.until(ExpectedConditions.visibilityOf(dropDownMeniu));
    }

    public void pressCalculateButton() {
        pressCalculateButton.click();
    }

    public void pressDropDown() {
        dropDownMeniu.click();
    }

    public String calculatorResult() {
        return outputCalculatorResult.getText();
    }
}
