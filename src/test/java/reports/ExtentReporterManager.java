package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeTest;

public class ExtentReporterManager implements ITestNGListener {

    private static ExtentReports extentReports;

    @BeforeTest
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setReportName(fileName);
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("Automation Test Engineer", "Cengizhan Uzuner");

        return extentReports;
    }

}

