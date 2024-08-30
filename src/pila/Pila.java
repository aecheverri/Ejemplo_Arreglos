package pila;

public interface Pila<T> {
    T tope();
    void apilar(T elem);
    T desapilar();
    boolean esVacia();
    

}
