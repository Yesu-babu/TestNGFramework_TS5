package tests;
import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void verifyTitleTest() {
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertNotNull(title);
    }

    @Test
    public void verifyLoginpage(){

    }
}
