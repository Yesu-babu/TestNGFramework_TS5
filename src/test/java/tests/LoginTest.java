package tests;
import base.BaseTest;
import driver.DriverFactory;
import listeners.ReportLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyTitleTest() {
        ReportLogger.step("Launching application");
        ReportLogger.step("Getting page title");
        Assert.assertEquals(DriverFactory.getDriver().getTitle(), "TS4");
        ReportLogger.pass("Title verified successfully");
    }


    }
