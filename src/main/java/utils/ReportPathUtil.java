package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportPathUtil {

    private ReportPathUtil() {
        // prevent instantiation
    }

    public static String getReportPath(String className) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        // Example:
        // target/extent-reports/LoginTest_2025-12-30_11-45-00.html
        return System.getProperty("user.dir")
                + "/target/extent-reports/"
                + className + "_" + timestamp
                + ".html";
    }
}
