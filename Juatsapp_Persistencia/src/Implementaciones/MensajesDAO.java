/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import Dominio.Chats;
import Dominio.Mensajes;
import Dominio.Usuarios;
import Interfaces.IMensajesDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class MensajesDAO implements IMensajesDAO{
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    public MensajesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Mensajes> getColeccion(){
        return this.baseDatos.getCollection("mensajes", Mensajes.class);
    }

    @Override
    public List<Mensajes> cargarMensajes(ObjectId idChat) {
        MongoCollection<Mensajes> coleccion = this.getColeccion();
        List<Mensajes> mensajes = new LinkedList();
        coleccion.find(new Document().append("idChat", idChat)).into(mensajes);
        return mensajes;
    }

    @Override
    public boolean agregar(Mensajes mensaje) {
        MongoCollection<Mensajes> coleccion = this.getColeccion();
        coleccion.insertOne(mensaje);
        return true;
    }

    @Override
    public Mensajes consultarMensaje(Mensajes mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        @Override
    public boolean mensajeEnviadoPorEmisor(Chats chat, ObjectId mensajeId, ObjectId usuarioEmisor) {
        MongoCollection<Mensajes> coleccion = this.getColeccion();
        List<Mensajes> mensajesEncontrados = new LinkedList<>();/*Consultar el mensaje enviado, si hay algo devuelve true, si no hay nada devuelve false*/
        coleccion.find(new Document().append("_id", mensajeId).append("usuarioEmisor", usuarioEmisor)).into(mensajesEncontrados);
        
        try {
            if ((!(mensajesEncontrados.get(0).getId()==mensajeId)/*El mensaje enviado coincide con el usuario devuelve true, si no devuelve false*/) ) {
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
        return false;
        }
    }

}
