/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Dominio.Usuarios;
import Implementaciones.ConexionBD;
import Implementaciones.UsuariosDAO;
import Interfaces.IUsuariosDAO;
import com.mongodb.client.MongoCollection;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Abraham
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IUsuariosDAO usuariosDAO = new UsuariosDAO(new ConexionBD());
        List<Usuarios> resultados = usuariosDAO.consultarTodos();
        resultados.forEach((resultado)->{
            System.out.println(resultado);
        });
        
    }
    
}
