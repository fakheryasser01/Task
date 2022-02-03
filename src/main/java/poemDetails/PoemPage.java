package poemDetails;

public class PoemPage {

    private PoemActController act;
    private PoemVerifyController verify;
    private PoemGetController get;

    public PoemActController act() {
        return act;
    }

    public PoemVerifyController verify()
    {
        return verify;
    }

    public PoemGetController get() {
        return get;
    }
    private PoemPage(PoemActController act , PoemVerifyController verify , PoemGetController get)
    {
        this.act =act;
        this.verify =verify;
        this.get = get;
    }



    public static PoemPage getPoemPage()
    {
        return new PoemPage( new PoemActController(),new PoemVerifyController() , new PoemGetController());
    }


}
