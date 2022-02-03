package appTests;

import backgroundSoundsPage.BackgroundSoundsPage;
import base.TestBase;
import homePage.HomePage;
import moreOptionsPage.MoreOptionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import poemDetails.PoemPage;

import java.util.List;

import static backgroundSoundsPage.BackgroundSoundsActController.*;
import static backgroundSoundsPage.BackgroundSoundsPage.getBackgroundSoundsPage;
import static homePage.HomeActController.appTitleText;
import static homePage.HomePage.getHomePage;
import static moreOptionsPage.MoreOptionsActController.moreOptionsDropDown;
import static moreOptionsPage.MoreOptionsPage.getMoreOptionsPage;
import static org.assertj.core.api.Assertions.assertThat;
import static poemDetails.PoemActController.poemTitle;
import static poemDetails.PoemPage.getPoemPage;
import static testData.BackgroundSoundsNames.*;
import static testData.PoemsName.zlam;

public class BackgroundSoundsPageTest extends TestBase {

    HomePage homePage = getHomePage();
    PoemPage poemPage = getPoemPage();
    MoreOptionsPage moreOptionsPage = getMoreOptionsPage();
    BackgroundSoundsPage backgroundSoundsPage = getBackgroundSoundsPage();

    @Test
    public void verifyTextOpensBackgroundSoundsSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionText();

        backgroundSoundsPage.act()
         .andThen()
                .verifyDisplayedOf(backgroundSoundsSection());
    }


    @Test
    public void verifyArrowOpensBackgroundSoundsSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        backgroundSoundsPage.act()
         .andThen()
                .verifyDisplayedOf(backgroundSoundsSection());
    }


    @Test
    public void verifyBackgroundSoundsTitleAppearsSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        backgroundSoundsPage.act()
         .andThen()
                .verifyDisplayedOf(backgroundSoundsSection());
    }


    @Test
    public void verifyBackgroundSoundsBackArrowWorksSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        backgroundSoundsPage.act()
                .clickOnBackGroundBackBtn();
        moreOptionsPage.act()
         .andThen()
                .verifyDisplayedOf(moreOptionsDropDown());

    }
    @Test
    public void verifyAllBackgroundSoundsBAppearsSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        Assert.assertEquals(backgroundSoundsPage.get().getListOfBackgroundSoundsCount(),11);


    }


    @Test
    public void verifyBackgroundSoundsAppearsInOrderSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        List<String> backgroundSounds = backgroundSoundsPage.get().getListOfBackgroundSoundsNames();

        assertThat(backgroundSounds)
                .containsExactly(String.valueOf(BackgroundSound1)
                        ,String.valueOf(BackgroundSound2)
                        ,String.valueOf(BackgroundSound3)
                        ,String.valueOf(BackgroundSound4)
                        ,String.valueOf(BackgroundSound5)
                        ,String.valueOf(BackgroundSound6)
                        ,String.valueOf(BackgroundSound7)
                        ,String.valueOf(BackgroundSound8)
                        ,String.valueOf(BackgroundSound9)
                        ,String.valueOf(BackgroundSound10)
                        ,String.valueOf(WithOutBackgroundSound)
                );

    }



    @Test
    public void verifyBackgroundSoundsLevelTextAppearsSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

       backgroundSoundsPage.act()
         .andThen()
               .verifyDisplayedOf(backgroundSoundLevelText());

    }


    @Test
    public void verifyBackgroundSoundsSeekBarAppearsSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        backgroundSoundsPage.act()
         .andThen()
                .verifyDisplayedOf(backgroundSoundSoundLevelBar());

    }


    @Test
    public void verifyUserCanIncreaseBackgroundSoundsLevelSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        backgroundSoundsPage.
                act()
                .changeBackgroundSoundSoundLevel("70.0");
        Assert.assertEquals(backgroundSoundsPage.get().getBackgroundSoundSoundLevel(),"70.0");

    }



    @Test
    public void verifyUserCanDecreaseBackgroundSoundsLevelSuccessfully()
    {
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
                .clickOnBackGroundSoundSectionArrow();

        backgroundSoundsPage.
                act()
                .changeBackgroundSoundSoundLevel("20.0");
        Assert.assertEquals(backgroundSoundsPage.get().getBackgroundSoundSoundLevel(),"20.0");

    }

}
