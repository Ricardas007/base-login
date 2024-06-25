package lt.basepage.calculator.test;

import lt.basepage.calculator.CalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CalculatorTest extends BaseTest {

    CalculatorPage count;

    @ParameterizedTest(name = "{0}Test{index} => firstNumber {1}, secondNumber {2}, action[3]")
    @CsvFileSource(files = "src/main/resources/calculatorParameters.csv", numLinesToSkip = 1)
    void simpleCalculations(ArgumentsAccessor arguments) {

        int number1 = arguments.getByte(1);
        int number2 = arguments.getByte(2);
        String action = arguments.getString(3);
        String expectedResult = arguments.getString(4);

         count = new CalculatorPage(driver);
         count.enterFirstNumber(number1);
         count.enterSecondNumber(number2);
         count.pressDropDown();
         count.performCountAction(action);
         count.pressCalculateButton();
         String result = count.calculatorResult();
         Assertions.assertEquals(expectedResult ,result,"Result should match expected result with result from calculator input" );


    }
}
