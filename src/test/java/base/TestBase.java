package base;


import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.config.Configuration;
import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;

import static driver.DriverFactory.*;

public class TestBase {


    protected AndroidDriver<AndroidElement> driver;
    public static AppiumDriverLocalService service;
    private static BatchInfo batch;
    public static Eyes eyes = new Eyes();

    @BeforeClass
    public void setupClass() throws InterruptedException {
        stopServer();
        startServer();

                // Test suite configurations
        eyes.setApiKey("KerF5MEyotiJ27Wodnp4Tquisx2X7111A4VF7SHdVGHB0110");
        batch = new BatchInfo("HindawiQasaedApp");

        // Initialize driver and open or install app
        driver = getDriver();

        // Wait loading screen
        Thread.sleep(4000);
    }

    @BeforeMethod
    public void setupTestCase() {

        try {
//            eyes.setBatch(batch);
            driver.activateApp(DriverFactory.packageName);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDownTestCase() throws InterruptedException {
        try {

            driver.closeApp();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @AfterSuite
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }





    public AppiumDriverLocalService startServer() {
        //
        boolean flag = checkIfServerIsRunnning(4723);
        if (!flag) {

            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;

    }


    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void resetDriver() {
        capabilities.setCapability("noReset", false);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void waitUntil(AndroidDriver<AndroidElement> driver, By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
