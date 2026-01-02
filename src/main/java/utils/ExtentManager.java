package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
        // prevent instantiation
    }

    public static synchronized ExtentReports getExtent(Class<?> testClass) {

        if (extent == null) {

            String className = testClass.getSimpleName();
            String reportPath = ReportPathUtil.getReportPath(className);

            // Ensure base directory exists (only extent-reports)
            new File(reportPath).getParentFile().mkdirs();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName(className + " Automation Results");
            spark.config().setDocumentTitle("Extent Report - " + className);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
            extent = null;
        }
    }
}
