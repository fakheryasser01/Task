package poemDetails;

import commonVerification.CommonVerification;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static commonVerification.CommonVerification.getCommonVerification;
import static driver.DriverFactory.getDriver;

public class PoemActController {


    private AndroidDriver driver = getDriver();


    public static By poemTitle() {
        return By.id("com.nagwa.poems:id/tv_toolbar_title");
    }

    public static By poemDetailsBackBtn() {
        return By.id("com.nagwa.poems:id/img_back");
    }
    public static By poetName() {
        return By.id("com.nagwa.poems:id/tv_poem_author");
    }
    public static By poemShareBtn() {
        return By.id("com.nagwa.poems:id/img_share");
    }
    public static By poemMoreOptionsBtn() {
        return By.id("com.nagwa.poems:id/img_more");
    }
    public static By playPoemBtn() {
        return By.id("com.nagwa.poems:id/lay_play_pause");
    }
    public static By audioTimeCounter() {
        return By.id("com.nagwa.poems:id/tv_audio_progress");
    }
    public static By audioRemainingTime() {
        return By.id("com.nagwa.poems:id/tv_audio_remainig");
    }
    public static By waveForm() {
        return By.xpath("//android.view.View[@resource-id='waveform']");
    }
    public static By shareOptionTitle() {
        return By.id("android:id/title");
    }
    public static By shareOptionsList() {
        return By.id("android:id/resolver_list");
    }

    public static By poemVerses() {
        return By.xpath("//android.view.View[contains(@resource-id,'line')]");
    }





    public PoemActController clickPlayPausePoemBtn() {
        driver.findElement(playPoemBtn()).click();
        return this;
    }

    public void clickOnBackBTn() {
        driver.findElement(poemDetailsBackBtn()).click();
    }

    public void clickPoemShareBTn() {
        driver.findElement(poemShareBtn()).click();
    }

    public void clickPoemMoreOptionsBTn() {
        driver.findElement(poemMoreOptionsBtn()).click();
    }

    public CommonVerification andThen()
    {
        return getCommonVerification();
    }

}
