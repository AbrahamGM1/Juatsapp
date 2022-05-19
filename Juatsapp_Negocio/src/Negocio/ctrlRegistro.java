/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Usuarios;
import Implementaciones.ChatsDAO;
import Implementaciones.ConexionBD;
import Implementaciones.FachadaDAO;
import Implementaciones.MensajesDAO;
import Implementaciones.UsuariosDAO;
import Interfaces.IChatsDAO;
import Interfaces.IFachadaDAO;
import Interfaces.IMensajesDAO;
import Interfaces.IUsuariosDAO;
import static Negocio.inicioFachada.fachadaDAO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

/**
 *
 * @author Abraham
 */
public class ctrlRegistro {
    
    
        public Usuarios registrarUsuario(JFrame frame, JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtContraseña, JTextField txtEdad, JComboBox cbSexo) {
        
        String nombre = txtNombre.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String correo = txtCorreo.getText();
        String contraseña = txtContraseña.getText();
        String edad = txtEdad.getText();
        String sexo = cbSexo.getSelectedItem().toString();
        Usuarios usuario = new Usuarios(nombre, nombreUsuario, correo, contraseña, edad, sexo);
        //TO DO: VALIDACIONES
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (nombreUsuario.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre de usuario por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE); 
            return null;
            }
        else if (!(fachadaDAO.consultarPorNombreUsuario(nombreUsuario) == null)) {
            JOptionPane.showMessageDialog(frame, "El nombre de usuario ingresado ya existe", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        else if ( correo.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el correo por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);   
            return null;
            }
        else if (!(fachadaDAO.consultarPorCorreo(correo) == null)) {
            JOptionPane.showMessageDialog(frame, "El correo ingresado ya se encuentra vinculado a otra cuenta", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        else if (contraseña.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese una contraseña para su cuenta por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);    
            return null;
            }
        else if (edad.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese su edad por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);    
            return null;
            }
        else {           
                fachadaDAO.agregarUsuario(usuario);
                JOptionPane.showMessageDialog(frame, "Usuario registrado", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
                return usuario;
        }
   
}
        
        public void limpiarFormulario(JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JPasswordField txtContraseña) {
        txtNombre.setText("");
        txtNombreUsuario.setText("");
        txtCorreo.setText("");
        txtContraseña.setText("");
        txtEdad.setText("");
        
    }
}
