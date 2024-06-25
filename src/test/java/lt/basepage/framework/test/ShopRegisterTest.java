package lt.basepage.framework.test;



import lt.basepage.utils.Utils;
import org.junit.jupiter.api.Assertions ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;


public class ShopRegisterTest extends BaseTest {

    RegisterPage register;

    @Test
    void userRegistrationOnPage() throws InterruptedException {

        String firstName = Utils.generateFistName();
        String lastName = Utils.generateLastName();
        String email = Utils.generateEmail(firstName, lastName);
        String password = Utils.generatePassword();

        register = new RegisterPage(driver);
        register.pressSignInButton();
        register.pressNoAccountButton();
        register.pressGenderButton();
        register.enterFirstName(firstName);
        register.enterLastName(lastName);
        register.enterUserEmail(email);
        register.enterUserPassword(password);
        register.pressTermsAndConditionsButton();
        register.pressCustomerDataPrivacyButton();
        register.clickSaveButton();
//        Thread.sleep(2000);
        String expecterResult = firstName + " " + lastName;
        String accountUserName = register.accountOwnerName();
        Thread.sleep(3000);

        Assertions.assertEquals(expecterResult, accountUserName, "User name and account user name should match");
        System.out.printf("Generated Data -> Fist Name: %s, Last Name: %s, Email: %s, Password: %s %n" ,firstName, lastName, email, password);

        Utils.appendUserToCSV(firstName, lastName, email, password, expecterResult);
    }
    @ParameterizedTest(name = "Test {index} =>email {0}, password {1}, expectedResult {2}")
    @CsvFileSource(files = "src/main/resources/errorLoginData.csv", numLinesToSkip = 1)
    void userRegistrationOnPageWithWrongName(ArgumentsAccessor argument) {

        String firstName = argument.getString(0);
        String lastName = argument.getString(1);
        String email = argument.getString(2);
        String password = argument.getString(3);
        String expecterResult = argument.getString(4);

        register = new RegisterPage(driver);
        register.pressSignInButton();
        register.pressNoAccountButton();
        register.pressGenderButton();
        register.enterFirstName(firstName);
        register.enterLastName(lastName);
        register.enterUserEmail(email);
        register.enterUserPassword(password);
        register.pressTermsAndConditionsButton();
        register.pressCustomerDataPrivacyButton();
        register.clickSaveButton();
        String accountUserName = register.accountOwnerName();
        register.getAlertMessageText();
        String alertText = register.getAlertMessageText();
        System.out.println(alertText);
        Assertions.assertEquals(expecterResult, alertText, "Already registered email should not pass registration");
    }


}
