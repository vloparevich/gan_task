package com.gan.utils;

import com.gan.testplatfrom.BTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * @author vloparevich
 */
public class Utility extends BTest {

    public static String timeStampLong() {
        DateFormat df = new SimpleDateFormat("MMMM/d/yyyy-HH.mm.ss.S");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        return reportDate;
    }

    public static String logPath(String testName) {
        return System.getProperty("user.dir") + "/ProjectLogsShots/" + testName + "/";
    }

    public static void getScreenshot(String testName, String methodName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(logPath(testName) + timeStampLong() + "-methodName-" + methodName + "-screenshot.png"));
    }
}