package aboutPoemPage;

public class AboutPoemPage {

    private AboutPoemActController act;
    private AboutPoemVerifyController verify;

    public AboutPoemActController act() {
        return act;
    }

    public AboutPoemVerifyController verify() {
        return verify;
    }


    private AboutPoemPage(AboutPoemActController act , AboutPoemVerifyController verify)
    {
        this.act =act;
        this.verify =verify;
    }



    public static AboutPoemPage getAboutPoemPage()
    {
        return new AboutPoemPage( new AboutPoemActController(),new AboutPoemVerifyController());
    }


}
