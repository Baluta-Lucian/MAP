package com.example.genericexam.domain;

import java.util.Objects;

public class Final {
    private String numeStudent;
    private int punctajObtinut;
    private int punctajMaxim;

    public Final(String numeStudent, int punctajObtinut, int punctajMaxim) {
        this.numeStudent = numeStudent;
        this.punctajObtinut = punctajObtinut;
        this.punctajMaxim = punctajMaxim;
    }

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public int getPunctajObtinut() {
        return punctajObtinut;
    }

    public void setPunctajObtinut(int punctajObtinut) {
        this.punctajObtinut = punctajObtinut;
    }

    public int getPunctajMaxim() {
        return punctajMaxim;
    }

    public void setPunctajMaxim(int punctajMaxim) {
        this.punctajMaxim = punctajMaxim;
    }

    @Override
    public String toString() {
        return "Final{" +
                "numeStudent='" + numeStudent + '\'' +
                ", punctajObtinut=" + punctajObtinut +
                ", punctajMaxim=" + punctajMaxim +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Final aFinal = (Final) o;
        return punctajObtinut == aFinal.punctajObtinut && punctajMaxim == aFinal.punctajMaxim && Objects.equals(numeStudent, aFinal.numeStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeStudent, punctajObtinut, punctajMaxim);
    }


}
