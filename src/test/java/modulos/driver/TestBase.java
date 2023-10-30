package modulos.driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestBase {
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public static void setExtent() {
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("report.html");
        extent.setSystemInfo("Host Name", "Sávio Dell");
        extent.setSystemInfo("User Name", "Automação Mobile APP");
        extent.setSystemInfo("Enviroment", "QA");
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public static void tearDown() {
        extent.flush();
    }
}