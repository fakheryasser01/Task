package commonVerification;


import homePage.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static driver.DriverFactory.getDriver;
import static homePage.HomePage.getHomePage;

public   class  CommonVerification {

     AndroidDriver driver = getDriver();

    private CommonVerification() {
        // hide it
    }

    public static CommonVerification getCommonVerification() {
        return new CommonVerification();
    }






    public CommonVerification verifyDisplayedOf(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
        System.out.println(driver.findElement(element).getText());

        return this;
    }


    public Boolean verifyIsAppeared(By element) {

        if ( (driver.findElements(element)).size() > 0 ) {
            return true;
        }
        else{
            System.out.println("The" +element+ "isn't appeared");

            return false;
        }


    }
    public Boolean verifyIsNotAppeared(By element) {

        if ( (driver.findElements(element)).size() == 0 ) {
            return true;
        }
        else{
            System.out.println("The element is appeared");

           return false;
        }


    }

    public CommonVerification verifyIsNotDisplayed(By element) {
        Assert.assertFalse(driver.findElement(element).isDisplayed());

        return this;
    }

    public CommonVerification verifyTextContains(By element , String equalityText) {
        Assert.assertTrue(driver.findElement(element).getText().contains(equalityText),"The element is not appear");
        System.out.println(driver.findElement(element).getText());
        return this;
    }

    public CommonVerification verifyElementTextEqual(By element , String equalityText) {
        Assert.assertEquals(driver.findElement(element).getText(),equalityText ,"The element is not appear");
        System.out.println(driver.findElement(element).getText());
        return this;
    }

    public CommonVerification waitUntilAppearanceOf( By element)
    {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;

    }

    public CommonVerification waitUntilFor( int secound)
    {
        driver.manage().timeouts().implicitlyWait(secound, TimeUnit.SECONDS) ;

        return this;

    }

    public HomePage home()
    {
        return getHomePage();
    }
}