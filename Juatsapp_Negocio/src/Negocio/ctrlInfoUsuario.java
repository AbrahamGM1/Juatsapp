/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Usuarios;
import static Negocio.ctrlRegistro.usuariosDAO;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Abraham
 */
public class ctrlInfoUsuario {
    Usuarios usuario;
    
    ///Checa que jale el mongodumb desde el cmd si no agregalo como variable de entorno en el windows
    ////MONGO TOOLS MONGO DUMB     comprimir:      mongodump --gzip --uri="mongodb://localhost/juatsapp" --archive ="mirespaldo.gzip"
    //////////////////////////     descomprimir:   mongorestore --uri="mongodb://localhost/juatsapp" --archive ="mirespaldo.gzip"
    
    
        public void llenarFormulario(Usuarios usuario, JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo) {
        txtNombre.setText(usuario.getNombre());
        txtNombreUsuario.setText(usuario.getNombreUsuario());
        txtCorreo.setText(usuario.getCorreo());
        txtEdad.setText(usuario.getEdad());
        if (usuario.getSexo().equalsIgnoreCase("hombre")) {
            cbSexo.setSelectedIndex(0);
        } else if (usuario.getSexo().equalsIgnoreCase("mujer")) {
            cbSexo.setSelectedIndex(1);
        } else if (usuario.getSexo().equalsIgnoreCase("robot")) {
            cbSexo.setSelectedIndex(2);
        }
    }


    public void actualizar(JFrame frame, Usuarios usuario, JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo, JLabel lblGuardar, JPanel btnGuardar) {
        String nombre = txtNombre.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String correo = txtCorreo.getText();
        String edad = txtEdad.getText();
        String sexo = "";
        switch (cbSexo.getSelectedIndex()) {
            case 0:
                sexo = "hombre";
                break;
            case 1:
                sexo = "mujer";
                break;
            case 2:
                sexo = "robot";
                break;
            default:
                break;
        }
        if (nombre.equals("") || nombreUsuario.equals("") || correo.equals("") || edad.equals("") || sexo.equals("")) {
            JOptionPane.showMessageDialog(frame, "Llene todos los campos por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            
        } else {
            usuario=usuariosDAO.actualizar(usuario.getId(), nombre, nombreUsuario, correo, edad, sexo);
            this.usuario=usuario;
            JOptionPane.showMessageDialog(frame, "Usuario Actualizado", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            bloquear(txtNombre, txtNombreUsuario, txtCorreo, txtEdad, cbSexo, lblGuardar, btnGuardar);
            
        }

    }
    
    public Usuarios getUsuario(){
    return usuario;
    }
    
        public void bloquear( JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo, JLabel lblGuardar, JPanel btnGuardar) {
        txtNombre.setEnabled(false);
        txtNombre.setEditable(false);
        txtNombreUsuario.setEnabled(false);
        txtNombreUsuario.setEditable(false);
        txtCorreo.setEnabled(false);
        txtCorreo.setEditable(false);
        txtEdad.setEnabled(false);
        txtEdad.setEditable(false);
        cbSexo.setEnabled(false);
        cbSexo.setEditable(false);
        lblGuardar.setEnabled(false);
        btnGuardar.setEnabled(false);
    }


}
