import java.util.*;

public class Main {
    public static void main(String[] args) throws ValidationException {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list1 = new Vector<>();
//        List<Integer> list3 = new LinkedList<>();
//        Stack<Integer> st = new Stack<>(Integer.class);
//        st.push((int) 'a');
//        st.push((int) 'b');
//
//        Stack.copiaza(new Integer[]{4,5,6}, st);
//        System.out.println(st.peek());
//
//
//        !!!Exemple sortare si Comaparator intr-o clasa anonima!!!
//
//        TreeSet<Persoana> pSet = new TreeSet<>(new Comparator<Persoana>() {
//            @Override
//            public int compare(Persoana o1, Persoana o2) {
//                return o1.getNume().compareTo(o2.getNume());
//            }
//        });
//        pSet.add(new Persoana("Dan", 18));
//        pSet.add(new Persoana("Ana", 18));
//        pSet.add(new Persoana("Ion", 18));
//
//        for(Persoana p : pSet){
//            System.out.println(p.getNume());
//        }
//
//        Map<Integer, Persoana> map = new LinkedHashMap<>();
//        map.put(1, new Persoana("dan", 30));
//        map.put(2, new Persoana("ana", 89));
//        map.put(3, new Persoana("ion", 32));
//
//        for (Integer key: map.keySet()){
//            System.out.println(map.get(key));
//        }
//
//        for(Map.Entry<Integer, Persoana> entry : map.entrySet()){
//            System.out.println(entry.getValue());
//        }
//
//        Exemplu exceptie proprie
//        Persoana p = new Persoana("", -2);
//        ValidatorPersoana val = new ValidatorPersoana();
//        try{
//            val.validate(p);
//        }
//        catch (ValidationException ve){
//            System.out.println(ve.getMessage());
//        }
//
//        AritmeticExpresion patratBinom = new AritmeticExpresion() {
//            @Override
//            public double calculate(double a, double b) {
//                return patratBinom(a,b);
//            }
//        };
//
//
//        double a = 2.1, b = 2.2;
//
//        FormulaHelper helper = new FormulaHelper(a,b);
//        AritmeticExpresion dist = helper::distanta;
//
//
//        double res = patratBinom.calculate(a, b);
//
//        System.out.format("(%.2f+%.2f)^2=%.2f", a, b, dist.calculate(a,b));

        Formula f1 = (double x, double y) -> {return x+y;};
        Formula f2 = (x, y) -> {return x + y;};
        Formula f3 = (x, y) -> x + y;
        Formula f4 = (double x, double y) -> {return x-y+y+y+y;};

        StringPrinter sp1 = (a, b, c) -> {return "Asta e primul: " + a + "\nAsta e al doilea: " + b + "\nAsta e al treilea: " + c;};

        String x = "Eu sunt Primul", y = "Eu sunt al Doilea", z = "Eu sunt al Treilea";
        System.out.println(sp1.stringConvertor(x,y,z));

        double c = 2.1, d = 2.2;

        System.out.format("%.2f\n", f1.calculate(c, d));
        System.out.format("%.2f\n", f2.calculate(c, d));
        System.out.format("%.2f\n", f3.calculate(c, d));
        System.out.format("%.2f\n", f4.calculate(c, d));



    }
}