package pila;

import java.util.Arrays;

public class PilaEstatica implements Pila<Integer>{
    private static final int AUMENTO_CAPACIDAD = 10;
    private Integer[] elementos;
    private int tamaño;

    
    public PilaEstatica(int capacidad){
        elementos = new Integer[capacidad];
        tamaño = 0;    
    }

    public PilaEstatica(){
        this(10); // llama al constructor anterior con 10 elems
        tamaño = 0;
    }


    
    public Integer tope() {
     if (esVacia()){
        throw new RuntimeException("Pila vacía");
     }
     return elementos[tamaño-1];
    }

    public void apilar(Integer elem) {
        if (estaLLena()){
            elementos = Arrays.copyOf(elementos, tamaño + AUMENTO_CAPACIDAD);    
        }
        // var++ asigna y luego incrementa
        // ++var al revés que lo anterior
        elementos[tamaño++] = elem; 
    }

    private boolean estaLLena() {
        return tamaño == elementos.length;
    }

    public Integer desapilar() {
        Integer tope = tope();
        tamaño--;

        if (tamaño < elementos.length / 2){
            elementos = Arrays.copyOf(elementos, tamaño + AUMENTO_CAPACIDAD);            
        }


        return tope;
    }

    public boolean esVacia() {
        return tamaño == 0;
    }

    public String toString(){
        String s = "";
        for (int i=0; i < tamaño; i++){
            s += elementos[i] + " ";
        }
        return s;

    }
}
