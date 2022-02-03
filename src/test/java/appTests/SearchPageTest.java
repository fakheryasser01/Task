package appTests;

import base.TestBase;
import commonVerification.CommonVerification;
import homePage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import poemDetails.PoemPage;
import searchPage.SearchActController;
import searchPage.SearchPage;
import sun.awt.windows.ThemeReader;
import testData.PoemsName;

import java.util.List;

import static homePage.HomeActController.*;
import static homePage.HomePage.getHomePage;
import static org.assertj.core.api.Assertions.assertThat;
import static poemDetails.PoemActController.poemTitle;
import static poemDetails.PoemPage.getPoemPage;
import static searchPage.SearchActController.*;
import static searchPage.SearchPage.getSearchPage;
import static testData.PoemsName.Dark;
import static testData.PoemsName.I;

public class SearchPageTest  extends TestBase {

    HomePage homePage = getHomePage();
    SearchPage searchPage = getSearchPage();
    PoemPage poemPage = getPoemPage();

    @Test
    public void verifySearchBtnWorksSuccessfully() {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
         .andThen()
                .verifyDisplayedOf(searchSection());

    }

    @Test
    public void verifySearchIconAppearsSuccessfully() {
        homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
         .andThen()
                .verifyDisplayedOf(SearchActController.searchIcon());

    }

    @Test
    public void verifySearchCancelAppearsSuccessfully() {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
         .andThen()
                .verifyDisplayedOf(searchCancelBtn())
                .verifyElementTextEqual(searchCancelBtn(),"إلغاء");

    }

    @Test
    public void verifySearchTextAppearsEmptyInOpeningSuccessfully() {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
         .andThen()
                .verifyDisplayedOf(searchFieldTxt())
                .verifyElementTextEqual(searchFieldTxt(),"بحث");
    }

    @Test
    public void verifyUserWriteInSearchFieldSuccessfully() {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
                .setSearchTxt("المساء");
        searchPage.act()
         .andThen()
                .verifyElementTextEqual(searchFieldTxt(),"المساء");



    }


    @Test
    public void verifySearchResultsRelatedToSearchWord() throws InterruptedException {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
                .setSearchTxt("المساء");
        Thread.sleep(5000);
        List<String> poemList = homePage.get().listOf(poemsNamesList());

        assertThat(poemList)
                .isSubsetOf(String.valueOf(Dark));
    }


    @Test
    public void verifyPoemOpeningFromSearchSuccessfully() throws InterruptedException {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
                .setSearchTxt("المساء")
                .andThen()
                .waitUntilFor(10);


        List<String> poemList = homePage.get().listOf(poemsNamesList());

        homePage.act()
                .openPoem(Dark)
         .andThen()
                .waitUntilFor(5)
                .waitUntilAppearanceOf(poemTitle())
                .verifyDisplayedOf(poemTitle());

    }



    @Test
    public void verifyNoPoemLayoutAppearsSuccessfully() throws InterruptedException {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
                .setSearchTxt("تست")
                .hideKeyboard()
                .andThen()
                .waitUntilFor(3);


        searchPage.act()
         .andThen()
                .verifyDisplayedOf(noPoemLayout())
                .verifyElementTextEqual(noPoemText(),"لا يوجد قصائد");

    }


    @Test
    public void verifyCancelSearchWorksSuccessfully()   {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
                .clickOnCancelSearchBTn();
 homePage.act()
                .andThen()
                .verifyDisplayedOf(appTitleText());

    }


    @Test
    public void verifyPoemCategoriseDisappearSuccessfully()   {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
         .andThen()
                .waitUntilAppearanceOf(firstPoemCard());

        Assert.assertTrue(searchPage.act()
         .andThen().verifyIsNotAppeared(poemsCategoriesSection()));
    }


    @Test
    public void verifyThatIsKeyboardAppearsWhenOpeningSearch() throws InterruptedException {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());

        homePage.act()
                .openSearch()
                .andThen()
                .waitUntilFor(2);
        Assert.assertTrue(searchPage.act().isKeyboardShown());
    }


    @Test
    public void verifyPoemCategoriseAppearAfterCloseSearchSuccessfully() throws InterruptedException {
 homePage.act()
                .andThen()
                .waitUntilAppearanceOf(appTitleText());
        homePage.act()
                .openSearch();
        searchPage.act()
         .andThen()
                .waitUntilAppearanceOf(firstPoemCard());
        searchPage.act()
                .clickOnCancelSearchBTn()
                .andThen()
                .waitUntilFor(3);
        Assert.assertTrue(homePage.act()
         .andThen().verifyIsAppeared(poemsCategoriesSection()));
    }
}
