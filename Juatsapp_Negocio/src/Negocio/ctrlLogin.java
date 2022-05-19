/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Usuarios;
import static Negocio.inicioFachada.fachadaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lv1013
 */
public class ctrlLogin {
    
    public Usuarios login(JFrame frame, JTextField txtUsuario, JTextField txtContraseña){
    String nombreUsuario = txtUsuario.getText();
    String contraseña = txtContraseña.getText();
        if (nombreUsuario.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre de usuario o correo", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        else if (contraseña.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese la contraseña", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    Usuarios usuarioEncontrado = fachadaDAO.loguear(nombreUsuario, contraseña);
    if(!(usuarioEncontrado==null)){
        return usuarioEncontrado;
    }
    else {
//        JOptionPane.showMessageDialog(frame, "No se ha encontrado al usuario", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
//        limpiar(txtUsuario, txtContraseña);
          return null;
          
        
    }
    }
    
    public void limpiar(JTextField txtUsuario, JTextField txtContraseña){
    txtUsuario.setText("");
    txtContraseña.setText("");
    }
    
    public Usuarios loginPorCorreo(JFrame frame, JTextField txtCorreo, JTextField txtContraseña){
        String correo = txtCorreo.getText();
    String contraseña = txtContraseña.getText();
    
    Usuarios usuarioEncontrado = fachadaDAO.loguearPorCorreo(correo, contraseña);
            if (correo.equals("")) {
            return null;
        }
        else if (contraseña.equals("")) {
            return null;
        }
    if(!(usuarioEncontrado==null)){
        return usuarioEncontrado;
    }
    else {
        JOptionPane.showMessageDialog(frame, "No se ha encontrado al usuario", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
        limpiar(txtCorreo, txtContraseña);
        return null;
    }
   
    }
}
