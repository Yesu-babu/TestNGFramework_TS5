package base;
import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://example.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

