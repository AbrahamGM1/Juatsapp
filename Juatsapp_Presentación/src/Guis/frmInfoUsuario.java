/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guis;

import Dominio.Usuarios;
import static Guis.frmMenu.usuariosDAO;
import Negocio.ctrlInfoUsuario;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Abraham
 */
public class frmInfoUsuario extends javax.swing.JFrame {

    int xMouse, yMouse;
    Usuarios usuario;
    ctrlInfoUsuario control = new ctrlInfoUsuario();

    public frmInfoUsuario(Usuarios usuario) {
        initComponents();
        this.usuario = usuario;
        llenarcombo();
        control.llenarFormulario(usuario, txtNombre, txtNombreUsuario, txtCorreo, txtEdad, cbSexo);
        control.bloquear(txtNombre, txtNombreUsuario, txtCorreo, txtEdad, cbSexo, lblGuardar, btnGuardar);

    }

    public void recolorExit(JLabel label, JPanel boton) {
        label.setForeground(new Color(204, 255, 255));
        boton.setBackground(new Color(0, 204, 255));
    }

    public void recolor(JLabel label, JPanel boton) {
        label.setForeground(Color.white);
        boton.setBackground(Color.blue);
    }

    public void llenarFormulario() {
        this.txtNombre.setText(usuario.getNombre());
        this.txtNombreUsuario.setText(usuario.getNombreUsuario());
        this.txtCorreo.setText(usuario.getCorreo());
        this.txtEdad.setText(usuario.getEdad());
        if (usuario.getSexo().equalsIgnoreCase("hombre")) {
            this.cbSexo.setSelectedIndex(0);
        } else if (usuario.getSexo().equalsIgnoreCase("mujer")) {
            this.cbSexo.setSelectedIndex(1);
        } else if (usuario.getSexo().equalsIgnoreCase("robot")) {
            this.cbSexo.setSelectedIndex(2);
        }
    }


    public void actualizar() {
        String nombre = this.txtNombre.getText();
        String nombreUsuario = this.txtNombreUsuario.getText();
        String correo = this.txtCorreo.getText();
        String edad = this.txtEdad.getText();
        String sexo = "";
        switch (this.cbSexo.getSelectedIndex()) {
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
            JOptionPane.showMessageDialog(this, "Llene todos los campos por favor", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
        } else {
            usuario=usuariosDAO.actualizar(usuario.getId(), nombre, nombreUsuario, correo, edad, sexo);
            JOptionPane.showMessageDialog(this, "Usuario Actualizado", "JUATSAPP DICE", JOptionPane.WARNING_MESSAGE);
            bloquear();
        }

    }

    public void bloquear() {
        this.txtNombre.setEnabled(false);
        this.txtNombre.setEditable(false);
        this.txtNombreUsuario.setEnabled(false);
        this.txtNombreUsuario.setEditable(false);
        this.txtCorreo.setEnabled(false);
        this.txtCorreo.setEditable(false);
        this.txtEdad.setEnabled(false);
        this.txtEdad.setEditable(false);
        this.cbSexo.setEnabled(false);
        this.cbSexo.setEditable(false);
        this.lblGuardar.setEnabled(false);
        this.btnGuardar.setEnabled(false);
    }

    public void desbloquear() {
        this.txtNombre.setEnabled(true);
        this.txtNombre.setEditable(true);
        this.txtNombreUsuario.setEnabled(true);
        this.txtNombreUsuario.setEditable(true);
        this.txtCorreo.setEnabled(true);
        this.txtCorreo.setEditable(true);
        this.txtEdad.setEnabled(true);
        this.txtEdad.setEditable(true);
        this.cbSexo.setEnabled(true);
        this.lblGuardar.setEnabled(true);
        this.btnGuardar.setEnabled(true);
    }
    ///TO DO, VOLVER LOS GENEROS NUMEROS, SI EL NUMERO ES 0, POSICION 0, SI EL NUMERO ES 1 POSICION 1

    public void llenarcombo() {
        this.cbSexo.addItem("Hombre");
        this.cbSexo.addItem("Mujer");
        this.cbSexo.addItem("Robot");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        salir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();
        btnRestablecer = new javax.swing.JPanel();
        lblRestablecer = new javax.swing.JLabel();
        btnEditar = new javax.swing.JPanel();
        lblEditar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cbSexo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
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
            .addComponent(txtSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
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
                .addGap(0, 562, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 40));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFORMACIÓN DE USUARIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 70));

        btnGuardar.setBackground(new java.awt.Color(0, 204, 255));

        lblGuardar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(204, 255, 255));
        lblGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGuardar.setText("GUARDAR");
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnGuardarLayout = new javax.swing.GroupLayout(btnGuardar);
        btnGuardar.setLayout(btnGuardarLayout);
        btnGuardarLayout.setHorizontalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGuardarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnGuardarLayout.setVerticalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGuardarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 130, -1));

        btnRestablecer.setBackground(new java.awt.Color(0, 204, 255));

        lblRestablecer.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblRestablecer.setForeground(new java.awt.Color(204, 255, 255));
        lblRestablecer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestablecer.setText("RESTABLECER");
        lblRestablecer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRestablecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestablecerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRestablecerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRestablecerMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRestablecerLayout = new javax.swing.GroupLayout(btnRestablecer);
        btnRestablecer.setLayout(btnRestablecerLayout);
        btnRestablecerLayout.setHorizontalGroup(
            btnRestablecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRestablecerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnRestablecerLayout.setVerticalGroup(
            btnRestablecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRestablecerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 130, -1));

        btnEditar.setBackground(new java.awt.Color(0, 204, 255));

        lblEditar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(204, 255, 255));
        lblEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditar.setText("EDITAR");
        lblEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 130, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("NOMBRE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("CORREO ELECTRÓNICO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("NOMBRE DE USUARIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 255));
        jLabel5.setText("EDAD:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("SEXO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, 40));

        txtNombreUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 230, 30));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 30));

        txtEdad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 60, 30));

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 230, 30));

        cbSexo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });
        jPanel1.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseClicked
        llenarFormulario();
        frmUsuarioChats uchats=new frmUsuarioChats(usuario);
        this.dispose();
        uchats.setVisible(true);
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
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        control.actualizar(this, usuario, txtNombre, txtNombreUsuario, txtCorreo, txtEdad, cbSexo, lblGuardar, btnGuardar);
        this.usuario=control.getUsuario();
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void lblGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseEntered
        recolor(lblGuardar, btnGuardar);
    }//GEN-LAST:event_lblGuardarMouseEntered

    private void lblGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseExited
        recolorExit(lblGuardar, btnGuardar);

    }//GEN-LAST:event_lblGuardarMouseExited

    private void lblRestablecerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestablecerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRestablecerMouseClicked

    private void lblRestablecerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestablecerMouseEntered
        recolor(lblRestablecer, btnRestablecer);
    }//GEN-LAST:event_lblRestablecerMouseEntered

    private void lblRestablecerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestablecerMouseExited
        // TODO add your handling code here:
        recolorExit(lblRestablecer, btnRestablecer);
    }//GEN-LAST:event_lblRestablecerMouseExited

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        // TODO add your handling code here:
        desbloquear();
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseEntered
        recolor(lblEditar, btnEditar);
    }//GEN-LAST:event_lblEditarMouseEntered

    private void lblEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseExited
        recolorExit(lblEditar, btnEditar);
    }//GEN-LAST:event_lblEditarMouseExited

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSexoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEditar;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JPanel btnRestablecer;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblRestablecer;
    private javax.swing.JPanel salir;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JLabel txtSalir;
    // End of variables declaration//GEN-END:variables
}
