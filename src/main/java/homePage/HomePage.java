package homePage;

import commonVerification.CommonVerification;

import static commonVerification.CommonVerification.getCommonVerification;

public class HomePage {

    private HomeActController act;
    private HomeVerifyController verify;
    private HomeGetController get;

    public HomeActController act() {
        return act;
    }

    public HomeVerifyController verify() {
        return verify;
    }

    public HomeGetController get() {
        return get;
    }

    private HomePage(HomeActController act , HomeVerifyController verify , HomeGetController get)
    {
        this.act =act;
        this.verify =verify;
        this.get =get;
    }

//    private HomePage()
//    {
//    }

    public static HomePage getHomePage()
    {
        return new HomePage( new HomeActController(),new HomeVerifyController() , new HomeGetController());
    }

    public CommonVerification andThen()
    {
        return getCommonVerification();
    }

}
