package poemDetails;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverFactory.getDriver;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class PoemGetController {

    private WebDriver driver = getDriver();


    public int getPoemLinesCount(){
        List<WebElement> BackgroundSounds = driver.findElements(By.xpath("//android.view.View[contains(@resource-id,'line')]"));

        assertTrue(BackgroundSounds.size() != 0, "List is empty, failed to collect Background Sounds");

        int count = (int) BackgroundSounds.stream().count();

        System.out.println(count);

        return count;
    }

    public  String getAudioCounterTime() {

        System.out.println(driver.findElement(By.id("com.nagwa.poems:id/tv_audio_progress")).getText());
        return driver.findElement(By.id("com.nagwa.poems:id/tv_audio_progress")).getText();
    }


}
