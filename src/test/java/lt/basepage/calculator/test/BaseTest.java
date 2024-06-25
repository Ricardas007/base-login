package lt.basepage.calculator.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/calculator");
        driver.manage().window().maximize();

    }

    @AfterEach
    public void tearsDown(){
        driver.quit();
    }
}
