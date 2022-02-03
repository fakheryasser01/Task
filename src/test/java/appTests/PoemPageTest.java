package appTests;

import base.TestBase;
import homePage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import poemDetails.PoemPage;
import testData.PoetsNames;

import static homePage.HomeActController.appTitleText;
import static homePage.HomeActController.firstPoemCard;
import static homePage.HomePage.getHomePage;
import static org.assertj.core.api.Assertions.assertThat;
import static poemDetails.PoemActController.*;
import static poemDetails.PoemPage.getPoemPage;
import static testData.PoemsName.*;
import static testData.PoetsNames.*;

public class PoemPageTest extends TestBase {
    HomePage homePage = getHomePage();
    PoemPage poemPage = getPoemPage();

    @Test
    public void verifyBackFromPoemDetailsAppearsSuccessfully() {
        homePage.act()
                .scrollToPoem(Dark)
                .openPoem(Dark);
        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemVerses())
                .verifyDisplayedOf(poemDetailsBackBtn());
    }

    @Test
    public void verifyBackFromPoemDetailsWorksSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);
        poemPage.act()
                .andThen()
                    .waitUntilAppearanceOf(poemVerses());
        poemPage.act()
                .clickOnBackBTn();
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
    }

    @Test
    public void verifySharePoemAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);
        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .verifyDisplayedOf(poemShareBtn());
    }


    @Test
    public void verifyMoreOptionBtnAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .verifyDisplayedOf(poemMoreOptionsBtn());
    }


    @Test
    public void verifyPoemTitleAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemDetailsBackBtn())
                .verifyDisplayedOf(poemTitle());
    }

    @Test
    public void verifyPoetNameAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemDetailsBackBtn())
                .verifyDisplayedOf(poetName());
    }


    @Test
    public void verifyPoemTitleSameAsTheSelectedAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .openPoem(zlam);

          poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .verifyElementTextEqual(poemTitle(), zlam.toString());


    }


    @Test
    public void verifyPoetNameSameAsTheSelectedAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .verifyElementTextEqual(poetName(), Zalam_author.toString());
    }


    @Test
    public void verifyPlayPoemBtnAppearsSuccessfully() {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());



        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .verifyDisplayedOf(playPoemBtn());
    }


    @Test
    public void verifyAudioProgressTimeCounterAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(Dark);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemDetailsBackBtn())
                .verifyDisplayedOf(audioTimeCounter())
                .verifyElementTextEqual(audioTimeCounter(), "00:00");
    }


    @Test
    public void verifyAudioRemainingTimeCounterAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(I);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemDetailsBackBtn())
                .verifyDisplayedOf(audioRemainingTime());
    }


    @Test
    public void verifyAudioWaveFormAppearsSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .waitUntilAppearanceOf(waveForm())
                .verifyDisplayedOf(waveForm());
    }


    @Test
    public void verifyShareBtnOpenShareOptionsSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle());

        poemPage.act()
                .clickPoemShareBTn();
        Thread.sleep(5000);
        poemPage.act()
                .andThen()
                .verifyDisplayedOf(shareOptionTitle())
                .verifyDisplayedOf(shareOptionsList())
                .verifyElementTextEqual(shareOptionTitle(), "Share with");

    }


    @Test
    public void verifyPoemLinesAppearsSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .waitUntilFor(5);
        Assert.assertNotEquals(poemPage.get().getPoemLinesCount(), 0);


    }


    @Test
    public void verifyPlayPoemBtnWorksSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);
        Thread.sleep(4000);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemVerses());

        Thread.sleep(4000);

        poemPage.act()
                .clickPlayPausePoemBtn();

        Assert.assertNotEquals(poemPage.get().getAudioCounterTime(), "00:00");

    }


    @Test
    public void verifyPausePoemBtnWorksSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle());

        Thread.sleep(7000);
        poemPage.act()
                .clickPlayPausePoemBtn();

        Thread.sleep(5000);
        poemPage.act()
                .clickPlayPausePoemBtn();
        assertThat(poemPage.get().getAudioCounterTime()).isGreaterThan("00:00");

    }


    @Test
    public void verifyResumePoemBtnWorksSuccessfully() throws InterruptedException {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openPoem(zlam);

        poemPage.act()
                .andThen()
                .waitUntilAppearanceOf(poemTitle());

        Thread.sleep(7000);
        poemPage.act()
                .clickPlayPausePoemBtn();

        Thread.sleep(5000);
        poemPage.act()
                .clickPlayPausePoemBtn();
        String pauseTimeCounter = poemPage.get().getAudioCounterTime();

        poemPage.act()
                .clickPlayPausePoemBtn();

        Thread.sleep(5000);
        assertThat(poemPage.get().getAudioCounterTime()).isGreaterThan(pauseTimeCounter);

    }

}
