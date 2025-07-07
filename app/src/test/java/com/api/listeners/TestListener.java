package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListener.class) ;

    // Implement methods from ITestListener interface as needed
    // For example, you can override onTestStart, onTestSuccess, onTestFailure, etc.

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("Test Suite started: " + context.getName());  
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("Test Suite finished: " + context.getName());  
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test Failed: " + result.getMethod().getMethodName());
    }

    // Add more methods as required by your testing framework       

}
