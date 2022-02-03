package aboutPoemPage;

import commonVerification.CommonVerification;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static commonVerification.CommonVerification.getCommonVerification;
import static driver.DriverFactory.getDriver;

public class AboutPoemActController {


    private AndroidDriver driver = getDriver();


    public static By poemHintTitle() {
        return By.id("com.nagwa.poems:id/tv_about_poem");
    }

    public static By poetHintTitle() {
        return By.id("com.nagwa.poems:id/tv_about_poet");
    }


    public static By aboutPoemBottomSheet() {
        return By.id("com.nagwa.poems:id/design_bottom_sheet");
    }



    public void clickOutSideTheBottomSheet()
    {
        driver.findElement(By.id("com.nagwa.poems:id/coordinator")).click();
    }

    public CommonVerification andThen()
    {
        return getCommonVerification();
    }

}
