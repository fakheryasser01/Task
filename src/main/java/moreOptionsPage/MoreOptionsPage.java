package moreOptionsPage;

public class MoreOptionsPage {

    private MoreOptionsActController act;
    private MoreOptionsVerifyController verify;

    public MoreOptionsActController act() {
        return act;
    }

    public MoreOptionsVerifyController verify(){
        return verify;
    }


    private MoreOptionsPage(MoreOptionsActController act , MoreOptionsVerifyController verify)
    {
        this.act =act;
        this.verify =verify;
    }



    public static MoreOptionsPage getMoreOptionsPage()
    {
        return new MoreOptionsPage( new MoreOptionsActController(),new MoreOptionsVerifyController());
    }


}
