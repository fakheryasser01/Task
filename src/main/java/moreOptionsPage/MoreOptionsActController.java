package moreOptionsPage;

import commonVerification.CommonVerification;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static commonVerification.CommonVerification.getCommonVerification;
import static driver.DriverFactory.getDriver;

public class MoreOptionsActController   {


    private AndroidDriver driver = getDriver();


    public static By aboutPoemSection() {
        return By.id("com.nagwa.poems:id/tv_about_poem");
    }

    public static By backGroundSoundSectionText() {
        return By.id("com.nagwa.poems:id/tv_background_sound");
    }

    public static By backGroundSoundSectionArrow() {
        return By.id("com.nagwa.poems:id/img_arrow");
    }

    public static By darKModeSectionText() {
        return By.id("com.nagwa.poems:id/tv_dark_mode");
    }


    public static By darkModeSwitchBtn() {
        return By.id("com.nagwa.poems:id/switch_dark_mode");
    }


    public static By moreOptionsDropDown() {
        return By.id("com.nagwa.poems:id/popup_menu");
    }







    public void clickOnAboutPoem() {
        driver.findElement(aboutPoemSection()).click();
    }

    public void clickOnBackGroundSoundSectionText() {
        driver.findElement(backGroundSoundSectionText()).click();
    }

    public void clickOnBackGroundSoundSectionArrow() {
        driver.findElement(backGroundSoundSectionArrow()).click();
    }


    public MoreOptionsActController clickOnDarkModeSwitchBtn() {
        driver.findElement(darkModeSwitchBtn()).click();

        return this;
    }


    public Boolean DarkModeSwitchBtnState() {
        System.out.println(driver.findElement(darkModeSwitchBtn()).getAttribute("checked"));
       if(driver.findElement(darkModeSwitchBtn()).getAttribute("checked").equals("true"))
       {
           return true;
       }
       else {
           return false;
       }
    }
    public CommonVerification andThen()
    {
        return getCommonVerification();
    }
}
