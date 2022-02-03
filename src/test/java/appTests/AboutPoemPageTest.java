package appTests;

import aboutPoemPage.AboutPoemPage;
import base.TestBase;
import homePage.HomePage;
import moreOptionsPage.MoreOptionsPage;
import org.testng.annotations.Test;
import poemDetails.PoemPage;

import static aboutPoemPage.AboutPoemActController.*;
import static aboutPoemPage.AboutPoemPage.getAboutPoemPage;
import static homePage.HomeActController.appTitleText;
import static homePage.HomePage.getHomePage;
import static moreOptionsPage.MoreOptionsActController.*;
import static moreOptionsPage.MoreOptionsPage.getMoreOptionsPage;
import static poemDetails.PoemActController.poemTitle;
import static poemDetails.PoemActController.poemVerses;
import static poemDetails.PoemPage.getPoemPage;
import static testData.PoemsName.zlam;

public class AboutPoemPageTest extends TestBase {
    HomePage homePage = getHomePage();
    PoemPage poemPage = getPoemPage();
    MoreOptionsPage moreOptionsPage = getMoreOptionsPage();
    AboutPoemPage aboutPoemPage = getAboutPoemPage();

    @Test
    public void verifyAboutPoemOpensBottomSheetSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemVerses());

        poemPage.act()
                .clickPoemMoreOptionsBTn();

        moreOptionsPage.act()
                .clickOnAboutPoem();

        aboutPoemPage.act()
                .andThen()
                .verifyDisplayedOf(aboutPoemSection());
    }


    @Test
    public void verifyPoemHintSectionAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle());

        poemPage.act()
                .clickPoemMoreOptionsBTn();

        moreOptionsPage.act()
                .clickOnAboutPoem();

        aboutPoemPage.act()
                .andThen()
                .verifyDisplayedOf(poemHintTitle())
                .verifyElementTextEqual(poemHintTitle(), "عن القصيدة");
    }


    @Test
    public void verifyPoetHintSectionAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle());

        poemPage.act()
                .clickPoemMoreOptionsBTn();

        moreOptionsPage.act()
                .clickOnAboutPoem();

        aboutPoemPage.act()
                .andThen()
                .verifyDisplayedOf(poetHintTitle())
                .verifyElementTextEqual(poetHintTitle(), "عن الشاعر");
    }


    @Test
    public void verifyUserCanCloseAboutPoemSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle());

        poemPage.act()
                .clickPoemMoreOptionsBTn();

        moreOptionsPage.act()
                .clickOnAboutPoem();

        aboutPoemPage.act()
                .clickOutSideTheBottomSheet();

        Thread.sleep(5000);
        poemPage.act()
                .andThen()
                .verifyIsNotAppeared(aboutPoemBottomSheet());
    }


}
