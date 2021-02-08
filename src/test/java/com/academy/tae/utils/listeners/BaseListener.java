package com.academy.tae.utils.listeners;

import com.academy.tae.util.BaseLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Event Listener to the tests being performed, it allows to know the start, process and result of each test
 * @author juanpablo.vasquez
 */
public class BaseListener implements ITestListener {
    /**
     * Log the Start of the test to the .log file in logs/
     * @param result of the Test that was ran right before
     */
    @Override
    public void onTestStart(ITestResult result) {
        BaseLogger.getLogger().info("Starting test: " + result.getName());
    }

    /**
     * Log the Success of the test to the .log file in logs/
     * @param result of the Test that was ran right before
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        BaseLogger.getLogger().info("Test: " + result.getName() + ", was completed without problems.");
    }

    /**
     * Log the Failure of the test to the .log file in logs/
     * @param result of the test that was ran right before
     */
    @Override
    public void onTestFailure(ITestResult result) {
        BaseLogger.getLogger().fatal("Test: " + result.getName() + ", failed in its execution.");
        BaseLogger.getLogger().fatal("Cause: "+ result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseLogger.getLogger().warn("Test: " + result.getName() + ", skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
