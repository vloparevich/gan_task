package com.gan.testplatfrom;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.gan.basepageplatform.CommonImpl.getStandardViewPort;

/**
 * @author vloparevich
 */
public class BTest {
    public static final String localPropertiesPath = System.getProperty("user.dir") + "/default.properties";
    public static WebDriver driver = null;
    public static Logger logger = null;
    private static String explorer;

    private String url;
    private FileInputStream f;
    protected static Properties prop;


    @BeforeSuite
    public void baseSetUp() throws IOException {
        prop = new Properties();
        f = new FileInputStream(localPropertiesPath);
        prop.load(f);
        url = prop.getProperty("basePageUrl");
        explorer = prop.getProperty("browser");

        if (driver == null) {
            this.driver = WebDriverFactory.getDriver(explorer.toLowerCase());
        }

        getStandardViewPort(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @BeforeClass
    public void beforeClassBaseSetUp() {
        logger = Logger.getLogger("GAN-->  ");
        logger.setLevel(Level.DEBUG);
        PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterSuite
    public void afterSuitePerformed() {
        driver.quit();
        driver = null;
    }
}

