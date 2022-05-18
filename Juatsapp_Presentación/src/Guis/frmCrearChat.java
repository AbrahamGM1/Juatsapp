/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guis;

import Dominio.Chats;
import Dominio.Usuarios;
import static Guis.frmMenu.chatsDAO;
import static Guis.frmMenu.usuariosDAO;
import Negocio.ctrlCrearChat;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Abraham
 */
public class frmCrearChat extends javax.swing.JFrame {
    ctrlCrearChat control = new ctrlCrearChat();
    int xMouse, yMouse;
    Usuarios usuario;
    
    public frmCrearChat(Usuarios usuario) {
        initComponents();
        this.usuario=usuario;
    }

        ///////////////
    public void recolorEnter(JLabel boton, JPanel botonfondo){
        boton.setForeground(new Color(255,255,255));
        botonfondo.setBackground(Color.blue);
    }
    
    public void recolorExit(JLabel boton, JPanel botonfondo){
        boton.setForeground(new Color(0,204,255));
        botonfondo.setBackground(new Color(204,255,255));
    }
    /////////////////
    
    public void crearChat(){
    String nombreChat = this.txtNombreChat.getText();
    //TO DO CONSULTAR EL USUARIO PARA MANDARLO COMO PARAMETRO - hacer una consulta donde envies el nombre del texto
    
    Usuarios usuarioInvitado = usuariosDAO.consultarPorNombreUsuario(this.txtUsuarioInvitado.getText());
        if (usuarioInvitado==null) {
        JOptionPane.showMessageDialog(this, "El usuario ingresado no existe", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
        }
        else if(usuarioInvitado.getNombreUsuario().equals(usuario.getNombreUsuario())){
        JOptionPane.showMessageDialog(this, "No puedes hacer un chat contigo mismo", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);        
        }else{
        chatsDAO.agregar(new Chats(nombreChat,usuario,usuarioInvitado));
        JOptionPane.showMessageDialog(this, "Se agregó el chat", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        salir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        txtUsuarioInvitado = new javax.swing.JTextField();
        btnCrearChat = new javax.swing.JPanel();
        lblCrearChat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreChat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOMBRE DEL USUARIO A INVITAR:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        txtSalir.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        txtSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSalir.setText("X");
        txtSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout salirLayout = new javax.swing.GroupLayout(salir);
        salir.setLayout(salirLayout);
        salirLayout.setHorizontalGroup(
            salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );
        salirLayout.setVerticalGroup(
            salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 272, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 40));

        txtUsuarioInvitado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jPanel1.add(txtUsuarioInvitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 280, 30));

        btnCrearChat.setBackground(new java.awt.Color(204, 255, 255));

        lblCrearChat.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblCrearChat.setForeground(new java.awt.Color(0, 204, 255));
        lblCrearChat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCrearChat.setText("CREAR CHAT");
        lblCrearChat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearChatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCrearChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearChatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCrearChatLayout = new javax.swing.GroupLayout(btnCrearChat);
        btnCrearChat.setLayout(btnCrearChatLayout);
        btnCrearChatLayout.setHorizontalGroup(
            btnCrearChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCrearChatLayout.createSequentialGroup()
                .addComponent(lblCrearChat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnCrearChatLayout.setVerticalGroup(
            btnCrearChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCrearChat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnCrearChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 160, 50));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE DEL CHAT:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtNombreChat.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNombreChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreChatActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 280, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseClicked
       frmUsuarioChats usuarioChats = new frmUsuarioChats(usuario);
       usuarioChats.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_txtSalirMouseClicked

    private void txtSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseEntered
        txtSalir.setForeground(Color.red);
    }//GEN-LAST:event_txtSalirMouseEntered

    private void txtSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseExited
        txtSalir.setForeground(Color.black);
    }//GEN-LAST:event_txtSalirMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void lblCrearChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearChatMouseClicked
     control.crearChat(this, usuario, txtNombreChat, txtUsuarioInvitado);
        
        
    }//GEN-LAST:event_lblCrearChatMouseClicked

    private void lblCrearChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearChatMouseEntered
        recolorEnter(lblCrearChat,btnCrearChat);
    }//GEN-LAST:event_lblCrearChatMouseEntered

    private void lblCrearChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearChatMouseExited
        recolorExit(lblCrearChat,btnCrearChat);
    }//GEN-LAST:event_lblCrearChatMouseExited

    private void txtNombreChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreChatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCrearChat;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCrearChat;
    private javax.swing.JPanel salir;
    private javax.swing.JTextField txtNombreChat;
    private javax.swing.JLabel txtSalir;
    private javax.swing.JTextField txtUsuarioInvitado;
    // End of variables declaration//GEN-END:variables
}
