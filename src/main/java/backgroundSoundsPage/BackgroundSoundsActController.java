package backgroundSoundsPage;

import commonVerification.CommonVerification;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static commonVerification.CommonVerification.getCommonVerification;
import static driver.DriverFactory.getDriver;

public class BackgroundSoundsActController {


    private AndroidDriver driver = getDriver();


    public static By backgroundSoundsSection() {
        return By.id("com.nagwa.poems:id/lay_child");
    }

    public static By poetHintTitle() {
        return By.id("com.nagwa.poems:id/tv_about_poet");
    }

    public static By backgroundSoundLevelText() {
        return By.id("com.nagwa.poems:id/tv_sound_level");
    }

    public static By backgroundSoundSoundLevelBar() {
        return By.id("com.nagwa.poems:id/sb_sound_level");
    }


    public static By aboutPoemBottomSheet() {
        return By.id("com.nagwa.poems:id/design_bottom_sheet");
    }





    public static By backGroundBackBtn() {
        return By.id("com.nagwa.poems:id/img_back");
    }



    public  void clickOnBackGroundBackBtn() {
        driver.findElement(By.id("com.nagwa.poems:id/lay_child")).
                findElement(By.className("android.widget.RelativeLayout")).findElement(backGroundBackBtn()).click();
    }

    public  void changeBackgroundSoundSoundLevel(String changeValue) {
        driver.findElement(backgroundSoundSoundLevelBar()).sendKeys(changeValue);
    }

    public CommonVerification andThen()
    {
        return getCommonVerification();
    }

}
