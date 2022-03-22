package com.ley.favsitcomcharacters;

public class Singleton {

    private Sitcom selectedLandmark;
    private static Singleton singleton;

    private Singleton() {

    }

    public Sitcom getSelectedSitcom() {
        return selectedLandmark;
    }

    public void setChosenSitcom(Sitcom selectedSitcom) {
        this.selectedLandmark = selectedSitcom;
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;

    }

}
