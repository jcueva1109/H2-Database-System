/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Jesus Cueva
 */
public class Archivo_Conexiones {
    
    public boolean leerFichero(String user, String password, String schema){
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            
            archivo = new File("cuentas.txt");
            
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            
            while((linea=br.readLine()) != null){
               
                if(linea.equals("user") && linea.equals("password")){
                    return true;
                }else{
                    return false;
                }
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
            try{
                if(null != fr){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
            
        }
        return false;
    }
    
    //Ocupo escribir el usuario, la password, y el schema
    public void escribirArchivo(String usuario, String password, String schema){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            
            fichero = new FileWriter("C:\\Users\\Jesus Cueva\\Documents\\NetBeansProjects\\Gestor_Base_Datos\\archivo.txt", true);
            pw = new PrintWriter(fichero);
            
            pw.println(usuario);
            pw.println(password);
            pw.println(schema);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
            try{
                if(null != fichero){
                    fichero.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
            
        }
        
    }
    
}
