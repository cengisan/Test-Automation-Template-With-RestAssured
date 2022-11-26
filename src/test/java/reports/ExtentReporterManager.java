package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;

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

