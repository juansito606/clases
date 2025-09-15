import java.util.Stack;

public class PilasColas{
    public static void main(String[]args ) {
        Stack<Integer> pila = new Stack<> ();


        pila.push(10);
        pila.push(20);
        pila.push(5);
        pila.push(9);
        pila.push(35);
        
        System.out.println ("El tamaño de la pila es:" + pila.size());
        System.out.println ("¿La pila esta vacia?" + pila.empty());
        System.out.println (pila);
        pila.pop();
        System.out.println (pila.pop());
        System.out.println (pila.peek());
        System.out.println (pila.search(9));
    }
}