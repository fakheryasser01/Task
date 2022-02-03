package backgroundSoundsPage;


import com.beust.jcommander.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverFactory.getDriver;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class BackgroundSoundsGetController {

    private WebDriver driver = getDriver();


    public List<String> getListOfBackgroundSoundsNames(){
        List<WebElement> BackgroundSounds = driver.findElements(By.id("com.nagwa.poems:id/tv_sound_name"));

        assertTrue(BackgroundSounds.size() != 0, "List is empty, failed to collect Background Sounds");

        BackgroundSounds.stream()
                .map(WebElement::getText).
                forEach(s -> System.out.println(s));

        return BackgroundSounds.stream()
                .map(WebElement::getText)
                .collect(toList());
    }


    public int getListOfBackgroundSoundsCount(){
        List<WebElement> BackgroundSounds = driver.findElements(By.id("com.nagwa.poems:id/tv_sound_name"));

        assertTrue(BackgroundSounds.size() != 0, "List is empty, failed to collect Background Sounds");

        BackgroundSounds.stream()
                .map(WebElement::getText).
                forEach(s -> System.out.println(s));

        int count = (int) BackgroundSounds.stream().count();

        System.out.println(count);

        return count;
    }



    public  String getBackgroundSoundSoundLevel() {
        return driver.findElement(By.id("com.nagwa.poems:id/sb_sound_level")).getText();
    }

}
