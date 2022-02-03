package testData;

public enum PoetsNames {
    HafezIbhaim ("محمد حافظ إبراهيم"), KhalilMutran("خليل مطران"), Zalam_author("إبراهيم ناجي");




    private String value;

    PoetsNames(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
