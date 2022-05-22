
package Funciones;

import java.io.*;
import java.util.*;

public class Archivos {

    /**
     * Lee de un archivo binario un objeto de tipo ArrayList de la clase 
     * persona
     * @param archivo String con el nombre del archivo a editar
     * @return ArrayList con los datos obtenidos
     */
    public static ArrayList<Object> leerObjetoBinario(String archivo){
        ObjectInputStream flujoEntrada = null;
        ArrayList<Object> personas = null;
        try{
            flujoEntrada = new ObjectInputStream(new FileInputStream(archivo));
            personas = (ArrayList<Object>) flujoEntrada.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }finally{
            if(flujoEntrada != null){
                try{
                    flujoEntrada.close();
                }catch(IOException e3){
                    System.out.println(e3.getMessage());
                }
            }
        }
        return personas;
    }
    
    /**
     * Guarda en un archivo binario un objeto de tipo ArrayList de la clase
     * Persona
     * @param personas ArrayList a Guardar
     * @param archivo String con el nombre del archivo
     */
    public static void guardarObjectoBinario(ArrayList<Object> personas, String archivo){
        ObjectOutputStream flujoSalida = null;
        try{
            flujoSalida = new ObjectOutputStream(new FileOutputStream(archivo));
            flujoSalida.writeObject(personas);
        }catch(IOException e2){
            System.out.println(e2.getMessage());
        }finally{
            if(flujoSalida != null){
                try{
                    flujoSalida.close();
                }catch(IOException e3){
                    System.out.println(e3.getMessage());
                }
            }
        }
    }
    
    public static ArrayList<String> leerTexto(String archivo){
        BufferedReader flujoEntrada = null;
        ArrayList<String> datos = new ArrayList<>();

        try{
            flujoEntrada = new BufferedReader(new FileReader(archivo));
            if(flujoEntrada.ready()){
                int indice = Integer.parseInt(flujoEntrada.readLine());
                for(int i=0; i < indice; i++){
                    datos.add(flujoEntrada.readLine());
                }
            }else{
                System.out.println("El fichero está vacio");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(flujoEntrada != null){
                try{
                    flujoEntrada.close();
                }catch(IOException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }
        return datos;
    }

    public static boolean guardarTexto(ArrayList<String> lista, String archivo){
        BufferedWriter flujoSalida = null;
        boolean guardado = false;
        try{
            flujoSalida = new BufferedWriter(new FileWriter(archivo));
            flujoSalida.write(lista.size());
            flujoSalida.newLine();
            for(int i=0; i < lista.size(); i++){
                flujoSalida.write(lista.get(i));
                flujoSalida.newLine();
            }
            guardado = true;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(flujoSalida != null){
                try{
                    flujoSalida.close();
                }catch(IOException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }

        return guardado;
    }

}
