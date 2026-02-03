package dibimbing.core;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeTest
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
