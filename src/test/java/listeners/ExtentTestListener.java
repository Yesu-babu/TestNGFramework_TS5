package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;

public class ExtentTestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extent;

    // ✅ FIXED: Correct getTest() method
    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void onTestStart(ITestResult result) {

        extent = ExtentManager.getExtent(
                result.getTestClass().getRealClass()
        );

        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName()
        );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
        test.remove(); // cleanup ThreadLocal
    }
}
