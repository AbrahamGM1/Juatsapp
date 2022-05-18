/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Chats;
import Dominio.Mensajes;
import static Negocio.ctrlRegistro.chatsDAO;
import static Negocio.ctrlRegistro.mensajesDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public class ctrlChat {

    public void enviarMensaje(String txtMensaje, ObjectId usuarioEmisor, Chats chat, JTextPane panel){
    
    LocalDateTime fecha = LocalDateTime.now();    
    Mensajes mensaje = new Mensajes(chat.getId(),txtMensaje,usuarioEmisor,fecha);
    mensajesDAO.agregar(mensaje);
    chatsDAO.agregarMensajeAChat(mensaje, chat);
    cargarMensajes(panel, chat, usuarioEmisor);
    }
    
    public void cargarMensajes(JTextPane panel, Chats chat, ObjectId usuarioEmisor){
        StyledDocument doc = panel.getStyledDocument();
        SimpleAttributeSet right = new SimpleAttributeSet();
        SimpleAttributeSet left = new SimpleAttributeSet();
        boolean mensajeEnviadoPorEmisor;
        
        List<Mensajes> mensajesbuscados= mensajesDAO.cargarMensajes(chat.getId());

        //una variable que cuente los mensajes mandados por el usuario que los mando y que corte el contador una vez el mensaje no coincida con ese usuario
        //DENTRO DE UN FOR
        
        //hacer un metodo cortito que analice si el mensaje es del emisor, si si es que devuelva true; va a recibir de parametro la lista del mensaje con el indice i
        panel.setText("");
        String contenido = chatsDAO.cargarMensajes(chat).toString();
        String contenidoLimpio = contenido.replace("[[","").replace("]"+"\n", "").replace("\n"+"]", "").replace("\n"+", ", "\n").replace("[null", "");
        panel.setText(contenidoLimpio);
        for (int i = 0; i < mensajesbuscados.size(); i++) {
            mensajeEnviadoPorEmisor=mensajesDAO.mensajeEnviadoPorEmisor(chat, chatsDAO.cargarMensajes(chat).get(0).getMensajes().get(i).getId(), usuarioEmisor);
           
            if (mensajesbuscados.get(i).getUsuarioEmisor().toString().equals(usuarioEmisor.toString())/*el mensaje encontrado coincide con el usuario emisor*/) {
                StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT); 
                doc.setParagraphAttributes(0, doc.getLength(), right, false);
            }else{
                StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, 1, left, false);            
            }
        }
        doc.setParagraphAttributes(0, doc.getLength(), right, false);

        System.out.println(chatsDAO.cargarMensajes(chat));
    }
    
    public void consultarMensaje(){
    
    }
    
    
}
