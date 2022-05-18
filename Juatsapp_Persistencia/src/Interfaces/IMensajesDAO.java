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
public interface IMensajesDAO {
       
    List<Mensajes> cargarMensajes(ObjectId idChat);
    boolean agregar(Mensajes mensaje);
    Mensajes consultarMensaje(Mensajes mensaje);
    boolean mensajeEnviadoPorEmisor(Chats chat, ObjectId mensajeId, ObjectId usuarioEmisor);
}
