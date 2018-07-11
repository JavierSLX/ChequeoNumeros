/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JavierSL
 */
public class Lectura
{
    private static Lectura lecturaArchivo;

    private Lectura()
    {
    }
    
    public static Lectura getInstance()
    {
        if(lecturaArchivo == null)
            lecturaArchivo = new Lectura();
        
        return lecturaArchivo;
    }
    
    public List<String> obtenerListaNumeros(String archivo, int saltos)
    {
        int n = 1;
        BufferedReader br;
        List<String> lista = new ArrayList<>();
        
        try
        {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(archivo), "ISO-8859-1");
            br = new BufferedReader(inputStreamReader);
            
            String linea;
            while((linea = br.readLine()) != null)
            {
                String arreglo[] = linea.split(",");
                
                linea = "";
                boolean chequeo;
                int posicion = saltos;
                do
                {
                    //Checa que la posicion no desborde el arreglo
                    if(posicion >= arreglo.length)
                    {
                        System.err.println("Error en el análisis. Linea " + n);
                        break;
                    }
                    
                    //Si es numero lo agrega a la lista, si no cambia de posicion
                    if(checarSiEsNumero(arreglo[posicion]))
                    {
                        lista.add(arreglo[posicion]);
                        n++;
                        chequeo = true;
                    }
                    else
                    {
                        posicion++;
                        chequeo = false;
                    }
                }while(!chequeo);
            }
            
            return lista;
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Map> obtenerListaNumeros(String archivo)
    {
        int n = 1;
        BufferedReader br;
        List<Map> lista = new ArrayList<>();
        
        try
        {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(archivo), "ISO-8859-1");
            br = new BufferedReader(inputStreamReader);
            
            String linea;
            while((linea = br.readLine()) != null)
            {
                String arreglo[] = linea.split(",");
                
                Map<String, String> map = new HashMap<>();
                map.put("id", arreglo[0]);
                map.put("numero", arreglo[1]);
                map.put("cantidad", arreglo[2]);
                    
                //Si es numero lo agrega a la lista, si no cambia de posicion
                if(checarSiEsNumero(arreglo[1]))
                {
                    lista.add(map);
                    n++;
                }
                else
                    System.err.println("Error en la linea: " + n);
            }
            
            return lista;
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    private boolean checarSiEsNumero(String numero)
    {
        numero = numero.replace(" ", "");
        if(numero.length() > 10)
            return false;
        
        for(int i = 0; i < numero.length(); i++)
            if(!Character.isDigit(numero.charAt(i)))
                return false;
        
        return true;
    }
}
