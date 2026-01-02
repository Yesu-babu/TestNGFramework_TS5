package listeners;

import com.aventstack.extentreports.ExtentTest;

public class ReportLogger {

    private ReportLogger() {
        // prevent instantiation
    }

    private static ExtentTest getSafeTest() {
        return ExtentTestListener.getTest();
    }

    public static void step(String message) {
        ExtentTest test = getSafeTest();
        if (test != null) {
            test.info(message);
        }
    }

    public static void pass(String message) {
        ExtentTest test = getSafeTest();
        if (test != null) {
            test.pass(message);
        }
    }

    public static void fail(String message) {
        ExtentTest test = getSafeTest();
        if (test != null) {
            test.fail(message);
        }
    }
}
