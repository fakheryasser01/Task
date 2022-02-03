package testData;

public enum PoemsCategoriesNames {
    PoemCategory1 ("كل العصور ١٤٣") ,PoemCategory2 ("الجاهلي ٥"), PoemCategory3 ("صدر الإسلام ٥"),
    PoemCategory4 (  "الأموي ٥"), PoemCategory5 ("العباسي الأول ٥"), PoemCategory6 ("العباسي الثاني ٥");

    private String value;

    PoemsCategoriesNames(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

