/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;


import java.io.*;
import java.util.*;

//import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelly Pam
 */
public class JavaApplication18 {
    static String muestras[];
    static List <String> al = new ArrayList<String>();
    static String arrDesordenado[];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        int op;
        do{
        op = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1.Generar Numeros \n"
                +"2.Ordenar Numeros \n"));
        
        switch(op){
        
            case 1:
                try (FileWriter fichero = new FileWriter ("D:\\MI UMG\\programas/fichero.txt")) {
                int i=-10000000;
                int f=10000000;
                int n=1000000;
                //int n=100;
                for(int r=0; r<=n; r++){
                    Random aleatorio = new Random();
                    int x=aleatorio.nextInt(f - i+1) +i;
 //fichero.write("Fila "+r+"->"+x+"\n");
                   fichero.write(+x+"\n");   
                    }
                }
               break;
            
            case 2:
                try{
            File archivo = new File("D:\\MI UMG\\programas/fichero.txt");
            
            BufferedReader lectura = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            
            
            String leerLinea = lectura.readLine();
            
            
            while(leerLinea != null){
                //ArrayList que está recibiendo los valores de leerLinea
                al.add(leerLinea);
                
                leerLinea = lectura.readLine();
                
            }
            
            arrDesordenado = al.toArray(new String[al.size()]);
            
            Arrays.sort(arrDesordenado);
            
            try (FileWriter fichero2 = new FileWriter ("D:\\MI UMG\\programas/ficheroordenado.txt");) {
                   fichero2.write("Numeros Ordenados de manera ascendente \n\n");
           fichero2.write( Arrays.toString(arrDesordenado)+"\n");}
            
            //|1JOptionPane.showMessageDialog(null, "Los valores proporcionados por la muestra son:\n\n" + Arrays.toString(arrDesordenado));
        }catch(FileNotFoundException e){
            // Cuidado los espacios
            System.out.println("El Archivo solicitado no ha sido encontrado: " + e.getMessage());
        }catch(IOException IOe){
            System.out.println("El Archivo solicitado no se pudo abrir o cerrar" + IOe.getMessage());
        }
                break;
               
               
        }
        }while(op>0 && op<=3);
        
    }
}
