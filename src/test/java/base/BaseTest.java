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
            DriverFactory.getDriver().get("https://backoffice-w6-qa.immflyretail.link/#/");

        }

        @AfterMethod
        public void tearDown() {
            DriverFactory.quitDriver();
        }
    }



