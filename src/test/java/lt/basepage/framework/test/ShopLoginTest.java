package lt.basepage.framework.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;


public class ShopLoginTest extends BaseTest{

    RegisterPage register;
    LoginPage login;

    @ParameterizedTest(name = "Test {index} => email {2}, passward {3}")
    @CsvFileSource(files = "src/main/resources/loginData.csv", numLinesToSkip = 1)
    void userLoginToPage(ArgumentsAccessor arguments) {

        String email = arguments.getString(2);
        String password = arguments.getString(3);

        register = new RegisterPage(driver);
        register.pressSignInButton();
        login = new LoginPage(driver);
        login.enterUserEmail(email);
        login.enterUserPassward(password);
        login.pressSignInButton();
        login.navigateToUserAccountPage();
        login.isSignoutButtonVisible();
        Assertions.assertTrue(login.isSignoutButtonVisible(), "Logout bottom button must be present when user is logged");
        login.pressLogoutFromAccount();
    }

    @ParameterizedTest(name = "Test {index} => email {2}, passward {3}, expectedResult {4}")
    @CsvFileSource(files = "src/main/resources/negativeLogin.csv", numLinesToSkip = 1)
    void userLoginToPageWithWrongEmail(ArgumentsAccessor arguments) {

        String email = arguments.getString(2);
        String password = arguments.getString(3);
        String expectedResult = arguments.getString(4);

        register = new RegisterPage(driver);
        register.pressSignInButton();
        login = new LoginPage(driver);
        login.enterUserEmail(email);
        login.enterUserPassward(password);
        login.pressSignInButton();
        String alertText = login.isAlertMessageIsVisible();
        Assertions.assertEquals(expectedResult, alertText, "Entering wrong password or email you should get alert message: 'Authentication faild' ");
    }
}
