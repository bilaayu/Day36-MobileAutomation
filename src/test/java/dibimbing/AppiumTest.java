package dibimbing;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class AppiumTest {
    private AndroidDriver driver;

    @BeforeClass
    public void initAppium() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5556")
                .setApp(System.getProperty("user.dir") + "/apk/demo.apk")
                .setAppPackage("com.saucelabs.mydemoapp.android")
                .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
                .setAppWaitActivity(
                        "com.saucelabs.mydemoapp.android.view.activities.SplashActivity," +
                                "com.saucelabs.mydemoapp.android.view.activities.MainActivity"
                )
                .setNoReset(false) // **START FRESH EVERY RUN**
                .setFullReset(false) // optional, jangan uninstall APK tiap run
                .setAutoGrantPermissions(true)
                .setNewCommandTimeout(Duration.ofSeconds(3600))
                .setAppWaitDuration(Duration.ofSeconds(30));

        try {
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver(appiumServerUrl, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            System.out.println("Appium server started successfully!");
            System.out.println("Current activity: " + driver.currentActivity()); // debug
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void simpleTest() {
        System.out.println("Creating session..");
        assert driver.getSessionId() != null;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Tunggu sampai MainActivity muncul dan element productIV ada
        WebElement product = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.id("com.saucelabs.mydemoapp.android:id/productIV")
                )
        );

        System.out.println("Main screen loaded, clicking product..");
        product.click();
        System.out.println("Product clicked successfully!");
    }

    @Test
    public void testClickByCoordinates() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 300, 843));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));
    }

    @Test
    public void testSwipe() {
        Dimension size = driver.manage().window().getSize();
        System.out.println("Screen size: " + size);
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            System.out.println("Appium server stopped successfully!");
        }
    }
}
