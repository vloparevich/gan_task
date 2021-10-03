package com.gan.utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static com.gan.utils.Utility.getScreenshot;
import static com.gan.testplatform.BTest.logger;
import java.io.IOException;

/**
 * @author vloparevich
 */
public class Listeners implements ITestListener {

    private String shortTestName(ITestResult result) {
        String[] testName = result.getInstanceName().split("\\.");
        String shortTestName = testName[testName.length - 2] + "." + testName[testName.length - 1];
        return shortTestName;
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("\033[0;32mTest: " + shortTestName(iTestResult) + " is in progress\033[0m");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("\033[0;32m" + shortTestName(iTestResult) + " performed successfully!\033[0m");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("\033[0;32mTest Failed. Something should be verified! Screenshot is taken on test failure.\033[0m");
        try {
            getScreenshot(shortTestName(iTestResult), iTestResult.getName());
            logger.error("Assertion Failed: " + shortTestName(iTestResult) + "." + iTestResult.getName());
        } catch (IOException e) {
            System.out.println("Something went wrong. Screenshot has not been made on test Failure!");
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("\033[0;32mListener says that \033[0m" + shortTestName(iTestResult) + " was skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Test launched");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test Finished");
    }
}