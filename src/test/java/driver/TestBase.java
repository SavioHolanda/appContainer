package driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {
    private static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
            sparkReporter.config().setDocumentTitle("NHG APP");
            sparkReporter.config().setEncoding("utf-8");
            sparkReporter.config().setJS("js-string");
            sparkReporter.config().setReportName("NHG APP");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setTimeStampFormat("dd MMM yyyy HH:mm:ss");
            extent.setSystemInfo("Home", "Office");
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}