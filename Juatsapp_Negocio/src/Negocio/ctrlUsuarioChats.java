/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Chats;
import Dominio.Usuarios;
import static Negocio.ctrlRegistro.chatsDAO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author lv1013
 */

public class ctrlUsuarioChats {
    
        public void mostrarChats(Usuarios usuario, JTable tblChats) {
        List<Chats> listaChats = chatsDAO.consultarChats(usuario.getNombreUsuario());

        DefaultTableModel modeloTabla = (DefaultTableModel) tblChats.getModel();
        modeloTabla.setRowCount(0);
        listaChats.forEach(chat -> {

            Object[] fila = new Object[4];
            fila[0] = chat.getId();
            fila[1] = chat.getNombreChat();
            fila[2] = chat.getCreador().getNombreUsuario();
            fila[3] = chat.getInvitado().getNombreUsuario();
            modeloTabla.addRow(fila);

        });
        tblChats.getColumnModel().getColumn(0).setMaxWidth(0);
        tblChats.getColumnModel().getColumn(0).setMinWidth(0);
        tblChats.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public ObjectId getChatSeleccionado(JTable tblChats) {
        int indiceFilaSeleccionada = tblChats.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tblChats.getModel();
        int indiceColumnaId = 0;
        if (indiceFilaSeleccionada != -1) {
            ObjectId chatSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return chatSeleccionado;
        } else {
            return null;
        }
    }

    public boolean entrarChat(JFrame frame, ObjectId chatSeleccionado, JTable tblChats, ObjectId usuarioEmisor) {
        //INICIALIZAR LOS ID
        
        chatSeleccionado = this.getChatSeleccionado(tblChats);
        Chats chatIngreso= new Chats();
        if (chatSeleccionado == null) {
            chatIngreso = chatsDAO.consultarChat(chatSeleccionado);
            JOptionPane.showMessageDialog(frame, "Debes seleccionar un chat primero", "JUATSAPP DICE", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    public Chats getChatIngreso(ObjectId chatSeleccionado){
    Chats chatIngreso = chatsDAO.consultarChat(chatSeleccionado);
    return chatIngreso;
    }
    
}
