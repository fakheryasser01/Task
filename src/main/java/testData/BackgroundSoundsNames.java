package testData;

public enum BackgroundSoundsNames {
    BackgroundSound1 ("صوت ١") ,BackgroundSound2 ("صوت ٢"), BackgroundSound3 ("صوت ٣"),
    BackgroundSound4 (  "صوت ٤"), BackgroundSound5 ("صوت ٥"), BackgroundSound6 ("صوت ٦")
    ,BackgroundSound7 ("صوت ٧") ,BackgroundSound8 ("صوت ٨"), BackgroundSound9 ("صوت ٩"),
    BackgroundSound10 (  "صوت ١٠"), WithOutBackgroundSound ("بدون صوت");

    private String value;

    BackgroundSoundsNames(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

