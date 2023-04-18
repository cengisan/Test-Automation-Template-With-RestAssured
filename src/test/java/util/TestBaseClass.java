package util;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.io.PrintStream;
import java.io.StringWriter;

import static reporter.ExtentReporterListener.*;

public class TestBaseClass {

    public static StringWriter writer;
    public static PrintStream captor;

    @BeforeMethod
    public void logSetup(ITestResult result) {
        ExtentTest test = extentReports.createTest("TestCase : " + result.getMethod().getMethodName());
        writer = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writer), true);
        testReport.set(test);
    }
}
