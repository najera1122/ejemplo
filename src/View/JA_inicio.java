/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates hola
 * and open the template in the editor.
 */
package View;

import Controller.EJefes;
import java.util.ArrayList;
import BD.Rjefes;
import BD.RegistrarIncidencia;
import javax.swing.DefaultComboBoxModel;
import Conexion.Conexion;
import Controller.EIncidencia;
import Controller.Render;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import View.Incidenciasgrupales;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Vertsequer
 */
public class JA_inicio extends javax.swing.JFrame {

    DefaultTableModel modeloincidenciasjefe = new DefaultTableModel(null, getColumas());
    public static ResultSet rs;
    private Connection userConn;
    private TableRowSorter trsFiltro;
    private PreparedStatement st;
    public static int idusuario;
    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement stmt;
    public static boolean TstVentNvoPres = false;
    int x, y;
    Incidenciasgrupales ing;

    public JA_inicio() {
        ing = new Incidenciasgrupales();
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(51, 102, 255));
        JTableHeader anHeader = tbIncidencias.getTableHeader();
        anHeader.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tbIncidencias.setRowHeight(25);
    
    
    }

    // clase columanas para el modelo de la tabla 
    private String[] getColumas() {
        String columna[] = {"ID", "Nombre", "Puesto", "Depto", "Detalles"};
        return columna;
    }//fin del clase

//calse para el filtro de busque en el modelo de la tabla 
    public void filtroBusqueda(JTextField txt) {
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt.getText()));
    }
    //fin clase filtro 

    //clase para cargar filas al modelo de la tabla 
    public void filas(int iduser) {
        tbIncidencias.setDefaultRenderer(Object.class, new Render());
        //añadimos boton a columna de la tabla 
        JButton btn1 = new JButton("Detalles");
        btn1.setName("Detalles");
        //boton
        try {
            String sql = "SELECT emp.empleadoId,emp.nombre,emp.puesto,emp.depto  from empleados emp  LEFT JOIN asignacion asg  ON emp.empleadoId = asg.empleadoId where emp.estatus = 1 AND asg.idUser='" + iduser + "'";
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            Object datos[] = new Object[6];
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    datos[0] = rs.getString("empleadoId");
                    datos[1] = rs.getString("nombre");
                    datos[2] = rs.getString("puesto");
                    datos[3] = rs.getString("depto");
                    datos[4] = btn1;
                }
                modeloincidenciasjefe.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println("" + e);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
    } //fin del la clase de filas 
    //<--clase para limpiar la tabla 

    public void limpiar(DefaultTableModel tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
            i -= 1;
        }

    }
// fin clase limpiar -->

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pmiRegistrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnminimizar = new javax.swing.JButton();
        btncerrar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblnombrejefe = new javax.swing.JTextField();
        lblcargojefe = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbIncidencias = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        pmiRegistrar.setText("Insertar Incidencia");
        pmiRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pmiRegistrarMouseClicked(evt);
            }
        });
        pmiRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmiRegistrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmiRegistrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1360, 465));

        jPanel1.setBackground(new java.awt.Color(229, 230, 234));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/portafolio.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/user.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        btnminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/minimizar.png"))); // NOI18N
        btnminimizar.setBorderPainted(false);
        btnminimizar.setContentAreaFilled(false);
        btnminimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnminimizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 32, 30));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/error.png"))); // NOI18N
        btncerrar.setBorderPainted(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 32, 30));

        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/regresar.png"))); // NOI18N
        btnregresar.setBorderPainted(false);
        btnregresar.setContentAreaFilled(false);
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 32, 30));

        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel6MouseDragged(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 50));

        lblnombrejefe.setEditable(false);
        lblnombrejefe.setBackground(new java.awt.Color(229, 230, 234));
        lblnombrejefe.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblnombrejefe.setForeground(new java.awt.Color(51, 102, 255));
        lblnombrejefe.setAutoscrolls(false);
        lblnombrejefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 102, 255)));
        lblnombrejefe.setCaretColor(new java.awt.Color(51, 102, 255));
        jPanel1.add(lblnombrejefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 320, 20));

        lblcargojefe.setEditable(false);
        lblcargojefe.setBackground(new java.awt.Color(229, 230, 234));
        lblcargojefe.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblcargojefe.setForeground(new java.awt.Color(51, 102, 255));
        lblcargojefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 102, 255)));
        lblcargojefe.setCaretColor(new java.awt.Color(51, 102, 255));
        jPanel1.add(lblcargojefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 330, 20));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(910, 610));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(238, 240, 245));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbIncidencias= new javax.swing.JTable(){
            public boolean  isCellEditable(int rowIndex,int conlIndex ){
                return false;
            }
        };
        tbIncidencias.setAutoCreateRowSorter(true);
        tbIncidencias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbIncidencias.setForeground(new java.awt.Color(51, 51, 51));
        tbIncidencias.setModel(modeloincidenciasjefe);
        tbIncidencias.setComponentPopupMenu(jPopupMenu1);
        tbIncidencias.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        tbIncidencias.setFillsViewportHeight(true);
        tbIncidencias.setGridColor(new java.awt.Color(255, 255, 255));
        tbIncidencias.setInheritsPopupMenu(true);
        tbIncidencias.setIntercellSpacing(new java.awt.Dimension(2, 2));
        tbIncidencias.setSelectionBackground(new java.awt.Color(108, 180, 221));
        tbIncidencias.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbIncidencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIncidenciasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbIncidencias);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1340, 310));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 340));

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/search1.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 40, 40));

        txtBuscar.setBackground(new java.awt.Color(51, 102, 255));
        txtBuscar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel4.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 250, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btnminimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnminimizarActionPerformed
        this.setExtendedState(ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_btnminimizarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        Jflogin us = new Jflogin();
        us.show(true);
        this.show(false);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void jLabel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel6MouseDragged

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
      //parametros para mover ventanas del Frame
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel6MousePressed

    private void pmiRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pmiRegistrarMouseClicked

    }//GEN-LAST:event_pmiRegistrarMouseClicked

    private void pmiRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmiRegistrarActionPerformed
