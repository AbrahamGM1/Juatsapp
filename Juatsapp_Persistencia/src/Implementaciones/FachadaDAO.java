/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import Dominio.Chats;
import Dominio.Mensajes;
import Dominio.Usuarios;
import Interfaces.IFachadaDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class FachadaDAO implements IFachadaDAO {

    private FabricaDAO fabrica;
    private UsuariosDAO usuariosDAO;
    private ChatsDAO chatsDAO;
    private MensajesDAO mensajesDAO;

    public FachadaDAO() {

        fabrica = new FabricaDAO();

        this.usuariosDAO = fabrica.crearUsuariosDAO();
        this.chatsDAO = fabrica.crearChatsDAO();
        this.mensajesDAO = fabrica.crearMensajesDAO();

    }

    @Override
    public boolean agregarUsuario(Usuarios usuario) {
        try {

            return usuariosDAO.agregarUsuario(usuario);

        } catch (Exception e) {

            System.err.print(e);
            return false;

        }
    }

    @Override
    public List<Usuarios> consultarTodos() {
        try {

            return usuariosDAO.consultarTodos();

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public Usuarios loguear(String nombreUsuario, String contraseña) {
        try {

            return usuariosDAO.loguear(nombreUsuario, contraseña);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public Usuarios loguearPorCorreo(String correo, String contraseña) {
        try {

            return usuariosDAO.loguearPorCorreo(correo, contraseña);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public Usuarios consultarPorNombreUsuario(String nombreUsuario) {
        try {

            return usuariosDAO.consultarPorNombreUsuario(nombreUsuario);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public Usuarios consultarPorCorreo(String correo) {
        try {

            return usuariosDAO.consultarPorCorreo(correo);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public Usuarios actualizarUsuario(ObjectId id, String nombre, String nombreUsuario, String correo, String edad, String sexo, String contraseña) {
        try {

            return usuariosDAO.actualizarUsuario(id, nombre, nombreUsuario, correo, edad, sexo,contraseña);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public boolean agregarChat(Chats chats) {
        try {

            return chatsDAO.agregarChat(chats);

        } catch (Exception e) {

            System.err.print(e);
            return false;

        }
    }

    @Override
    public List<Chats> consultarChats(String nombreUsuario) {
        try {

            return chatsDAO.consultarChats(nombreUsuario);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public Chats consultarChat(ObjectId id) {
        try {

            return chatsDAO.consultarChat(id);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public boolean agregarMensajeAChat(Mensajes mensaje, Chats chat) {
        try {

            return chatsDAO.agregarMensajeAChat(mensaje, chat);

        } catch (Exception e) {

            System.err.print(e);
            return false;

        }
    }

    @Override
    public List<Chats> cargarMensajesDeChat(Chats chat) {
        try {

            return chatsDAO.cargarMensajesDeChat(chat);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public List<Mensajes> cargarMensajes(ObjectId idChat) {
        try {

            return mensajesDAO.cargarMensajes(idChat);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public boolean agregarMensaje(Mensajes mensaje) {
        try {

            return mensajesDAO.agregarMensaje(mensaje);

        } catch (Exception e) {

            System.err.print(e);
            return false;

        }
    }

    @Override
    public Mensajes consultarMensaje(ObjectId idMensaje) {
        try {

            return mensajesDAO.consultarMensaje(idMensaje);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

    @Override
    public boolean mensajeEnviadoPorEmisor(Chats chat, ObjectId mensajeId, ObjectId usuarioEmisor) {
        try {

            return mensajesDAO.mensajeEnviadoPorEmisor(chat, mensajeId, usuarioEmisor);

        } catch (Exception e) {

            System.err.print(e);
            return false;

        }
    }

    @Override
    public Usuarios consultarPorIdUsuario(ObjectId idUsuario) {
        try {

            return usuariosDAO.consultarPorIdUsuario(idUsuario);

        } catch (Exception e) {

            System.err.print(e);
            return null;

        }
    }

}
