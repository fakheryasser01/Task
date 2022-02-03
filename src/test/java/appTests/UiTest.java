package appTests;

import base.TestBase;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.config.Configuration;
import homePage.HomePage;
import org.testng.annotations.Test;
import searchPage.SearchPage;

import static homePage.HomePage.getHomePage;
import static searchPage.SearchPage.getSearchPage;
import static testData.PoemsCategoriesNames.*;

public class UiTest extends TestBase {

    HomePage homePage = getHomePage();
    SearchPage searchPage =getSearchPage();
//    PoemPage  poemPage = getPoemPage();
//    MoreOptionsPage moreOptionsPage = getMoreOptionsPage();
//    BackgroundSoundsPage backgroundSoundsPage = getBackgroundSoundsPage();

    @Test
    public void verifyHomePageUI() {
        try {

            eyes.open(driver, "HindawiQasaedTesthomeoooo", "Home" );

            eyes.checkWindow("HomePage.png");
            eyes.close();
        } finally {
            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();
        }

    }

//    @Test
//    public void verifyCategoryPageUI() {
//
//        try {
//            eyes.open(driver, "HindawiQasaedqa", "CategoryPoem");
//
//            homePage.act()
//                    .selectPoemsCategory(PoemCategory2);
//
//            eyes.checkWindow("PoemCategory.jpg");
//            eyes.close();
//        } finally {
//            // If the test was aborted before eyes.close was called, ends the test as aborted.
//            eyes.abortIfNotClosed();
//        }
//    }

//    @Test
//    public void verifySearchPageUI() throws InterruptedException {
//        try {   eyes.open(driver, "HindawiQasaedTestppppt", "SearchPage");
//
//        homePage.act()
//                .openSearch();
//
//        searchPage.act()
//                .hideKeyboard();
//        eyes.checkWindow("SearchPage.png");
//
//
//        eyes.close();
//    } finally {
//        // If the test was aborted before eyes.close was called, ends the test as aborted.
//        eyes.abortIfNotClosed();
//    }
//
//    }
//
//       @Test
//    public void verifyAboutPoemPageUI() throws InterruptedException {
//        eyes.open(driver, "HindawiQasaedAppp", "AboutPoemPage");
//
//        homePage.act()
//                .openPoem(PoemsName.I);
//       poemPage.act()
//               .andThen()
//               .waitUntilAppearanceOf(poemVerses());
//        poemPage.act()
//                .clickPoemMoreOptionsBTn();
//               moreOptionsPage.act()
//                       .clickOnAboutPoem();
//                eyes.checkWindow("AboutPoemPage.jpg");
//
//        eyes.close();
//
//    }

//
//    @Test
//    public void verifyopenPoemUI() throws InterruptedException {
//        eyes.open(driver, "HindawiQasaedAppli", "PoemDetailsPage");
//
//        homePage.act()
//                        .openPoem(PoemsName.I);
//                Thread.sleep(10000);
//                poemPage.act()
//                        .andThen()
//                        .waitUntilAppearanceOf(poemVerses());
//                eyes.checkWindow("PoemDetailsPage.jpg");
//
//        eyes.close();
//
//    }
//
//
//
//    @Test
//    public void verifyMoreOptionsUI() throws InterruptedException {
//        eyes.open(driver, "HindawiQasaedAppli", "MoreOptionDropdown");
//
//        homePage.act()
//                .openPoem(PoemsName.I);
//        Thread.sleep(5000);
//        poemPage.act()
//         .andThen()
//                .waitUntilAppearanceOf(poemVerses());
//        poemPage.act()
//                .clickPoemMoreOptionsBTn();
//        eyes.checkWindow("MoreOptionDropdown.jpg");
//
//        eyes.close();
//
//    }
//
//    @Test
//    public void verifyBackgroundSoundsPageUI() throws InterruptedException {
//        eyes.open(driver, "HindawiQasaedAppli", "BackgroundSounds");
//
//        homePage.act()
//                .openPoem(PoemsName.I);
//        Thread.sleep(5000);
//        poemPage.act()
//         .andThen()
//                .waitUntilAppearanceOf(poemVerses());
//        poemPage.act()
//                .clickPoemMoreOptionsBTn();
//        moreOptionsPage.act()
//                        .clickOnBackGroundSoundSectionText();
//                eyes.checkWindow("BackgroundSounds.jpg");
//               backgroundSoundsPage.act()
//                       .clickOnBackGroundBackBtn();
//
//        eyes.close();
//
//    }
//
//
//    @Test
//    public void verifyDarkModePagePageUI() throws InterruptedException {
//        eyes.open(driver, "HindawiQasaedAppli", "DarkModePage");
//
//        homePage.act()
//                .openPoem(PoemsName.I);
//        Thread.sleep(5000);
//        poemPage.act()
//         .andThen()
//                .waitUntilAppearanceOf(poemVerses());
//        poemPage.act()
//                .clickPoemMoreOptionsBTn();
//        moreOptionsPage.act()
//         .andThen()
//                        .waitUntilAppearanceOf(darkModeSwitchBtn());
//               moreOptionsPage.act()
//                       .clickOnDarkModeSwitchBtn();
//                eyes.checkWindow("DarkModePage.jpg");
//
//        eyes.close();
//
//    }
//
//
//
//   @Test
//    public void verifyAboutPoemPageUI() throws InterruptedException {
//        eyes.open(driver, "HindawiQasaedAppli", "AboutPoemPage");
//
//        homePage.act()
//                .openPoem(PoemsName.I);
//        Thread.sleep(5000);
//       poemPage.act()
//         .andThen()
//               .waitUntilAppearanceOf(poemVerses());
//        poemPage.act()
//                .clickPoemMoreOptionsBTn();
//               moreOptionsPage.act()
//                       .clickOnAboutPoem();
//                eyes.checkWindow("AboutPoemPage.jpg");
//
//        eyes.close();
//
//    }


}





