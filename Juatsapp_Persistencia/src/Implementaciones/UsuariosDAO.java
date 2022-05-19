
package Implementaciones;

import Dominio.Usuarios;
import Interfaces.IUsuariosDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
public class UsuariosDAO implements IUsuariosDAO{

    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    public UsuariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Usuarios> getColeccion(){
        return this.baseDatos.getCollection("usuarios", Usuarios.class);
    }
    
    
    @Override
    public boolean agregarUsuario(Usuarios usuario) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        coleccion.insertOne(usuario);
        return true;
    }

    @Override
    public List<Usuarios> consultarTodos() {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> listaUsuarios = new LinkedList<>();
        coleccion.find().into(listaUsuarios);
        return listaUsuarios;
    }

    @Override
    public Usuarios loguear(String nombreUsuario, String contraseña) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> usuario = new LinkedList<>();
        try{
        coleccion.find(new Document().append("nombreUsuario", nombreUsuario).append("contraseña", contraseña)).into(usuario);
            return usuario.get(0);
        }catch(Exception e){
            return null;
        }

        
    }

    @Override
    public Usuarios consultarPorNombreUsuario(String nombreUsuario) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> usuario = new LinkedList<>();
        try{
        coleccion.find(new Document().append("nombreUsuario", nombreUsuario)).into(usuario);
            return usuario.get(0);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public Usuarios actualizarUsuario(ObjectId id, String nombre, String nombreUsuario, String correo, String edad, String sexo, String contraseña) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> usuarioActualizado = new LinkedList<>();
                
        try{
                
          
        
        Bson valoresParaActualizar = new Document().append("nombre",nombre).append("nombreUsuario", nombreUsuario).append("correo", correo).append("edad", edad).append("sexo", sexo).append("contraseña", contraseña);
         
        Bson operacionActualizar = new Document("$set",valoresParaActualizar);
        coleccion.updateOne(new Document().append("_id", id), operacionActualizar);
        coleccion.find(new Document().append("_id", id)).into(usuarioActualizado);
        return usuarioActualizado.get(0);
        }catch(Exception e){
            return null;
        }

    }

    @Override
    public Usuarios consultarPorCorreo(String correo) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> usuario = new LinkedList<>();
        try{
        coleccion.find(new Document().append("correo", correo)).into(usuario);
            return usuario.get(0);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public Usuarios loguearPorCorreo(String correo, String contraseña) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> usuario = new LinkedList<>();
        try{
        coleccion.find(new Document().append("correo", correo).append("contraseña", contraseña)).into(usuario);
            return usuario.get(0);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public Usuarios consultarPorIdUsuario(ObjectId idUsuario) {
        MongoCollection<Usuarios> coleccion = this.getColeccion();
        List<Usuarios> usuario = new LinkedList<>();
        try{
        coleccion.find(new Document().append("_id", idUsuario)).into(usuario);
            return usuario.get(0);
        }catch(Exception e){
            return null;
        }    }


}
