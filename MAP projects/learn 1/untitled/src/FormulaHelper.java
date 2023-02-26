class FormulaHelper {
    private double a;
    private double b;

    public FormulaHelper(double a, double b){this.a = a; this.b = b;}

    public double distanta(double x, double y){
        return Math.sqrt(Math.pow(x-a,2) + Math.pow(y-b, 2));
    }

}
