public class Persoana {
    protected String nume;
    protected int varsta;

    public Persoana(){
        this("", 0);
    }

    public Persoana(String nume, int varsta){
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume(){
        return this.nume;
    }

    public int getVarsta(){
        return this.varsta;
    }

}
