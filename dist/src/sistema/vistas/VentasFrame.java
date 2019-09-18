package sistema.vistas;

import com.toedter.calendar.JCalendar;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import sistema.datos.baseDatos;
import sistema.datos.fdetalleventas;
import sistema.datos.finventario;
import sistema.datos.fventas;
import sistema.datos.productosVendidos;
import sistema.pojos.Ddetalle_ventas;
import sistema.pojos.Productos;
import sistema.pojos.Dventas;
import sistema.pojos.productosMasVendidos;

public class VentasFrame extends javax.swing.JFrame {

    /* en el modelo dela tabla sobreescribimos el metodo isCellEditable 
     para que la tabla no se pueda editar manualmente*/
    DefaultTableModel modeloTablaProducto = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultListModel<Productos> modeloListaProducto = new DefaultListModel<Productos>();
    baseDatos base = new baseDatos();
    fventas objVenta = new fventas();
    fdetalleventas objDetalle = new fdetalleventas();
    finventario inventario = new finventario();
    DecimalFormat formato = new DecimalFormat("0.00"); // para que aparescan solo 2 decimales a los montos

    /**
     * Creates new form Ventas
     */
    public VentasFrame() {
        cargarColumnasTabla();
        cargarListenerModeloTabla();
        initComponents();
        this.setDefaultCloseOperation(1);
        this.setLocationRelativeTo(null);
    }
    

