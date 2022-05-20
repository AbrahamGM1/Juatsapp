/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guis;

import Dominio.Chats;
import Dominio.Usuarios;
import static Guis.frmMenu.chatsDAO;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Implementaciones.ChatsDAO;
import Implementaciones.ConexionBD;
import Interfaces.IChatsDAO;
import Negocio.ctrlUsuarioChats;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author Abraham
 */
public class frmUsuarioChats extends javax.swing.JFrame {

    /**
     * Creates new form frmUsuarioChats
     */
    int xMouse, yMouse;
    Usuarios usuario;
    ctrlUsuarioChats control = new ctrlUsuarioChats();
    public frmUsuarioChats(Usuarios usuario) {
        initComponents();
        this.lblNombreUsuario.setText(usuario.getNombreUsuario());
        this.usuario = usuario;
        control.mostrarChats(usuario, tblChats);

    }

    ////SOLO PARA DARLE DISEÑO A LOS "BOTONES"////////
    public void recolorEnter(JLabel boton, JPanel botonfondo) {
        boton.setForeground(new Color(255, 255, 255));
        botonfondo.setBackground(Color.blue);
    }

    public void recolorExit(JLabel boton, JPanel botonfondo) {
        boton.setForeground(new Color(204, 255, 255));
        botonfondo.setBackground(new Color(0, 204, 255));
    }
    //////////////////////////////////////////////////


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JPanel();
        lblCerrarSesion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChats = new javax.swing.JTable();
        btnCrearChat = new javax.swing.JPanel();
        lblCrearChat = new javax.swing.JLabel();
        btnEntrarChat = new javax.swing.JPanel();
        lblEntrarChat = new javax.swing.JLabel();
        banner = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        btnUsuarioInfo = new javax.swing.JPanel();
        lblUsuarioInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Repositorio de chats");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(668, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        btnCerrarSesion.setBackground(new java.awt.Color(0, 204, 255));

        lblCerrarSesion.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(204, 255, 255));
        lblCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrarSesion.setText("CERRAR SESIÓN");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCerrarSesionLayout = new javax.swing.GroupLayout(btnCerrarSesion);
        btnCerrarSesion.setLayout(btnCerrarSesionLayout);
        btnCerrarSesionLayout.setHorizontalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCerrarSesionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCerrarSesionLayout.setVerticalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCerrarSesionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, -1));

        tblChats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "idChat", "Chat", "Usuario creador", "Usuario invitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblChats);
        if (tblChats.getColumnModel().getColumnCount() > 0) {
            tblChats.getColumnModel().getColumn(0).setResizable(false);
            tblChats.getColumnModel().getColumn(1).setResizable(false);
            tblChats.getColumnModel().getColumn(2).setResizable(false);
            tblChats.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 620, 260));

        btnCrearChat.setBackground(new java.awt.Color(0, 204, 255));

        lblCrearChat.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblCrearChat.setForeground(new java.awt.Color(204, 255, 255));
        lblCrearChat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCrearChat.setText("NUEVO CHAT");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCrearChat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCrearChatLayout.setVerticalGroup(
            btnCrearChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCrearChat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnCrearChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        btnEntrarChat.setBackground(new java.awt.Color(0, 204, 255));

        lblEntrarChat.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblEntrarChat.setForeground(new java.awt.Color(204, 255, 255));
        lblEntrarChat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrarChat.setText("ENTRAR A CHAT");
        lblEntrarChat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEntrarChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEntrarChatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEntrarChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEntrarChatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEntrarChatLayout = new javax.swing.GroupLayout(btnEntrarChat);
        btnEntrarChat.setLayout(btnEntrarChatLayout);
        btnEntrarChatLayout.setHorizontalGroup(
            btnEntrarChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEntrarChat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEntrarChatLayout.setVerticalGroup(
            btnEntrarChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEntrarChat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnEntrarChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        banner.setBackground(new java.awt.Color(0, 204, 255));

        lblBienvenido.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setText("BIENVENIDO");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("BIENVENIDO");

        javax.swing.GroupLayout bannerLayout = new javax.swing.GroupLayout(banner);
        banner.setLayout(bannerLayout);
        bannerLayout.setHorizontalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenido)
                .addGap(18, 18, 18)
                .addComponent(lblNombreUsuario)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        bannerLayout.setVerticalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bannerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 840, 80));

        btnUsuarioInfo.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuarioInfo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblUsuarioInfo.setForeground(new java.awt.Color(153, 153, 153));
        lblUsuarioInfo.setText("   VER PERFIL");
        lblUsuarioInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsuarioInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsuarioInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUsuarioInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUsuarioInfoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnUsuarioInfoLayout = new javax.swing.GroupLayout(btnUsuarioInfo);
        btnUsuarioInfo.setLayout(btnUsuarioInfoLayout);
        btnUsuarioInfoLayout.setHorizontalGroup(
            btnUsuarioInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuarioInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsuarioInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnUsuarioInfoLayout.setVerticalGroup(
            btnUsuarioInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuarioInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsuarioInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnUsuarioInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        // TODO add your handling code here:
        frmMenu menu = new frmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        // TODO add your handling code here:
        recolorEnter(lblCerrarSesion, btnCerrarSesion);
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        // TODO add your handling code here:
        recolorExit(lblCerrarSesion, btnCerrarSesion);
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    private void lblCrearChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearChatMouseClicked
        // TODO add your handling code here:
        frmCrearChat crearChat = new frmCrearChat(usuario);
        crearChat.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_lblCrearChatMouseClicked

    private void lblCrearChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearChatMouseEntered
    recolorEnter(lblCrearChat, btnCrearChat);
    }//GEN-LAST:event_lblCrearChatMouseEntered

    private void lblCrearChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearChatMouseExited
    recolorExit(lblCrearChat, btnCrearChat);
    }//GEN-LAST:event_lblCrearChatMouseExited

    private void lblEntrarChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEntrarChatMouseClicked
        control.entrarChat(this, control.getChatSeleccionado(tblChats), tblChats, usuario.getId());
            frmChat chat = new frmChat(control.getChatSeleccionado(tblChats),usuario.getId(),control.getChatIngreso(control.getChatSeleccionado(tblChats)),usuario.getNombreUsuario(),usuario);
            chat.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_lblEntrarChatMouseClicked

    private void lblEntrarChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEntrarChatMouseEntered
        recolorEnter(lblEntrarChat, btnEntrarChat);
    }//GEN-LAST:event_lblEntrarChatMouseEntered

    private void lblEntrarChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEntrarChatMouseExited
        recolorExit(lblEntrarChat, btnEntrarChat);
    }//GEN-LAST:event_lblEntrarChatMouseExited

    private void lblUsuarioInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioInfoMouseEntered
        lblUsuarioInfo.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_lblUsuarioInfoMouseEntered

    private void lblUsuarioInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioInfoMouseExited
        lblUsuarioInfo.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblUsuarioInfoMouseExited

    private void lblUsuarioInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioInfoMouseClicked
        frmInfoUsuario usuarioInfo = new frmInfoUsuario(usuario);
        usuarioInfo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblUsuarioInfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel banner;
    private javax.swing.JPanel btnCerrarSesion;
    private javax.swing.JPanel btnCrearChat;
    private javax.swing.JPanel btnEntrarChat;
    private javax.swing.JPanel btnUsuarioInfo;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCrearChat;
    private javax.swing.JLabel lblEntrarChat;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblUsuarioInfo;
    private javax.swing.JTable tblChats;
    // End of variables declaration//GEN-END:variables

}