// insercon de incidencias por grupos e individuales
        int cuentaFilasSeleccionadas = tbIncidencias.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 1) {
            int fila = tbIncidencias.getSelectedRow();
            String empid = tbIncidencias.getValueAt(fila, 0).toString();
            String nombre = tbIncidencias.getValueAt(fila, 1).toString();
            select_incidencia slc = new select_incidencia();
            slc.show();
            slc.mostrardatos(empid, nombre);
        } else {

            TableModel model1 = tbIncidencias.getModel();
            int indexs[] = tbIncidencias.getSelectedRows();
            Object[] row = new Object[4];

            DefaultTableModel model2 = (DefaultTableModel) ing.jtbdatosgrupos.getModel();

            for (int i = 0; i < indexs.length; i++) {
                row[0] = model1.getValueAt(indexs[i], 0);
                row[1] = model1.getValueAt(indexs[i], 1);

                model2.addRow(row);
            }

            ing.setVisible(true);

        }

    }//GEN-LAST:event_pmiRegistrarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
      //filtro de busqueda en el modelo de la tabla
        txtBuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {

                repaint();
                filtroBusqueda(txtBuscar);
            }
        });
        trsFiltro = new TableRowSorter(tbIncidencias.getModel());
        tbIncidencias.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tbIncidenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbIncidenciasMouseClicked
        int column = tbIncidencias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbIncidencias.getRowHeight();
        Calendar calendario = Calendar.getInstance();
        if (row < tbIncidencias.getRowCount() && row >= 0 && column < tbIncidencias.getColumnCount() && column >= 0) {
            Object value = tbIncidencias.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("Detalles")) {

                    String nombreusr = tbIncidencias.getValueAt(row, 1).toString();
                    String pof = tbIncidencias.getValueAt(row, 2).toString();
                    String iduser = tbIncidencias.getValueAt(row, 0).toString();
                    int año = calendario.get(Calendar.YEAR);
                    destallesJA dtm = new destallesJA();
                    destallesJA.txtnombre.setText(nombreusr);
                    destallesJA.txtidempleado.setText(iduser);
                    dtm.setVisible(true);
                }
            }
            if (value instanceof JCheckBox) {
                JCheckBox ch = (JCheckBox) value;
                if (ch.isSelected() == true) {
                    ch.setSelected(false);
                }
                if (ch.isSelected() == false) {
                    ch.setSelected(true);
                }

            }
        }
    }//GEN-LAST:event_tbIncidenciasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JA_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JA_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JA_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JA_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JA_inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncerrar;
    public static javax.swing.JButton btnminimizar;
    public static javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTextField lblcargojefe;
    public static javax.swing.JTextField lblnombrejefe;
    private javax.swing.JMenuItem pmiRegistrar;
    private javax.swing.JTable tbIncidencias;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
