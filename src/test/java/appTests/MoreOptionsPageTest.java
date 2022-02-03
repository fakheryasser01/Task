package appTests;

import base.TestBase;
import homePage.HomePage;
import moreOptionsPage.MoreOptionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import poemDetails.PoemPage;

import static homePage.HomeActController.appTitleText;
import static homePage.HomePage.getHomePage;
import static moreOptionsPage.MoreOptionsActController.*;
import static moreOptionsPage.MoreOptionsPage.getMoreOptionsPage;
import static poemDetails.PoemActController.*;
import static poemDetails.PoemPage.getPoemPage;
import static testData.PoemsName.zlam;

public class MoreOptionsPageTest extends TestBase {

    HomePage homePage = getHomePage();
    PoemPage poemPage = getPoemPage();
    MoreOptionsPage moreOptionsPage = getMoreOptionsPage();

    @Test
    public void verifyShareBtnOpensShareOptionsSuccessfully() throws InterruptedException {
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
                .andThen()
                .verifyDisplayedOf(moreOptionsDropDown());

    }


    @Test
    public void verifyAboutPoemSectionAppearsSuccessfully() {
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
                .andThen()
                .verifyDisplayedOf(moreOptionsDropDown())
                .verifyElementTextEqual(aboutPoemSection(), "عن القصيدة");

    }


    @Test
    public void verifyBackGroundSoundSectionTextAppearsSuccessfully() {
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
                .andThen()
                .verifyDisplayedOf(moreOptionsDropDown())
                .verifyElementTextEqual(backGroundSoundSectionText(), "صوت الخلفية");

    }


    @Test
    public void verifyBackGroundSoundSectionArrowAppearsSuccessfully() {
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
                .andThen()
                .verifyDisplayedOf(moreOptionsDropDown())
                .verifyDisplayedOf(backGroundSoundSectionArrow());
    }


    @Test
    public void verifyDarKModeSectionTextAppearsSuccessfully() {
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
                .andThen()
                .verifyDisplayedOf(moreOptionsDropDown())
                .verifyElementTextEqual(darKModeSectionText(), "الوضع الداكن");

    }

    @Test
    public void verifyDarkModeSwitchBtnAppearsSuccessfully() {
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
                .andThen()
                .verifyDisplayedOf(moreOptionsDropDown())
                .verifyDisplayedOf(darkModeSwitchBtn());
    }

    @Test
    public void verifyUserCanOpenDarkModeSwitchBtnSuccessfully() {
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
                .clickOnDarkModeSwitchBtn();

        Assert.assertTrue(moreOptionsPage.act().DarkModeSwitchBtnState());

    }


    @Test
    public void verifyUserCanCloseDarkModeSwitchBtnSuccessfully() {
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
                .clickOnDarkModeSwitchBtn()
                .clickOnDarkModeSwitchBtn();

        Assert.assertFalse(moreOptionsPage.act().DarkModeSwitchBtnState());

    }


    @Test
    public void verifyDarkModeSwitchBtnIsTurnedOffByDefault() {
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

        Assert.assertFalse(moreOptionsPage.act().DarkModeSwitchBtnState());

    }
}
