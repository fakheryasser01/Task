package appTests;

import base.TestBase;
import commonVerification.CommonVerification;
import homePage.HomePage;
import org.testng.annotations.Test;
import poemDetails.PoemPage;
import java.util.List;

import static commonVerification.CommonVerification.getCommonVerification;
import static homePage.HomeActController.*;
import static homePage.HomePage.getHomePage;
import static org.assertj.core.api.Assertions.assertThat;
import static poemDetails.PoemActController.poemTitle;
import static poemDetails.PoemPage.getPoemPage;
import static testData.PoemsCategoriesNames.*;
import static testData.PoemsName.*;
import static testData.PoetsNames.*;


public class HomePageTest extends TestBase {
    HomePage homePage = getHomePage();
    PoemPage poemPage = getPoemPage();
    CommonVerification common = getCommonVerification();



    @Test
    public void verifySplashScreenAppearsSuccessfully() {
         common.verifyDisplayedOf(splashScreenImg());
    }


    @Test
    public void verifyHomePageOpensSuccessfully() {

        homePage.act()
                .andThen()
                .verifyDisplayedOf(splashScreenImg())
                .waitUntilAppearanceOf(appTitleText())
                .verifyDisplayedOf(searchIcon());



    }


    @Test
    public void verifyAppTitleAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(searchIcon())
                .verifyElementTextEqual(appTitleText(),"هنداوي قصائد")
        ;

    }


    @Test
    public void verifySearchIconAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText())
                .verifyDisplayedOf(searchIcon());
    }


    @Test
    public void verifyPoemsCategoriesSectionAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText())
                .verifyDisplayedOf(poemsCategoriesSection());
    }



    @Test
    public void verifyPoemsCategoriesAppearsInArabicSuccessfully() {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(poemsCategoriesList());

       List<String> poemCategories = homePage.get().listOf(poemsCategoriesList());

        assertThat(poemCategories)
                .contains(String.valueOf(PoemCategory1)
                        ,String.valueOf(PoemCategory2)
                        ,String.valueOf(PoemCategory3)
                        ,String.valueOf(PoemCategory4)
                        ,String.valueOf(PoemCategory5),
                        String.valueOf(PoemCategory6));
    }


    @Test
    public void  verifyPoemsCategoriesTabsAppearInOrderSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(poemsCategoriesList());
        List<String> poemCategories = homePage.get().listOf(poemsCategoriesList());

        assertThat(poemCategories)
                .containsExactly(String.valueOf(PoemCategory1)
                        ,String.valueOf(PoemCategory2)
                        ,String.valueOf(PoemCategory3)
                        ,String.valueOf(PoemCategory4)
                        ,String.valueOf(PoemCategory5)
                        ,String.valueOf(PoemCategory6)
                );
    }


    @Test
    public void  verifyPoemsTitlesAppearSuccessfully() {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(poemsCategoriesSection());

        List<String> poemList = homePage.get().listOf(poemsNamesList());

        assertThat(poemList)
                .contains(String.valueOf(I)
                        ,String.valueOf(Dark)
                );
    }


    @Test
    public void  verifyPoetsNamesAppearSuccessfully() {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(poemsCategoriesSection());

        List<String> poetsNameList = homePage.get().listOf(poetNamesList());

        assertThat(poetsNameList)
                .contains(String.valueOf(HafezIbhaim)
                        ,String.valueOf(KhalilMutran)
                );
    }


    @Test
    public void  verifyScrollingToPoemSuccessfully() {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(poemsCategoriesSection());

        homePage.act()
                .scrollToPoem(Farods);

        List<String> poemList = homePage.get().listOf(poemsNamesList());

        assertThat(poemList)
                .contains(String.valueOf(Farods));


    }


    @Test
    public void  verifyopenPoemFromHomePageSuccessfully() throws InterruptedException {

        homePage.act().andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .scrollToPoem(Farods)
                .openPoem(Farods)
                .andThen()
                .waitUntilAppearanceOf(poemTitle());
    }



    @Test
    public void  verifyPoemsCategoriesTabsAreClickableSuccessfully() throws InterruptedException {

 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .selectPoemsCategory(PoemCategory3)
                .andThen()
                .waitUntilAppearanceOf(firstPoemCard());

       List<String> poemsNameList = homePage.get().listOf(poemsNamesList());


        assertThat(poemsNameList)
                .hasSizeGreaterThan(0)
                .hasSizeBetween(0,7);
    }

    @Test
    public void  verifyLoadingThePoemsRelatedToPoemsCategoriesSuccessfully() throws InterruptedException {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .selectPoemsCategory(PoemCategory3)
                .andThen()
                .waitUntilAppearanceOf(firstPoemCard());

        List<String> poemsNameList = homePage.get().listOf(poemsNamesList());


        assertThat(poemsNameList)
                .contains(String.valueOf(SadrElIslam));
    }

    @Test
    public void  verifyOpenPoemFromCategoriesSuccessfully() throws InterruptedException {

        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .selectPoemsCategory(PoemCategory3)
                .andThen().waitUntilAppearanceOf(poemsNamesList());


        List<String> poemsNameList = homePage.get().listOf(poemsNamesList());

        assertThat(poemsNameList)
                .contains(String.valueOf(SadrElIslam));

        homePage.act()
                .openPoem(SadrElIslam)
                .andThen()
                .waitUntilAppearanceOf(poemTitle())
                .verifyDisplayedOf(poemTitle());
    }


}
