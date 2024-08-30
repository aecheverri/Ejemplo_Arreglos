package pila;
import java.util.ArrayList;
import java.util.List;

public class PilaDinamica<T> implements Pila<T> {
    // se pone List porque está bueno que sea lo más
    // abstracto posible para poder elegir otra implementación
    List<T> elementos = new ArrayList<>();

    public PilaDinamica(){
        elementos = new ArrayList<>();
    }

    @Override
    public T tope() {
        if (esVacia()){
            throw new RuntimeException("Pila vacía");
        }
        return elementos.get(elementos.size()-1);
    }

    @Override
    public void apilar(T elem) {
        elementos.add(elem);
    }

    @Override
    public T desapilar() {
        T tope = tope();
        elementos.remove(elementos.size()-1);
        return tope;
        
    }
    

    @Override
    public boolean esVacia() {
        return elementos.isEmpty();
    }



    public static void main(String[] args) {
        PilaDinamica<Integer> p = new PilaDinamica<>();
        // upper bounded wildcard: T o cualquier subtipo de T
        Pila<? extends Number> p2 = new PilaDinamica<Integer>();
        p2=p;

        // lower bounded wildcard: T o cualquier supertipo de T
        // Object, Number, Integer
        Pila <? super Integer> p3;
        Pila <Number> p4 = new PilaDinamica<>();
        p3=p4;

        //Unbounded wildcard: solo podemos "leer" de p5 si tratamos como Object
        Pila<?> p5;
    }

}
