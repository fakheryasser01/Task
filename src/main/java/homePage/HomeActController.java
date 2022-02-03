package homePage;

import commonVerification.CommonVerification;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testData.PoemsCategoriesNames;
import testData.PoemsName;

import static commonVerification.CommonVerification.getCommonVerification;
import static driver.DriverFactory.getDriver;

public class HomeActController   {


    private AndroidDriver driver = getDriver();

    public static By appTitleText(){
        return By.xpath("//android.widget.TextView[@text='هنداوي قصائد']");
    }




    public static By searchIcon(){
        return By.id("com.nagwa.poems:id/imgSearch");
    }





    public static By poemsCategoriesList(){
        return By.id("com.nagwa.poems:id/tv_category_name");
    }

    public static By poemsNamesList(){
        return By.id("com.nagwa.poems:id/tv_poem_title");
    }

    public static By poetNamesList(){
        return By.id("com.nagwa.poems:id/tv_poem_author");
    }

    public static By poemsCategoriesSection(){
        return By.id("com.nagwa.poems:id/rv_category");
    }


    public static By firstPoemCard(){
        return By.xpath("//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
    }


    public static By splashScreenImg(){
        return By.className("android.widget.ImageView");
    }




    public HomeActController scrollToPoem( PoemsName poemName) {

        try {
            MobileElement elementToClick = (MobileElement) driver
                    .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                            + "new UiSelector().textContains(\"" + poemName + "\"));"));

        } catch (Exception e) {
            System.out.println("Failed to find " + poemName);
        }
        return  this;
    }

    public  HomeActController openPoem( PoemsName poem) {
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+poem+"']")).click();
        return this;
    }



    public HomeActController swipePoemCategories( PoemsCategoriesNames categoriesNames) {

        try {

            WebElement elementToClick = driver.findElement(MobileBy
                    .AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.nagwa.poems:id/rv_category\")).setAsHorizontalList.scrollIntoView("
                            + "new UiSelector().text(\""+categoriesNames+"\"));"));
            elementToClick.click();
        } catch (Exception e) {
            System.out.println("Failed to find " + categoriesNames);
        }
        return this;
    }




    public HomeActController selectPoemsCategory( PoemsCategoriesNames poemsCategoriesNames) {

        try {
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+poemsCategoriesNames+"']")).click();
        } catch (Exception e) {
            System.out.println("Failed to find " + poemsCategoriesNames);
        }
        return  this;
    }



    public HomeActController openSearch()
    {
        driver.findElement(searchIcon()).click();
        return this;
    }


    public CommonVerification andThen()
    {
        return getCommonVerification();
    }


}
