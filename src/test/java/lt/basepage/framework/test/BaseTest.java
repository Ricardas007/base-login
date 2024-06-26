package lt.basepage.framework.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://192.168.0.37/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearsDown() {
            driver.quit();
    }
}
