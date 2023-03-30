package org.example.domain;

public enum cm3 {
    A("125"),
    B("150"),
    C("250"),
    D("450"),
    E("600"),
    F("650"),
    G("780"),
    H("1000"),
    I("1350");

    public final String label;
    private cm3(String label){
        this.label = label;
    }

    public static cm3 valueOfLabel(String label){
        for(cm3 e : values()){
            if(e.label.equals(label)){
                return e;
            }
        }
        return null;
    }


}