    private void cargarListenerModeloTabla() {
        modeloTablaProducto.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int numFila = modeloTablaProducto.getRowCount();

                //variable de la sumatoria de la venta
                double suma = 0;
                for (int i = 0; i < numFila; i++) {
                    String importe = (String) modeloTablaProducto.getValueAt(i, 4);
                    suma += Double.parseDouble(importe);

                }
                
                String total = formato.format(suma);
                lblTotalVenta.setText(total);
            }
        });

    }
    
    private void cargarColumnasTabla() {
        modeloTablaProducto.addColumn("Clave");
        modeloTablaProducto.addColumn("Producto");
        modeloTablaProducto.addColumn("Precio venta");
        modeloTablaProducto.addColumn("Cantidad");
        modeloTablaProducto.addColumn("Importe");
        modeloTablaProducto.addColumn("Tipo");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarProd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        txtPagaCon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnQuitarProd = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();
        btnRealizarVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProducto = new javax.swing.JList<>();
        comboVenta = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboPago = new javax.swing.JComboBox<>();
        btnQuitarProd1 = new javax.swing.JButton();
        btnQuitarProd2 = new javax.swing.JButton();

        setTitle("Ventas");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaVenta.setBackground(new java.awt.Color(255, 255, 255));
        tablaVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tablaVenta.setForeground(new java.awt.Color(0, 0, 0));
        tablaVenta.setModel(modeloTablaProducto);
        tablaVenta.setGridColor(new java.awt.Color(255, 255, 255));
        tablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaVentaMousePressed(evt);
            }
        });
        tablaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaVentaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVenta);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/icons8_Search_32px.png"))); // NOI18N
        jLabel1.setText("Buscar productos:");

        txtBuscarProd.setBackground(new java.awt.Color(238, 236, 236));
        txtBuscarProd.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtBuscarProd.setToolTipText("Escriba el nombre o codigo del producto...");
        txtBuscarProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(85, 95, 128));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total venta:");

        lblTotalVenta.setFont(new java.awt.Font("Tahoma", 0, 56)); // NOI18N
        lblTotalVenta.setForeground(new java.awt.Color(255, 255, 0));
        lblTotalVenta.setText("0.00");
        lblTotalVenta.setToolTipText("Total a pagar ...");

        txtPagaCon.setBackground(new java.awt.Color(238, 236, 236));
        txtPagaCon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPagaCon.setToolTipText("Efectivo $....");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Paga con:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        btnQuitarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnQuitarProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuitarProd.setText("Quitar Producto");
        btnQuitarProd.setToolTipText("Seléccione un producto");
        btnQuitarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProdActionPerformed(evt);
            }
        });

        btnCancelarVenta.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelarVenta.setText("Cancelar venta");
        btnCancelarVenta.setToolTipText("Elimina todos los productos");
        btnCancelarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        btnRealizarVenta.setBackground(new java.awt.Color(204, 204, 204));
        btnRealizarVenta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRealizarVenta.setText("Realizar venta");
        btnRealizarVenta.setToolTipText("Guardar la venta...");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(85, 95, 128));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblImagen.setBackground(new java.awt.Color(4, 161, 161));
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/carritoVenta.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        listaProducto.setBackground(new java.awt.Color(85, 95, 128));
        listaProducto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        listaProducto.setForeground(new java.awt.Color(243, 243, 243));
        listaProducto.setModel(modeloListaProducto);
        listaProducto.setToolTipText("Resultado de busqueda...");
        listaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaProductoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listaProducto);

        comboVenta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Comprobante Fiscal" }));
        comboVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel3.setText("Tipo de Venta:");

        jLabel5.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de pago:");

        comboPago.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Al Crédito" }));
        comboPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnQuitarProd1.setBackground(new java.awt.Color(204, 204, 204));
        btnQuitarProd1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuitarProd1.setText("Cambiar cantidad");
        btnQuitarProd1.setToolTipText("Seléccione un producto");
        btnQuitarProd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarProd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProd1ActionPerformed(evt);
            }
        });

        btnQuitarProd2.setBackground(new java.awt.Color(204, 204, 204));
        btnQuitarProd2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuitarProd2.setText("Cambiar Precio");
        btnQuitarProd2.setToolTipText("Seléccione un producto");
        btnQuitarProd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarProd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProd2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                    .addComponent(txtBuscarProd))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(comboPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboVenta, 0, 230, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnQuitarProd2)
                        .addGap(22, 22, 22)
                        .addComponent(btnQuitarProd1)
                        .addGap(22, 22, 22)
                        .addComponent(btnQuitarProd)
                        .addGap(22, 22, 22)
                        .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarProd2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtBuscarProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdKeyReleased
        /* este evento es para el buscador del producto, cuando el usuario escribe
       y suelta la tecla se activa:  */

        modeloListaProducto.removeAllElements();

        String campoBuscar = txtBuscarProd.getText().toLowerCase();
        // obtener los productos de base datos atraves del arraylist
        ArrayList<Productos> listaProducto = base.obtenerProductosCriterio(campoBuscar);
        if (campoBuscar.isEmpty()) {
            modeloListaProducto.removeAllElements();
        } else {
            // recorremos el foreach con toda su lista de prod
            for (Productos producto : listaProducto) {
                modeloListaProducto.addElement(producto); // añadimos el objeto
            }
        }
    }//GEN-LAST:event_txtBuscarProdKeyReleased

    // añadir producto a tabla y mostrar foto
    private void listaProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProductoMousePressed
        // evento cuando se le da doble clic alos productos:
        JList lista = (JList) evt.getSource();
        int index = lista.locationToIndex(evt.getPoint());
        Productos prod = (Productos) lista.getSelectedValue();

        if (evt.getClickCount() == 2) { //añadir producto a tabla
            // cuando da 2 clic
            anadirProducto(prod);
        }
        if (evt.getClickCount() == 1) {
            // cuando da 1 clic
        }
    }//GEN-LAST:event_listaProductoMousePressed

    private void tablaVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaVentaKeyReleased
        // Evento cuando se selecciona un producto de la tabla y preciona f2 para modificar cantidad:
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            int filaSeleccionada = tablaVenta.getSelectedRow();
            cambiarCantidad(filaSeleccionada);
        }
        
    }//GEN-LAST:event_tablaVentaKeyReleased

    // evento para cambiar el total de venta
    private void cambiarCantidad(int filaSelec) {
        String cantidad = JOptionPane.showInputDialog("Modificar cantidad");
        if (cantidad.isEmpty()) {
            return;
        }
        try {
            String precioVenta = (String) modeloTablaProducto.getValueAt(filaSelec, 2);
            
            double importe = Double.parseDouble(cantidad) * Double.parseDouble(precioVenta);
            String importeCover = String.valueOf(importe);
            modeloTablaProducto.setValueAt(cantidad, filaSelec, 3);
            modeloTablaProducto.setValueAt(importeCover, filaSelec, 4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar números válidos...");
        }
    }
    // evento para cambiar el total de venta
    private void cambiarPrecio(int filaSelec) {
        String nuevoPrecio = JOptionPane.showInputDialog("Modificar Precio");
        if (nuevoPrecio.isEmpty()) {
            return;
        }
        try {
            String cantidadProductos = (String) modeloTablaProducto.getValueAt(filaSelec, 3);
            double importe = Double.parseDouble(cantidadProductos) * Double.parseDouble(nuevoPrecio);
            String importeCover = String.valueOf(importe);
            modeloTablaProducto.setValueAt(nuevoPrecio, filaSelec, 2);
            modeloTablaProducto.setValueAt(importeCover, filaSelec, 4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar números válidos...");
        }
    }

    private void tablaVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentaMousePressed
        // este codigo es igual al de arriva:
        // Evento cuando se selecciona un producto de la tabla y preciona f2 para modificar cantidad:
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tablaVenta.getSelectedRow();
            cambiarPrecio(filaSeleccionada);
        }
         
    }//GEN-LAST:event_tablaVentaMousePressed

    private void btnQuitarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProdActionPerformed
        // quitar productos de la tabla:
        int cantidadFila = modeloTablaProducto.getRowCount();
        int filaSeleccionada = tablaVenta.getSelectedRow();

        if ((cantidadFila > 0) && (filaSeleccionada >= 0)) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el producto?");

            if (opcion == 0) {
                modeloTablaProducto.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_btnQuitarProdActionPerformed


    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        // cancelar toda la venta:

        int cantidaFilas = modeloTablaProducto.getRowCount();

        if (cantidaFilas > 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el producto?");

            if (opcion == 0) {
                //recorre todas las filas del modelo y las borra de la ultima asta la primera
                for (int i = cantidaFilas - 1; i >= 0; i--) {
                    modeloTablaProducto.removeRow(i);
                }
            }
        }


    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
      // guardar venta:
        String sumatoria = lblTotalVenta.getText();
        double total = Double.parseDouble(sumatoria);
        if (total == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos en la venta..");
            return;
        }

        //calcular el cambio 
        String pagaConStr = txtPagaCon.getText();
        double cambio = 0.0;

        // obtener la fecha actual...
        Calendar calendarioLocal = Calendar.getInstance();
        java.util.Date fechaActual = calendarioLocal.getTime();
        long fechaMilisegundo = fechaActual.getTime();

        java.sql.Date fecha = new Date(fechaMilisegundo);
        String fechaCadena = String.valueOf(fecha);
        
        JCalendar calendario = new JCalendar();

        calendario.setDate(Date.valueOf(fechaCadena));


        String tipoVenta = String.valueOf(comboVenta.getSelectedItem().toString());
        String tipoPago = String.valueOf(comboPago.getSelectedItem().toString());
        
        
        //guardar venta
        Dventas venta = new Dventas();
        venta.setFecha(fecha);
        venta.setMonto(total);
        venta.setTipo_pago(tipoVenta);
        venta.setTipo_venta(tipoPago);
        int idVenta = objVenta.insertarVenta(venta);

        int cantidadFilas = modeloTablaProducto.getRowCount();

        // for para guardar todos los detalles
        for (int i = 0; i < cantidadFilas; i++) {
            String idProd = (String) modeloTablaProducto.getValueAt(i, 0);
            String cantidad = (String) modeloTablaProducto.getValueAt(i, 3);
            String importe = (String) modeloTablaProducto.getValueAt(i, 4);
            String tipoRegistro = (String) modeloTablaProducto.getValueAt(i, 5);

            //llenar el constructor
            Ddetalle_ventas detalleVenta = new Ddetalle_ventas();
            detalleVenta.setIdproducto(Integer.parseInt(idProd));
            detalleVenta.setIdventa(idVenta);
            detalleVenta.setCantidad(Integer.parseInt(cantidad));
            detalleVenta.setImporte(Double.parseDouble(importe));

            //agregar al detalle de venta
            objDetalle.insertarDetalle(detalleVenta);
            //disminuir inventario
            int codProd = Integer.parseInt(idProd);
            double cant = Double.parseDouble(cantidad);
            
            if(!tipoRegistro.equals("servicio")){  //si es servicio no disminuir existencias
                 inventario.disminuirInventario(codProd, cant);
                 
                 // productos mas vendidos
                productosVendidos obj = new productosVendidos();
                productosMasVendidos obj2 = new productosMasVendidos();

                obj2.setIdProducto(codProd);
                obj2.setCantidad(cant);
                obj.insertarProductosMasVendido(obj2,fechaCadena);
            }

        }

        for (int i = cantidadFilas - 1; i >= 0; i--) {
            modeloTablaProducto.removeRow(i);
        }
        lblTotalVenta.setText("0.0");

        // verificar si el proceso es para un credito
        if (!tipoPago.equals("Efectivo")) {
            System.out.println("Este cliente se debe crear un credito.....");
   
            CreditosFrame credito = new CreditosFrame();
            credito.txtCodigoVenta.setText(String.valueOf(idVenta));
            credito.txtCodigoVenta.setEnabled(false);
            credito.dcfecha.setDate(fecha);
            credito.txtMontoCredito.setText(String.valueOf(total));
            credito.tablaCreditos.setVisible(false);
            credito.setTitle("Guardar Creditos");
            credito.setVisible(true);

        } else {
            //preguntar si el pagacon esta vacio
            if (!pagaConStr.isEmpty()) {
                double montoPago = Double.parseDouble(pagaConStr);
                cambio = montoPago - total;
                String CambioCadena = formato.format(cambio);
                JOptionPane.showMessageDialog(this, "<html><h1 style='font-size:100 px; color:blue'>$ " + CambioCadena + "</h1></html>", "Venta guardada. Este es el cambio:", 1);
                txtPagaCon.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Venta guardada...");
            }
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnQuitarProd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProd1ActionPerformed
        // TODO add your handling code here:
       int cantidadFila = modeloTablaProducto.getRowCount();
        int filaSeleccionada = tablaVenta.getSelectedRow();

        if ((cantidadFila > 0) && (filaSeleccionada >= 0)) {
            cambiarCantidad(filaSeleccionada);
        }
    }//GEN-LAST:event_btnQuitarProd1ActionPerformed

    private void btnQuitarProd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProd2ActionPerformed
        // TODO add your handling code here:
        int cantidadFila = modeloTablaProducto.getRowCount();
        int filaSeleccionada = tablaVenta.getSelectedRow();

        if ((cantidadFila > 0) && (filaSeleccionada >= 0)) {
            cambiarPrecio(filaSeleccionada);
        }
    }//GEN-LAST:event_btnQuitarProd2ActionPerformed

    // metodo para añadir productos a tabla de venta
    private void anadirProducto(Productos prod) {
        String codigo = String.valueOf(prod.getIdProducto());
        String nombre = prod.getNombreProduc();
        String medida = prod.getMedidaProduc();
        String marca = prod.getNombreMarca();
        String producto = nombre +" "+ medida +" "+ marca;
        String precio = String.valueOf(prod.getPrecioSujerido());
        String importe = String.valueOf(prod.getPrecioSujerido());
        String tipo = String.valueOf(prod.getTipoRegistro());

        // arego de tipo string con todos los datos..
        String[] listaProductos = {codigo, producto, precio, "1", importe,tipo};
        // le pasamos el array al modelo de la tabla
        modeloTablaProducto.addRow(listaProductos);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnQuitarProd;
    private javax.swing.JButton btnQuitarProd1;
    private javax.swing.JButton btnQuitarProd2;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JComboBox<String> comboPago;
    private javax.swing.JComboBox<String> comboVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JList<Productos> listaProducto;
    private javax.swing.JTable tablaVenta;
    private javax.swing.JTextField txtBuscarProd;
    private javax.swing.JTextField txtPagaCon;
    // End of variables declaration//GEN-END:variables

}