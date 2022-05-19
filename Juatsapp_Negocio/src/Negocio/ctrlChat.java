/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Chats;
import Dominio.Mensajes;
import static Negocio.inicioFachada.fachadaDAO;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class ctrlChat {

    private List<JLabel> labels = new ArrayList<>();

    public void enviarMensaje(String txtMensaje, ObjectId usuarioEmisor, String nombreUsuarioEmisor, Chats chat, JTextPane panel) {

        LocalDateTime fecha = LocalDateTime.now();
        if (txtMensaje.equals("")) {
           
        }else{
        Mensajes mensaje = new Mensajes(chat.getId(), txtMensaje, usuarioEmisor,nombreUsuarioEmisor, fecha);
        fachadaDAO.agregarMensaje(mensaje);
        fachadaDAO.agregarMensajeAChat(mensaje, chat);
        cargarMensajes(panel, chat, usuarioEmisor);
        }
    }

    public void cargarMensajes(JTextPane panel, Chats chat, ObjectId usuarioEmisor) {
        boolean mensajeEnviadoPorEmisor;
        List<Mensajes> mensajesbuscados = fachadaDAO.cargarMensajes(chat.getId());
        String contenido = fachadaDAO.cargarMensajes(chat.getId()).toString();
//       getUsuarioFecha(chat.getMensajes().get(0).getId()) +
            try{
             panel.setText(contenidoLimpio(fachadaDAO.cargarMensajes(chat.getId()).toString()) + "\n" + "\n");
             
            }catch(Exception e){
             return;
            }

        

    }

    public void cargarMensajesPanel(JPanel panel, Chats chat, ObjectId usuarioEmisor) {

        boolean mensajeEnviadoPorEmisor;
        List<Mensajes> mensajesbuscados = fachadaDAO.cargarMensajes(chat.getId());
        String contenido = fachadaDAO.cargarMensajes(chat.getId()).toString();
        //  String contenidoLimpio = contenido.replace("[[","").replace("]"+"\n", "").replace("\n"+"]", "").replace("\n"+", ", "\n").replace("[null", "");
        JLabel mensaje;
        int contador = 0;
        for (int indice = 0; indice < fachadaDAO.cargarMensajes(chat.getId()).size(); indice++) {
            try {

                mensaje = new JLabel(contenidoLimpio(getUsuarioFecha(chat.getMensajes().get(indice).getId()) + fachadaDAO.cargarMensajes(chat.getId()).get(indice).getTextoMensaje()) + "\n" + "\n");
                panel.remove(mensaje);
                mensaje.setForeground(new Color(0, 150, 255));
                panel.add(mensaje);
                labels.add(mensaje);

                panel.updateUI();

            } catch (Exception e) {
                return;
            }
        }

    }

    public String getUsuarioFecha(ObjectId idMensaje) {
        Mensajes mensaje = fachadaDAO.consultarMensaje(idMensaje);
        String fecha = mensaje.getFechaMensaje().toString();
        ObjectId usuarioEmisor = fachadaDAO.consultarMensaje(idMensaje).getUsuarioEmisor();
        String emisor = fachadaDAO.consultarPorIdUsuario(usuarioEmisor).getNombreUsuario();
        String formato = emisor + " " + fecha + ": ";
        return formato;
    }

    public String contenidoLimpio(String contenido) {
        return contenido.replace("[[", "").replace("]" + "\n", "").replace("\n" + "]", "").replace("\n" + ", ", "\n").replace("[null", "");
    }

}
