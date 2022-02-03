package testData;

public enum PoemsName {
    I ("أَنَا"), Dark("الْمَسَاء") , Farods("فِرْدَوْسِي") ,  SadrElIslam ("لَقَدْ غَدَوْتُ أَمَامَ الْقَوْمِ مُنْتَطِقًا"),zlam ("ظَلَام");




    private String value;

    PoemsName(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
