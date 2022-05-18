/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Usuarios;
import Implementaciones.ChatsDAO;
import Implementaciones.ConexionBD;
import Implementaciones.MensajesDAO;
import Implementaciones.UsuariosDAO;
import Interfaces.IChatsDAO;
import Interfaces.IMensajesDAO;
import Interfaces.IUsuariosDAO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author lv1013
 */
public class ctrlRegistro {
    
    
    static IUsuariosDAO usuariosDAO = new UsuariosDAO(new ConexionBD());
    static IChatsDAO chatsDAO = new ChatsDAO(new ConexionBD());
    static IMensajesDAO mensajesDAO= new MensajesDAO(new ConexionBD());
    
        public Usuarios registrarUsuario(JFrame frame, JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtContraseña, JTextField txtEdad, JComboBox cbSexo) {
        
        String nombre = txtNombre.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String correo = txtCorreo.getText();
        String contraseña = txtContraseña.getText();
        String edad = txtEdad.getText();
        String sexo = cbSexo.getSelectedItem().toString();
        Usuarios usuario = new Usuarios(nombre, nombreUsuario, correo, contraseña, edad, sexo);
        //TO DO: VALIDACIONES
        if (!(usuariosDAO.consultarPorNombreUsuario(nombreUsuario) == null)) {
            JOptionPane.showMessageDialog(frame, "El nombre de usuario ingresado ya existe", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (!(usuariosDAO.consultarPorCorreo(correo) == null)) {
            JOptionPane.showMessageDialog(frame, "El correo ingresado ya se encuentra vinculado a otra cuenta", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (nombre.equals("") || nombreUsuario.equals("") || correo.equals("") || contraseña.equals("") || edad.equals("")) {
            JOptionPane.showMessageDialog(frame, "Llene todos los campos por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        } else {           
                usuariosDAO.agregar(usuario);
                JOptionPane.showMessageDialog(frame, "Usuario registrado", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
                return usuario;
        }
   
}
}
