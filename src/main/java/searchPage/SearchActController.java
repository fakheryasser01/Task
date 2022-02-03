package searchPage;

import commonVerification.CommonVerification;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static commonVerification.CommonVerification.getCommonVerification;
import static driver.DriverFactory.getDriver;

public class SearchActController {


    private AndroidDriver driver = getDriver();


    public static By searchSection() {
        return By.id("com.nagwa.poems:id/lay_search");
    }

    public static By searchCancelBtn() {
        return By.id("com.nagwa.poems:id/tv_cancel");
    }

    public static By searchFieldTxt() {
        return By.id("android:id/search_src_text");
    }

    public static By searchIcon() {
        return By.id("com.nagwa.poems:id/iv_search_icon");
    }
    public static By noPoemLayout() {
        return By.id("com.nagwa.poems:id/lay_no_poems");
    }
    public static By noPoemText(){
        return By.xpath("//android.widget.TextView[@text='لا يوجد قصائد']");
    }


    public SearchActController setSearchTxt(String poemsName) {
        driver.findElement(searchFieldTxt()).sendKeys(poemsName);
        return this;
    }

    public SearchActController clickOnCancelSearchBTn() {
        driver.findElement(searchCancelBtn()).click();
        return this;
    }



    public SearchActController hideKeyboard() {
        driver.hideKeyboard();
        return this;
    }


    public boolean isKeyboardShown() {

        return driver.isKeyboardShown();
    }

    public CommonVerification andThen()
    {
        return getCommonVerification();
    }


}