/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chequeonumeros;

import Archivo.Escritura;
import Archivo.Lectura;
import Herramienta.Cotejo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JavierSL
 */
public class ChequeoNumeros
{
    /* Hay qie introducir el csv del resultado de la consulta
    SELECT id, digitos, monto
    FROM numero
    WHERE id NOT IN (SELECT numero_id FROM activado);
    */
    
    public static void main(String[] args)
    {
        //Instancia LecturaArchivo
        Lectura lecturaArchivo = Lectura.getInstance();
        
        //Saca la lista de numeros inactivados
        List<Map> inactivos = lecturaArchivo.obtenerListaNumeros("C://documentos/inactivos.csv");
        
        //Saca la lista de los numeros registrados en xtreme
        List<String> activados = lecturaArchivo.obtenerListaNumeros("C://documentos/xtreme.csv", 4);
        
        //Coteja la lista
        List<Map> faltantes = Cotejo.getInstance().cotejarListas(inactivos, activados);
        System.out.println("Registros faltantes: " + faltantes.size());
        
        //Crea el archivo de faltantes
        Escritura.getInstance().generarTxtBD(faltantes, 86877);
    }
    
}
