/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.vistas;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import sistema.datos.fgastos;
import sistema.datos.fventas;
import sistema.datos.reportesDatos;

/**
 *
 * @author Usuario
 */
public class reporteGanancias extends javax.swing.JDialog {

    DecimalFormat formato = new DecimalFormat("0.00"); // para que aparescan solo 2 decimales a los montos
    
    /**
     * Creates new form reporteGanancias
     */
    public reporteGanancias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        grupoRadios = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        fecha1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        radioDia = new javax.swing.JRadioButton();
        radioRango = new javax.swing.JRadioButton();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblVenta = new javax.swing.JLabel();
        lblGasto = new javax.swing.JLabel();
        lblGanancia = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(237, 234, 218));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/imprimirAzul.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setIconTextGap(20);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fecha1.setForeground(new java.awt.Color(102, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha 1:");

        fecha2.setForeground(new java.awt.Color(102, 102, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha 2:");

        grupoRadios.add(radioDia);
        radioDia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radioDia.setSelected(true);
        radioDia.setText("Reporte del dia");
        radioDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioDiaMouseClicked(evt);
            }
        });
        radioDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDiaActionPerformed(evt);
            }
        });

        grupoRadios.add(radioRango);
        radioRango.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radioRango.setText("Reporte por fechas");
        radioRango.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioRangoMouseClicked(evt);
            }
        });
        radioRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRangoActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Buscar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioDia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(radioRango)))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioDia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioRango, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        jPanel2.setBackground(new java.awt.Color(85, 95, 128));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("RESULTADOS DE GANANCIAS:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Total Ventas:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Total Gastos:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("GANANCIA:");

        lblVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblVenta.setForeground(new java.awt.Color(204, 204, 204));
        lblVenta.setText("0.00");

        lblGasto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblGasto.setForeground(new java.awt.Color(204, 204, 204));
        lblGasto.setText("0.00");

        lblGanancia.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblGanancia.setForeground(new java.awt.Color(204, 204, 204));
        lblGanancia.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGanancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblVenta))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblGasto))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblGanancia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    reportesDatos objReporte = new reportesDatos();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
//        if (totalGasto==0.00) {
//           JOptionPane.showMessageDialog(null, "No se puede imprimir el documento, porque necesita mas información");
//            return;
//        }
        
        try{
            Calendar cal;
            int d,m,a;
            cal=fecha1.getCalendar();
            d=cal.get(Calendar.DAY_OF_MONTH);
            m=cal.get(Calendar.MONTH);
            a=cal.get(Calendar.YEAR) - 1900;
            String fecha=String.valueOf(new Date(a,m,d));

            if(radioDia.isSelected()){
                objReporte.imprimirGananciasDia(fecha, String.valueOf(totalGasto),String.valueOf(totalVenta),String.valueOf(formato.format(ganancia)));

            }else{
                cal=fecha2.getCalendar();
                d=cal.get(Calendar.DAY_OF_MONTH);
                m=cal.get(Calendar.MONTH);
                a=cal.get(Calendar.YEAR) - 1900;
                String fecha2=String.valueOf(new Date(a,m,d));
                objReporte.imprimirGananciasRango(fecha,fecha2, String.valueOf(totalGasto),String.valueOf(totalVenta),String.valueOf(formato.format(ganancia)));

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Las fechas deben ser válidas");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDiaMouseClicked
        // TODO add your handling code here:
        this.fecha2.setEnabled(false);
    }//GEN-LAST:event_radioDiaMouseClicked

    private void radioDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDiaActionPerformed

    private void radioRangoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioRangoMouseClicked
        // TODO add your handling code here:
        this.fecha2.setEnabled(true);
    }//GEN-LAST:event_radioRangoMouseClicked

    private void radioRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioRangoActionPerformed

    fventas objVenta = new fventas();
    fgastos objgasto = new fgastos();
     
    private double totalVenta = 0.00;
    private double totalGasto = 0.00;
    private double ganancia = 0.00;
        
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // limpiar variables para no ocacionar alteraciones de dinero
        totalVenta=0.00;
        totalGasto=0.00;
        ganancia=0.00;
        
        try{
            Calendar cal;
            int d,m,a;
            cal=fecha1.getCalendar();
            d=cal.get(Calendar.DAY_OF_MONTH);
            m=cal.get(Calendar.MONTH);
            a=cal.get(Calendar.YEAR) - 1900;
            String fecha=String.valueOf(new Date(a,m,d));

            if (radioDia.isSelected()) {

                try {
                    totalVenta = Double.parseDouble(objVenta.calculoTotalVenta(fecha));
                } catch (Exception e) {
                    System.out.println("error...");
                }

                try {
                    totalGasto = Double.parseDouble(objgasto.calculoTotalGasto(fecha));
                } catch (Exception e) {
                    System.out.println("error...");
                }


            }else{
                cal=fecha2.getCalendar();
                d=cal.get(Calendar.DAY_OF_MONTH);
                m=cal.get(Calendar.MONTH);
                a=cal.get(Calendar.YEAR) - 1900;
                String fecha2=String.valueOf(new Date(a,m,d));
                
                 try {
                    totalVenta = Double.parseDouble(objVenta.calculoTotalVenta(fecha,fecha2));
                } catch (Exception e) {
                    System.out.println("error...");
                }

                try {
                    totalGasto = Double.parseDouble(objgasto.calculoTotalGastoRango(fecha,fecha2));
                } catch (Exception e) {
                    System.out.println("error...");
                }
                
            }
            
            ganancia =totalVenta-totalGasto; 
            
            this.lblGanancia.setText(String.valueOf(formato.format(ganancia)));
            this.lblVenta.setText(String.valueOf(totalVenta));
            this.lblGasto.setText(String.valueOf(totalGasto));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Las fechas deben ser válidas");
        }
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(reporteGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reporteGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reporteGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reporteGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                reporteGanancias dialog = new reporteGanancias(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private com.toedter.calendar.JDateChooser fecha1;
    private com.toedter.calendar.JDateChooser fecha2;
    private javax.swing.ButtonGroup grupoRadios;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblGasto;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JRadioButton radioDia;
    private javax.swing.JRadioButton radioRango;
    // End of variables declaration//GEN-END:variables
}
