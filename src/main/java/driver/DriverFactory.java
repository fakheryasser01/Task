package driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.applitools.eyes.appium.Eyes;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class DriverFactory {

    private static AndroidDriver driver;
    public static String packageName = "com.nagwa.poems";


    public  static DesiredCapabilities capabilities ;


    private DriverFactory() {

    }


    public static AndroidDriver<AndroidElement>  getDriver( )  {

        if (driver == null) {
             capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Android Emulator");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("autoGrantPermissions", true);

            // when close the app will not clear the user data
//            capabilities.setCapability("noReset", true);

            capabilities.setCapability("appPackage", packageName );
            // An activity name for the Android activity you want to run from your package.
            capabilities.setCapability("appActivity", "com.nagwa.poems.ui.splash.SplashActivity");




            /*      if (installApp)
            {
                File appDir = new File("src/apk");
                File app = new File(appDir, "version.apk");
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            }
            else {

            }
            */

                try {
                    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }





        }
        return driver;
    }


}
