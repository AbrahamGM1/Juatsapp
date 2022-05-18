/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class Chats {
    private ObjectId id;
    private String nombreChat;
    private Usuarios creador;
    private Usuarios invitado;
    private List<Mensajes> mensajes;

    public Chats() {
    }

    public Chats(ObjectId id, String nombreChat, Usuarios creador, Usuarios invitado, List<Mensajes> mensajes) {
        this.id = id;
        this.nombreChat = nombreChat;
        this.creador = creador;
        this.invitado = invitado;
        this.mensajes = mensajes;
    }

    public List<Mensajes> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensajes> mensajes) {
        this.mensajes = mensajes;
    }

    public Chats(ObjectId id, String nombreChat, Usuarios creador, Usuarios invitado ) {
        this.id = id;
        this.nombreChat = nombreChat;
        this.creador = creador;
        this.invitado = invitado;
    }

    public Chats(String nombreChat, Usuarios creador, Usuarios invitado) {
        this.nombreChat = nombreChat;
        this.creador = creador;
        this.invitado = invitado;
    
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreChat() {
        return nombreChat;
    }

    public void setNombreChat(String nombreChat) {
        this.nombreChat = nombreChat;
    }

    public Usuarios getCreador() {
        return creador;
    }

    public void setCreador(Usuarios creador) {
        this.creador = creador;
    }

    public Usuarios getInvitado() {
        return invitado;
    }

    public void setInvitado(Usuarios invitado) {
        this.invitado = invitado;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nombreChat);
        hash = 79 * hash + Objects.hashCode(this.creador);
        hash = 79 * hash + Objects.hashCode(this.invitado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chats other = (Chats) obj;
        if (!Objects.equals(this.nombreChat, other.nombreChat)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.creador, other.creador)) {
            return false;
        }
        if (!Objects.equals(this.invitado, other.invitado)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return  mensajes + "\n" ; 
    }


    
    
}
