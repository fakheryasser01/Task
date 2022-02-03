package homePage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverFactory.getDriver;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class HomeGetController {

    private WebDriver driver = getDriver();


    public List<String> listOf(By element){
        List<WebElement> poemsCategories = driver.findElements(element);

        assertTrue(poemsCategories.size() != 0, "List is empty, failed to collect poemsCategories");

        poemsCategories.stream()
                .map(WebElement::getText).
                forEach(s -> System.out.println(s));

        return poemsCategories.stream()
                .map(WebElement::getText)
                .collect(toList());
    }
}
