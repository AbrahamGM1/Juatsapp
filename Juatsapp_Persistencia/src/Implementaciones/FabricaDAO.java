/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import Dominio.Chats;
import Dominio.Mensajes;
import Interfaces.IFachadaDAO;
import interfaces.IConexionBD;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class FabricaDAO {
    private IConexionBD conexion;
    static IFachadaDAO fachadaDAO = new FachadaDAO();
    
    public FabricaDAO(){
        this.conexion=new ConexionBD();
    }
    
    public ChatsDAO crearChatsDAO(){
        return new ChatsDAO(conexion);
    }
            
    public MensajesDAO crearMensajesDAO(){
        return new MensajesDAO(conexion);
    }
    
    public UsuariosDAO crearUsuariosDAO(){
        return new UsuariosDAO(conexion);
    }
}
