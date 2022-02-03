package backgroundSoundsPage;

import homePage.HomeGetController;

public class BackgroundSoundsPage {

    private BackgroundSoundsActController act;
    private BackgroundSoundsVerifyController verify;
    private BackgroundSoundsGetController get;

    public BackgroundSoundsActController act() {
        return act;
    }

    public BackgroundSoundsVerifyController verify() {
        return verify;
    }
    public BackgroundSoundsGetController get() {
        return get;
    }


    private BackgroundSoundsPage(BackgroundSoundsActController act , BackgroundSoundsVerifyController verify ,BackgroundSoundsGetController get)
    {
        this.act =act;
        this.verify =verify;
        this.get =get;

    }



    public static BackgroundSoundsPage getBackgroundSoundsPage()
    {
        return new BackgroundSoundsPage( new BackgroundSoundsActController(),new BackgroundSoundsVerifyController() , new BackgroundSoundsGetController());
    }


}
