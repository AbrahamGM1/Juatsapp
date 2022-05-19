/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Dominio.Chats;
import Dominio.Mensajes;
import Dominio.Usuarios;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public interface IFachadaDAO {

    boolean agregarUsuario(Usuarios usuario);

    List<Usuarios> consultarTodos();

    Usuarios loguear(String nombreUsuario, String contraseña);

    Usuarios loguearPorCorreo(String correo, String contraseña);

    Usuarios consultarPorNombreUsuario(String nombreUsuario);

    Usuarios consultarPorCorreo(String correo);

    Usuarios actualizarUsuario(ObjectId id, String nombre, String nombreUsuario, String correo, String edad, String sexo, String contraseña);
    
    Usuarios consultarPorIdUsuario(ObjectId idUsuario);

    boolean agregarChat(Chats chats);

    List<Chats> consultarChats(String nombreUsuario);

    Chats consultarChat(ObjectId id);

    boolean agregarMensajeAChat(Mensajes mensaje, Chats chat);

    List<Chats> cargarMensajesDeChat(Chats chat);

    List<Mensajes> cargarMensajes(ObjectId idChat);

    boolean agregarMensaje(Mensajes mensaje);

    Mensajes consultarMensaje(ObjectId idMensaje);

    boolean mensajeEnviadoPorEmisor(Chats chat, ObjectId mensajeId, ObjectId usuarioEmisor);
}
