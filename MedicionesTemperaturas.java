import java.util.ArrayList;

/**
 * MedicionesTemperaturas representa una lista de mediciones de temperaturas
 * de una estación meteorológica. Las temperaturas están en grados centígrados
 * 
 * @author N. Aguirre 
 * @version 0.1
 */

import java.util.ArrayList;

public class MedicionesTemperaturas
{
    
    // lista de mediciones tomadas en la estacion meteorologica.
    private ArrayList<Float> mediciones;
    
    /**
     * Constructor de MedicionesTemperaturas. Crea la lista de mediciones vacía.
     */
    public MedicionesTemperaturas()
    {
        mediciones = new ArrayList<Float>();
    }
    
    /**
     * Agrega una nueva medicion de temperatura
     */
    public void agregarMedicion(float nuevaTemperatura) {
        if (nuevaTemperatura<-273.15){
            throw new IllegalArgumentException ("La temperatura no puede estar por debajo del cero absoluto");
        }
        mediciones.add(nuevaTemperatura);
    }
    
    /**
     * Imprime la lista de temperaturas/mediciones
     */
    public void imprimirTemperaturas()
    {
        System.out.println("Temperaturas Registradas:");
        for (Float temp: mediciones) {
            System.out.println(temp + "C");
        }
    }
    
    /**
     * Calcula el promedio de temperaturas. 
     * Precondicion: debe haber al menos una temperatura cargada para que el promedio tenga sentido.
     */
    public float promedioTemperaturas()
    {
        //assert mediciones.size() > 0: "debe haber al menos una temperatura cargada para calcular el promedio";
        if (mediciones.size()==0){
            throw new IllegalStateException ("La cantidad de mediciones debe ser mayor a 0 para esta operacion");
        }
        float suma = 0;
        for (Float temp: mediciones) {
            suma = suma + temp;
        }
        return suma / mediciones.size();
    }
    
    /**
     * Calcula cantidad de registros de temperaturas negativas (sub cero)
     */
    public float cantidadRegistrosSubCero() {
        int negativas = 0;
        for (Float temp: mediciones) {
            if (temp < 0) {
                negativas = negativas + 1;
            }
        }
        return negativas;
    }

    //Calcular temperaturas por encima de los 35 y por debajo de los -15
    
     public int temperaturaExtrema() {
        int Extremas = 0;
        for (Float temp: mediciones) {
            if (temp<-15 && temp>35){
                Extremas= Extremas + 1;
            }
        }
        return Extremas;
        }
        
    public int cantidadDeConsecutivas(){
        int consecutivas = 0;
        int cantConsecutivas=0;
        float previa = 0;
        for (Float temp: mediciones){
        if (temp.equals(previa)){
            consecutivas = consecutivas +1;
            previa = temp;
        }
        else { 
            previa = temp;
    }
    }
        cantConsecutivas= cantConsecutivas + consecutivas;
        return cantConsecutivas;
    }

    /**public int cantidadConsecutivas(){
        int cantConsecutivas=0;
        int consecutivas= consecutivas();
        cantConsecutivas = cantConsecutivas + consecutivas;
        return cantConsecutivas;/
    }*/
}
