/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import Dominio.Chats;
import Dominio.Mensajes;
import Dominio.Usuarios;
import Interfaces.IChatsDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class ChatsDAO implements IChatsDAO {
        
    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    public ChatsDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Chats> getColeccion(){
        return this.baseDatos.getCollection("chats", Chats.class);
    }

    @Override
    public boolean agregar(Chats chat) {
        MongoCollection<Chats> coleccion = this.getColeccion();
        coleccion.insertOne(chat);
        return true;
    }

    @Override
    public List<Chats> consultarChats(String nombreUsuario) {
        MongoCollection<Chats> coleccion = this.getColeccion();
        List<Chats> listaChats = new LinkedList<>();
        coleccion.find( new Document("$or", Arrays.asList(new Document("creador.nombreUsuario", nombreUsuario), new Document("invitado.nombreUsuario", nombreUsuario)))).into(listaChats);
        return listaChats;    
    }

    @Override
    public Chats consultarChat(ObjectId id) {
        MongoCollection<Chats> coleccion = this.getColeccion();
        List<Chats> listaChats = new LinkedList<>();
        coleccion.find(new Document("_id",id)).into(listaChats);
        return listaChats.get(0);
    }

    @Override
        public boolean agregarMensajeAChat(Mensajes mensaje, Chats chat) {
        MongoCollection<Chats> coleccion = this.getColeccion();
        List<Chats> chatActualizado = new LinkedList<>();

        
        Bson operacionActualizar = new Document("$push",new Document("mensajes",new Document("$each",Arrays.asList(mensaje))));
        coleccion.updateOne(new Document().append("_id", chat.getId()), operacionActualizar);       
        coleccion.find(new Document().append("_id", chat.getId())).into(chatActualizado);
        return true;
    }

    @Override
    public List<Chats> cargarMensajes(Chats chat) {
        MongoCollection<Chats> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document("$match",new Document().append("_id", chat.getId())));
        
        etapas.add(new Document("$project", new Document().append("_id", 0).append("mensajes.usuarioEmisor",1).append("mensajes.textoMensaje", 1).append("mensajes.fechaMensaje", 1)));
        
        List<Chats> chats = new LinkedList<>();
//        List<String> mensajes = new LinkedList<>();
        
        coleccion.aggregate(etapas).into(chats);
//        for (int i = 0; i < chats.size(); i++) {
//            mensajes.add(chats.get(i).getMensajes().get(i).getUsuarioEmisor()+": "+chats.get(i).getMensajes().get(i).getTextoMensaje()+"\n");
//            System.out.println(mensajes);
//        }
        
        
        return chats;
    }





    
}
