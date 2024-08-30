import java.util.HashMap;
import java.util.Map;

public class ArregloEnteros{
    public static void main(String[] args) throws Exception {
        int[] nros = {3,3,3,4,2};
        int resultado = encontrarValorMasFrecuente(nros);
        int valMayoritario = encontrarValorMayoritario(nros);  
        System.out.println("El valor más frecuente es: " + resultado);
        System.err.println("El valor mayoritario es: "+ valMayoritario);
    }

    private static int encontrarValorMayoritario(int[] nros) {
        int mayoritario = -1;
        int valMasfrecuente = encontrarValorMasFrecuente(nros);
        if ( cantidadApariciones(valMasfrecuente, nros) > 0.5 * nros.length){
            mayoritario = valMasfrecuente;
        }
        return mayoritario;     
    }

    private static double cantidadApariciones(int x, int[] nros) {
       int cantAp = 0;
            for (int nro : nros){
                cantAp = cantAp + (nro == x ? 1 :0);
            }
        return cantAp;
    }

    private static int encontrarValorMasFrecuente(int[] nros) {
        Map<Integer, Integer> frecuencia = new HashMap<>();
        
        int frecuenciaMax = 0;
        int nroMasFrecuente = nros[0]; 

        for(int num : nros){
            frecuencia.put(num, frecuencia.getOrDefault(num,0) + 1);

            if(frecuencia.get(num) > frecuenciaMax){
                frecuenciaMax = frecuencia.get(num);
                if (num != nroMasFrecuente){
                    nroMasFrecuente = num;
                }

            }
        }
        return nroMasFrecuente;
    }

}

