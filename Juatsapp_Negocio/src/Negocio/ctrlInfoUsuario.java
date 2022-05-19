/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Usuarios;
import static Negocio.inicioFachada.fachadaDAO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
    public void llenarFormulario(Usuarios usuario, JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo, JPasswordField txtContraseña) {
        txtNombre.setText(usuario.getNombre());
        txtNombreUsuario.setText(usuario.getNombreUsuario());
        txtCorreo.setText(usuario.getCorreo());
        txtEdad.setText(usuario.getEdad());
        txtContraseña.setText(usuario.getContraseña());
        if (usuario.getSexo().equalsIgnoreCase("hombre")) {
            cbSexo.setSelectedIndex(0);
        } else if (usuario.getSexo().equalsIgnoreCase("mujer")) {
            cbSexo.setSelectedIndex(1);
        } else if (usuario.getSexo().equalsIgnoreCase("robot")) {
            cbSexo.setSelectedIndex(2);
        }
    }

    public Usuarios actualizar(JFrame frame, Usuarios usuario, JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo, JButton btnGuardar, JPasswordField txtContraseña, JButton mostrar) {
        String nombre = txtNombre.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String correo = txtCorreo.getText();
        String edad = txtEdad.getText();
        String sexo = "";
        String contraseña = txtContraseña.getText();
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
        String regx = "^(.+)@(.+)$";
                if (nombre.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (nombreUsuario.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre de usuario por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE); 
            return null;
            }
        else if ( correo.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese el correo por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);   
            return null;
            }
        else if (contraseña.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese la contraseña", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);    
            return null;
            }
        else if (edad.equals("")) {
            JOptionPane.showMessageDialog(frame, "Ingrese su edad por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);    
            return null;
            }
         else {
            usuario = fachadaDAO.actualizarUsuario(usuario.getId(), nombre, nombreUsuario, correo, edad, sexo, contraseña);
            this.usuario = usuario;
            JOptionPane.showMessageDialog(frame, "Usuario Actualizado", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            bloquear(txtNombre, txtNombreUsuario, txtCorreo, txtEdad, cbSexo, btnGuardar, txtContraseña, mostrar);
            return usuario;
        }

    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void bloquear(JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo, JButton guardar, JPasswordField txtContraseña, JButton mostrar) {
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
        guardar.setEnabled(false);
        txtContraseña.setEnabled(false);
        txtContraseña.setEditable(false);
        mostrar.setEnabled(false);
    }

    public void desbloquear(JTextField txtNombre, JTextField txtNombreUsuario, JTextField txtCorreo, JTextField txtEdad, JComboBox cbSexo, JButton guardar, JPasswordField txtContraseña, JButton mostrar) {
        txtNombre.setEnabled(true);
        txtNombre.setEditable(true);
        txtNombreUsuario.setEnabled(true);
        txtNombreUsuario.setEditable(true);
        txtCorreo.setEnabled(true);
        txtCorreo.setEditable(true);
        txtEdad.setEnabled(true);
        txtEdad.setEditable(true);
        cbSexo.setEnabled(true);
        guardar.setEnabled(true);
        txtContraseña.setEnabled(true);
        txtContraseña.setEditable(true);
        mostrar.setEnabled(true);
    }

    public void llenarcombo(JComboBox cbSexo) {
        cbSexo.addItem("Hombre");
        cbSexo.addItem("Mujer");
        cbSexo.addItem("Robot");

    }

}
