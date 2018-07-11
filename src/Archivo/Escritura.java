/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JavierSL
 */
public class Escritura
{
    private static Escritura escritura;

    private Escritura()
    {
    }
    
    public static Escritura getInstance()
    {
        if(escritura == null)
            escritura = new Escritura();
        
        return escritura;
    }
    
    public void generarTxtBD(List<Map> lista, int ultimoFolio)
    {
        int n = ultimoFolio + 1;
        try
        {
            File file = new File("C://documentos/registrar.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            
            for (int i = 0; i < lista.size(); i++)
            {
                String linea = String.format("INSERT INTO activado(cantidad, folio, idRecargas, numero_id) VALUES (%s, 'MPH/%08d/2018', '111010', %s);", 
                    lista.get(i).get("cantidad"), n, lista.get(i).get("id"));
                fileWriter.write(linea + "\r\n");
                n++;
            }
            
            fileWriter.close();
            System.out.println("Archivo creado correctamente!");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
