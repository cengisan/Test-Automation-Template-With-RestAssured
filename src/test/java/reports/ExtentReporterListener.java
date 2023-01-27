package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

import static reports.annotations.Link.LinkProcessor.testLink;

public class ExtentReporterListener implements ITestListener {

    public static StringWriter writer;
    public static PrintStream captor;
    static Date date = new Date();
    static String fileName = "Extent_" + date.toString().replace(":","_") + ".html";

    private static final ExtentReports extentReports = ExtentReporterManager.createInstance(System.getProperty("user.dir")+"\\test-output\\"+fileName);
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    public void onTestStart(ITestResult result){
        ExtentTest test = extentReports.createTest("TestCase : " + result.getMethod().getMethodName());
        writer = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writer),true);
        testReport.set(test);
    }
    public void onTestSuccess(ITestResult result){

        Markup test = MarkupHelper.createLabel(testLink(result), ExtentColor.TRANSPARENT);
        testReport.get().pass(test);

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);
    }
    public void onTestFailure(ITestResult result){
        Markup test = MarkupHelper.createLabel(testLink(result), ExtentColor.TRANSPARENT);
        testReport.get().log(Status.FAIL, test);

        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" +
                "Exception Occured: Click to see" + "</font>" + "</b>" + "</summary>" +
                exceptionMessage.replaceAll(",", "<br>") + "</details" + "\n");

        String failureLog = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
    }
    public void onTestSkipped(ITestResult result){
        Markup test = MarkupHelper.createLabel(testLink(result), ExtentColor.TRANSPARENT);
        testReport.get().skip(test);

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " SKIPPED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(m);
    }
    public void onStart(ITestContext context){

    }
    public void onFinish(ITestContext context){
        if(extentReports != null){
            extentReports.flush();
        }
    }
    public void logInfo(String detail){
        testReport.get().info(detail);
    }
    public void requestAndResponseReporter(String request, String response){
        logInfo("---- REQUEST ----");
        apiAndLogFormatInReport(request);
        logInfo("---- RESPONSE ----");
        apiAndLogFormatInReport(response);
    }
    public void apiAndLogFormatInReport(String content){
        String prettyPrint = content.replace("\n","<br>");
        logInfo("<pre>" + prettyPrint + "</pre>");
    }
}
