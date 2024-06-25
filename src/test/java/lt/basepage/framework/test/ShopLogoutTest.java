package lt.basepage.framework.test;

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
    public void userLogoutFromPage(ArgumentsAccessor arguments) throws InterruptedException {


        String email = arguments.getString(2);
        String password = arguments.getString(3);

        register = new RegisterPage(driver);
        register.pressSignInButton();
        login = new LoginPage(driver);
        login.enterUserEmail(email);
        login.enterUserPassward(password);
        login.pressSignInButton();
        login.navigateToUserAccountPage();
//        login.isSignoutButtonPresent();
        Assertions.assertTrue(login.isSignoutButtonVisible(), "Sign out button should be present when user is signed in");
        login.pressLogoutFromAccount();
        logout.isSinginButtonOnNavBarVisible();
        Assertions.assertTrue(logout.isSinginButtonOnNavBarVisible(), "Signin button should be present after succsessful signout");
        Thread.sleep(2000);

    }
}
