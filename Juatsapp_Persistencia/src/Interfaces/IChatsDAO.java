/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Dominio.Chats;
import Dominio.Mensajes;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public interface IChatsDAO {
    boolean agregarChat (Chats chats);
    List<Chats> consultarChats(String nombreUsuario);
    Chats consultarChat(ObjectId id);
    boolean agregarMensajeAChat(Mensajes mensaje, Chats chat);
    List<Chats>cargarMensajesDeChat(Chats chat);
}
