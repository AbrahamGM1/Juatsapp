/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class Mensajes {

    private ObjectId id;
    private ObjectId idChat;
    private String textoMensaje;
    private ObjectId usuarioEmisor;
    private LocalDateTime fechaMensaje;

    public Mensajes() {
    }

    public ObjectId getIdChat() {
        return idChat;
    }

    public void setIdChat(ObjectId idChat) {
        this.idChat = idChat;
    }

    public Mensajes(ObjectId idChat, String textoMensaje, ObjectId usuarioEmisor, LocalDateTime fechaMensaje) {
        this.idChat = idChat;
        this.textoMensaje = textoMensaje;
        this.usuarioEmisor = usuarioEmisor;
        this.fechaMensaje = fechaMensaje;
    }

    public Mensajes(String textoMensaje, ObjectId usuarioEmisor, LocalDateTime fechaMensaje) {
        this.textoMensaje = textoMensaje;
        this.usuarioEmisor = usuarioEmisor;
        this.fechaMensaje = fechaMensaje;
    }

    public ObjectId getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(ObjectId usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTextoMensaje() {
        return textoMensaje;
    }

    public void setTextoMensaje(String textoMensaje) {
        this.textoMensaje = textoMensaje;
    }

    public LocalDateTime getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDateTime fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.textoMensaje);
        hash = 89 * hash + Objects.hashCode(this.usuarioEmisor);
        hash = 89 * hash + Objects.hashCode(this.fechaMensaje);
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
        final Mensajes other = (Mensajes) obj;
        if (!Objects.equals(this.textoMensaje, other.textoMensaje)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEmisor, other.usuarioEmisor)) {
            return false;
        }
        return Objects.equals(this.fechaMensaje, other.fechaMensaje);
    }

    @Override
    public String toString() {
        return textoMensaje + "\n"; //+ ", fechaMensaje=" + fechaMensaje;
    }

}
