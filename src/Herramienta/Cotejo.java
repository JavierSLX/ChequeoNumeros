/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramienta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JavierSL
 */
public class Cotejo
{
    private static Cotejo cotejo;

    private Cotejo()
    {
    }
    
    public static Cotejo getInstance()
    {
        if(cotejo == null)
            cotejo = new Cotejo();
        
        return cotejo;
    }
    
    public List<Map> cotejarListas(List<Map> inactivos, List<String> activos)
    {
        List<Map> lista = new ArrayList<>();
        for(int i = 0; i < inactivos.size(); i++)
            if(activos.contains(inactivos.get(i).get("numero")))
                lista.add(inactivos.get(i));
        
        return lista;
    }
}
