/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Chats;
import Dominio.Usuarios;
import static Negocio.inicioFachada.fachadaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Abraham
 */
public class ctrlCrearChat {
    public boolean crearChat(JFrame frame, Usuarios usuario, JTextField txtNombreChat, JTextField txtUsuarioInvitado){
    String nombreChat = txtNombreChat.getText();
    //TO DO CONSULTAR EL USUARIO PARA MANDARLO COMO PARAMETRO - hacer una consulta donde envies el nombre del texto
    
    Usuarios usuarioInvitado = fachadaDAO.consultarPorNombreUsuario(txtUsuarioInvitado.getText());
        if (usuarioInvitado==null) {
        JOptionPane.showMessageDialog(frame, "El usuario ingresado no existe", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
        return false;
        }
//        else if(usuarioInvitado.equals(fachadaDAO.consultarChat(id){
//            
//        }
        else if(usuarioInvitado.getNombreUsuario().equals(usuario.getNombreUsuario())){
        JOptionPane.showMessageDialog(frame, "No puedes hacer un chat contigo mismo", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);   
        return false;
        }else{
        ///TO DO: QUE NO PUEDAS HACER MAS DE UN CHAT CON LA MISMA PERSONA    
        fachadaDAO.agregarChat(new Chats(nombreChat,usuario,usuarioInvitado));
        JOptionPane.showMessageDialog(frame, "Se agregó el chat", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
        return true;
        }
    }
}
