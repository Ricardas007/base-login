package lt.basepage.framework.test;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ShopLogoutTest extends BaseTest {

    RegisterPage register;
    LoginPage login;
    LogoutPage logout;

    @ParameterizedTest(name = "Test {index} => email {2}, password {3}")
    @CsvFileSource(files = "src/main/resources/loginData.csv", numLinesToSkip = 1)
    public void userLogoutFromPage(ArgumentsAccessor arguments){


        String email = arguments.getString(2);
        String password = arguments.getString(3);

        register = new RegisterPage(driver);
        register.pressSignInButton();
        login = new LoginPage(driver);
        login.enterUserEmail(email);
        login.enterUserPassward(password);
        login.pressSignInButton();
        login.navigateToUserAccountPage();
        logout = new LogoutPage(driver);
        Assertions.assertTrue(login.isSignoutButtonVisible(), "Sign out button should be present when user is signed in");
        login.pressLogoutFromAccount();
        boolean isLogoutIsSuccessful = logout.isSinginButtonOnNavBarVisible();
        Assertions.assertTrue(isLogoutIsSuccessful, "Sign in button should be present after successful sign out");
        Assertions.assertFalse(login.isSignoutButtonVisible(), "Sign out button should be present when user is signed in");

    }

    @ParameterizedTest(name ="Test {index} => email {2}, password {3}")
    @CsvFileSource(files = "src/main/resources/loginData.csv", numLinesToSkip = 1)
    public void userLogoutFormPageSecondAttempt(ArgumentsAccessor arguments) {

        String email = arguments.getString(2);
        String password = arguments.getString(3);

        register.pressSignInButton();
        login.enterUserEmail(email);
        login.enterUserPassward(password);
        login.pressSignInButton();
        login.navigateToUserAccountPage();
        Assertions.assertTrue(login.isSignoutButtonVisible(),"Sign out button should be present when user is signed in");
        login.pressLogoutFromAccount();
        boolean isLogoutIsSuccessful = logout.isSinginButtonOnNavBarVisible();
        Assertions.assertTrue(isLogoutIsSuccessful, "Sign in button should be present after successful sign out");
        Assertions.assertFalse(login.isSignoutButtonVisible(),"Sign out button shouldn't be present when user try to log out for second time");
    }

}
