import java.lang.reflect.Array;

public class Stack<E> {
    E[] items;
    int vf = 0;

    public Stack(Class tip){
        items = (E[]) Array.newInstance(tip, 20);
    }

    public void push(E elem){
        items[vf] = elem;
        vf += 1;
    }

    public E peek(){
        if(vf > 0){
            return (E)items[vf-1];
        }
        else return null;
    }
    public static <T> void copiaza(T[] elems, Stack<T> st) {
        for (T e : elems) {
            st.push(e);
        }
    }
}
