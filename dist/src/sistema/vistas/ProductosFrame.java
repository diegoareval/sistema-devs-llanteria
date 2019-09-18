package sistema.vistas;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sistema.datos.baseDatos;
import sistema.pojos.Calidad;
import sistema.pojos.Categorias;
import sistema.pojos.Marcas;
import sistema.pojos.Productos;
import sistema.pojos.Proveedores;

/**
 *
 * @author Cristhian
 */
public class ProductosFrame extends javax.swing.JDialog {

    baseDatos base = new baseDatos();
    DefaultComboBoxModel<Categorias> modeloCategoria;
    DefaultComboBoxModel<Marcas> modeloMarca;
    DefaultComboBoxModel<Proveedores> modeloProveedor;
    DefaultComboBoxModel<Calidad> modeloCalidad;
    DefaultTableModel modeloTabla = new DefaultTableModel(); // para crear la tabla
    Productos productoSeleccionado = null; // marca que se seleccione en la tabla

    /**
     * Creates new form ProductosFrame
     */
    public ProductosFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        modeloCategoria = new DefaultComboBoxModel<Categorias>();
        modeloMarca = new DefaultComboBoxModel<Marcas>();
        modeloProveedor = new DefaultComboBoxModel<Proveedores>();
        modeloCalidad = new DefaultComboBoxModel<Calidad>();

        //cargar modelos
        cargarModeloCalidad();
        cargarModeloCat();
        cargarModeloMarca();
        cargarModeloProv();
        cargarColumnas();
        cargarModeloTablaProduc();
        //inicia la carga de ontroles
        initComponents();
        this.setLocationRelativeTo(null);
        this.btnActualizar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        //desactivarTexboxs();
    }

    private void cargarColumnas() {
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Producto");
        //modeloTabla.addColumn("Medida");
        modeloTabla.addColumn("Precio Compra");
        modeloTabla.addColumn("Precio Sugerido");
        
    }

    private void cargarModeloTablaProduc() {
        limpiarTabla();
        ArrayList<Productos> listado = base.obtenerProductosCriterio("");

        int numeroFilas = listado.size();
        modeloTabla.setNumRows(numeroFilas);

        for (int i = 0; i < numeroFilas; i++) {
            Productos producto = listado.get(i);

            int codigo = producto.getIdProducto();
            //String medida = producto.getMedidaProduc();
            double precioCompra = producto.getPrecioCompra();
            double precioSuj = producto.getPrecioSujerido();

            modeloTabla.setValueAt(codigo, i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(precioCompra, i, 2);
            modeloTabla.setValueAt(precioSuj, i, 3);

        }

    }

    private void limpiarTabla() {
        int numFila = modeloTabla.getRowCount(); // cantidad de filas
        if (numFila > 0) {
            // debe de ser i mayor o igual a cero
            for (int i = numFila - 1; i >= 0; i--) { // recorre de mayor a menor
                modeloTabla.removeRow(i); // borra la fila
            }
        }
    }

    private void cargarModeloCalidad() {
        limpiarModeloCalidad(modeloCalidad);

        ArrayList<Calidad> listaCalidad;
        listaCalidad = base.obtenerCalidad("");

        ArrayList<Calidad> listaSeleccionada;

        for (Calidad calidad : listaCalidad) {

            modeloCalidad.addElement(calidad);
        }

        if (productoSeleccionado != null) {
            for (Calidad calidad : listaCalidad) {

                if (productoSeleccionado.getIdCalidad() == calidad.getIdCalidad()) {
                    modeloCalidad.setSelectedItem(calidad);
                }
            }

        }
    }

    //limpiar modelos
    private void limpiarModeloCalidad(DefaultComboBoxModel modelo) {
        int numFila = modelo.getSize(); // cantidad de filas
        if (numFila > 0) {
            // debe de ser i mayor o igual a cero
            for (int i = numFila - 1; i >= 0; i--) { // recorre de mayor a menor
                modelo.removeElementAt(i); // borra la fila
            }
        }
    }

    private void cargarModeloMarca() {
        limpiarModeloCalidad(modeloMarca);
        ArrayList<Marcas> listaMarca;
        listaMarca = base.obtenerMarca("");

        ArrayList<Marcas> listaSeleccionada;

        for (Marcas mar : listaMarca) {

            modeloMarca.addElement(mar);
        }

        if (productoSeleccionado != null) {
            for (Marcas marca : listaMarca) {

                if (productoSeleccionado.getIdMarca() == marca.getIdMarca()) {
                    modeloMarca.setSelectedItem(marca);
                }
            }

        }
    }

    private void cargarModeloProv() {
        limpiarModeloCalidad(modeloProveedor);
        ArrayList<Proveedores> listaProv;
        listaProv = base.obtenerProveedores("");

        ArrayList<Proveedores> listaSeleccionada;

        for (Proveedores prov : listaProv) {

            modeloProveedor.addElement(prov);
        }

        if (productoSeleccionado != null) {
            for (Proveedores proveedor : listaProv) {

                if (productoSeleccionado.getIdProveedor() == proveedor.getIdProveedor()) {
                    modeloProveedor.setSelectedItem(proveedor);
                }
            }

        }
    }

    private void cargarModeloCat() {
        limpiarModeloCalidad(modeloCategoria);
        ArrayList<Categorias> listaCategoria;
        listaCategoria = base.obtenerCategorias("");

        ArrayList<Categorias> listaSeleccionada;

        for (Categorias categoria : listaCategoria) {

            modeloCategoria.addElement(categoria);
        }

        if (productoSeleccionado != null) {
            for (Categorias categoria : listaCategoria) {

                if (productoSeleccionado.getIdCategoria() == categoria.getIdCategoria()) {
                    modeloCategoria.setSelectedItem(categoria);
                }
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadios = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMedida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioSujerido = new javax.swing.JTextField();
        txtStocks = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAveriado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        javax.swing.JComboBox<Marcas> comboMarca = new javax.swing.JComboBox<>();
        javax.swing.JComboBox<Categorias> comboCategoria = new javax.swing.JComboBox<>();
        javax.swing.JComboBox<Proveedores> comboProveedor = new javax.swing.JComboBox<>();
        javax.swing.JComboBox<Calidad> comboCalidad = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        radioProducto = new javax.swing.JRadioButton();
        radioServicio = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtCriterioProducto = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Poducto:");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel1.setText("Medida:");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel3.setText("Precio de Compra:");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel4.setText("Precio Sugerido:");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel10.setText("Stocks:");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel11.setText("Averiado?");

        comboMarca.setModel(modeloMarca);

        comboCategoria.setModel(modeloCategoria);

        comboProveedor.setModel(modeloProveedor);

        comboCalidad.setModel(modeloCalidad);

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setIconTextGap(20);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel12.setText("Marca:");

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel13.setText("Categoria:");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel14.setText("Proveedor:");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel15.setText("Calidad del producto:");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/nuevo.GIF"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.setToolTipText("Nuevo Producto...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        grupoRadios.add(radioProducto);
        radioProducto.setSelected(true);
        radioProducto.setText("Productos");
        radioProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioProductoMouseClicked(evt);
            }
        });

        grupoRadios.add(radioServicio);
        radioServicio.setText("Servicios");
        radioServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioServicioMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/Inventarios.png"))); // NOI18N
        lblImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dotum", 1, 14)); // NOI18N
        jLabel5.setText("Seléccione el tipo de registro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtAveriado))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPrecioSujerido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMedida, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(comboCalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStocks)
                            .addComponent(jLabel12)
                            .addComponent(comboMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioProducto)
                            .addComponent(radioServicio)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioSujerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAveriado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)
                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(85, 95, 128));

        tablaProductos.setModel(modeloTabla);
        tablaProductos.setToolTipText("Selecciona un registro...");
        //Este codigo se coloca en la tabla en su propiedad Post-Init-Code
        tablaProductos.getSelectionModel().addListSelectionListener( // capturamos la linea seleccionada

            new ListSelectionListener(){ // Instanciamos

                public void valueChanged (ListSelectionEvent event){ // evento de la tabla
                    if(!event.getValueIsAdjusting() && (tablaProductos.getSelectedRow()>=0) ) {
                        int filaSeleccionada = tablaProductos.getSelectedRow(); // tomamos la fila seleccionda
                        /*creamos el obj y le pasamos la fila seleccionada y la columna 1 xq ayi 
                        esta alojado el obj marca en el campo nombre....
                        */     
                        Productos prod = (Productos) modeloTabla.getValueAt(filaSeleccionada,1); 

                        // LLenamos los textBoxs atraves del objeto ...
                        txtNombre.setText(prod.getNombreProduc());
                        txtMedida.setText(prod.getMedidaProduc());
                        txtPrecioCompra.setText(String.valueOf(prod.getPrecioCompra()));
                        txtPrecioSujerido.setText(String.valueOf(prod.getPrecioSujerido()));
                        txtAveriado.setText(String.valueOf(prod.getAveriado()));
                        txtStocks.setText(String.valueOf(prod.getStocksProduc()));
                        productoSeleccionado = prod;

                        cargarModeloProv(); 
                        cargarModeloCalidad();
                        cargarModeloMarca();
                        cargarModeloCat();
                        //abilitar boton para actualizar
                        btnGuardar.setEnabled(false);
                        btnActualizar.setEnabled(true);
                        btnEliminar.setEnabled(true);
                        // dejar los radios inavilitados
                        radioProducto.setEnabled(false);
                        radioServicio.setEnabled(false);

                        if(prod.getTipoRegistro().equalsIgnoreCase("producto")){
                            System.out.println("Es un producto");

                        }else{
                            System.out.println("Es un servicio");
                        }
                    }

                }
            }

        );
        jScrollPane1.setViewportView(tablaProductos);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/icons8_Search_32px.png"))); // NOI18N
        jLabel6.setText("Buscar producto:");

        txtCriterioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioProductoActionPerformed(evt);
            }
        });
        txtCriterioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioProductoKeyReleased(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizar.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/Files/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCriterioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCriterioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // guardar productos

        String nombre = this.txtNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre está vacio!!");
            return;
        }

        double precioSujerido=0.00;
        try {
            precioSujerido = Double.parseDouble(this.txtPrecioSujerido.getText());
            if (precioSujerido <= 0) {
                JOptionPane.showMessageDialog(null, "El precio sugerido no es Válido!!");
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El precio sugerido no es Válido o esta vacio!!");
            return;
        }

        // preguntar si esta guardando productos o servicios
        Productos product = new Productos();
        product.setNombreProduc(nombre);
        product.setPrecioSujerido(precioSujerido);
        String tipoRegis = "";

        if (radioProducto.isSelected()) {
            tipoRegis = "producto";

            String medida = this.txtMedida.getText();
            if (medida.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La medida está vacia!!");
                return;
            }

            double precioCompra = Double.parseDouble(this.txtPrecioCompra.getText());
            if (precioCompra <= 0) {
                JOptionPane.showMessageDialog(null, "El precio de compra no es Válido!!");
                return;
            }
            
            int stock = Integer.parseInt(this.txtStocks.getText());
            int averiado = Integer.parseInt(this.txtAveriado.getText());
            Categorias categoria = (Categorias) this.modeloCategoria.getSelectedItem();
            Proveedores proveedor = (Proveedores) this.modeloProveedor.getSelectedItem();
            Marcas marca = (Marcas) this.modeloMarca.getSelectedItem();
            Calidad calidad = (Calidad) this.modeloCalidad.getSelectedItem();

            //objeto producto lleno
            product.setMedidaProduc(medida);
            product.setPrecioCompra(precioCompra);
            product.setStocksProduc(stock);
            product.setAveriado(averiado);
            product.setIdCategoria(categoria.getIdCategoria());
            product.setIdCalidad(calidad.getIdCalidad());
            product.setIdMarca(marca.getIdMarca());
            product.setIdProveedor(proveedor.getIdProveedor());

        } else {
            tipoRegis = "servicio";
            product.setMedidaProduc("-");
            product.setPrecioCompra(0.00);
            product.setStocksProduc(0);
            product.setAveriado(0);
            product.setIdCalidad(1);
            product.setIdCategoria(1);
            product.setIdMarca(1);
            product.setIdProveedor(1);
        }

        product.setTipoRegistro(tipoRegis); // producto o servicio

        if (base.insertarProductos(product) == 1) {
            JOptionPane.showMessageDialog(null, "Producto Guardado");
            cargarModeloTablaProduc();
            limpiarTextboxs();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo Guardar");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public String tipoRegistro = "";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //int res=JOptionPane.showConfirmDialog(this, "Registrar un Producto");
        //0 es si, 1 es no, 2 es cancelar
        radioProducto.setEnabled(true);
        radioServicio.setEnabled(true);
        btnGuardar.setEnabled(true);
        this.btnActualizar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        limpiarTextboxs();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCriterioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioProductoActionPerformed

    // metodo para vaciar toda la tabla ...
    private void limpiarTablaLista() {
        int numFila = modeloTabla.getRowCount(); // cantidad de filas
        if (numFila > 0) {
            // debe de ser i mayor o igual a cero
            for (int i = numFila - 1; i >= 0; i--) { // recorre de mayor a menor
                modeloTabla.removeRow(i); // borra la fila
            }
        }
    }
    private void txtCriterioProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioProductoKeyReleased
        // TODO add your handling code here:
        limpiarTablaLista();

        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
        String nombreProducto = this.txtCriterioProducto.getText();
        listaProductos = base.obtenerProductosCriterio(nombreProducto);

        int numFila = listaProductos.size();

        modeloTabla.setNumRows(numFila);
        for (int i = 0; i < numFila; i++) {
            Productos producto = listaProductos.get(i);

            int codigo = producto.getIdProducto();
            Double precioCompra = producto.getPrecioCompra();
            //String medida = producto.getMedidaProduc();
            Double precioSuj = producto.getPrecioSujerido();

            modeloTabla.setValueAt(codigo, i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(precioCompra, i, 2);
            modeloTabla.setValueAt(precioSuj, i, 3);

        }

    }//GEN-LAST:event_txtCriterioProductoKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

         String nombre = this.txtNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre está vacio!!");
            return;
        }

        double precioSujerido=0.00;
        try {
            precioSujerido = Double.parseDouble(this.txtPrecioSujerido.getText());
            if (precioSujerido <= 0) {
                JOptionPane.showMessageDialog(null, "El precio sugerido no es Válido!!");
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El precio sugerido no es Válido o esta vacio!!");
            return;
        }

        // preguntar si esta actualizando productos o servicios
        productoSeleccionado.setNombreProduc(nombre);
        productoSeleccionado.setPrecioSujerido(precioSujerido);
       

        if (productoSeleccionado.getTipoRegistro().equalsIgnoreCase("producto")) {
            
            String medida = this.txtMedida.getText();
            if (medida.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La medida está vacia!!");
                return;
            }

            
            double precioCompra = 0.00;
            try {
                precioCompra = Double.parseDouble(this.txtPrecioCompra.getText());
                if (precioCompra <= 0) {
                    JOptionPane.showMessageDialog(null, "El precio de compra no es Válido!!");
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "El precio compra no es Válido o esta vacio!!");
                return;
            }

            int stock = Integer.parseInt(this.txtStocks.getText());
            int averiado = Integer.parseInt(this.txtAveriado.getText());
            Categorias categoria = (Categorias) this.modeloCategoria.getSelectedItem();
            Proveedores proveedor = (Proveedores) this.modeloProveedor.getSelectedItem();
            Marcas marca = (Marcas) this.modeloMarca.getSelectedItem();
            Calidad calidad = (Calidad) this.modeloCalidad.getSelectedItem();

            //objeto producto lleno
            productoSeleccionado.setMedidaProduc(medida);
            productoSeleccionado.setPrecioCompra(precioCompra);
            productoSeleccionado.setStocksProduc(stock);
            productoSeleccionado.setAveriado(averiado);
            productoSeleccionado.setIdCategoria(categoria.getIdCategoria());
            productoSeleccionado.setIdMarca(marca.getIdMarca());
            productoSeleccionado.setIdProveedor(proveedor.getIdProveedor());
            productoSeleccionado.setIdCalidad(calidad.getIdCalidad());

        } else {
            productoSeleccionado.setMedidaProduc("-");
            productoSeleccionado.setPrecioCompra(0.00);
            productoSeleccionado.setStocksProduc(0);
            productoSeleccionado.setAveriado(0);
            productoSeleccionado.setIdCalidad(1);
            productoSeleccionado.setIdCategoria(1);
            productoSeleccionado.setIdMarca(1);
            productoSeleccionado.setIdProveedor(1);
        }

        if (base.actualizarProductos(productoSeleccionado) == 1) {
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
            cargarModeloTablaProduc();
            limpiarTextboxs();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar");
        }

        this.btnActualizar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int r = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar este producto?");
        System.out.println("Hola_Cristhian" + r);
        if (r == 0) {

            if (base.eliminarProductos(productoSeleccionado) > 0) {
                JOptionPane.showMessageDialog(null, "Producto fué eliminado");
                cargarModeloTablaProduc();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
            this.btnActualizar.setEnabled(false);
            this.btnEliminar.setEnabled(false);
            limpiarTextboxs();
        } else {
            return;
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void radioServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioServicioMouseClicked
        // TODO add your handling code here:
        desactivarTexboxs();
    }//GEN-LAST:event_radioServicioMouseClicked

    private void radioProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioProductoMouseClicked
        // TODO add your handling code here:
        activarTexboxs();
    }//GEN-LAST:event_radioProductoMouseClicked

    private void limpiarTextboxs() {
        this.txtNombre.setText("");
        this.txtMedida.setText("");
        this.txtAveriado.setText("");
        this.txtPrecioCompra.setText("");
        this.txtPrecioSujerido.setText("");
        this.txtStocks.setText("");
    }

    private void desactivarTexboxs() {
        //this.txtNombre.setEnabled(false);
        this.txtMedida.setEnabled(false);
        this.txtAveriado.setEnabled(false);
        this.txtPrecioCompra.setEnabled(false);
        //this.txtPrecioSujerido.setEnabled(false);
        this.txtStocks.setEnabled(false);
        
    }

    private void activarTexboxs() {
        this.txtNombre.setEnabled(true);
        this.txtMedida.setEnabled(true);
        this.txtAveriado.setEnabled(true);
        this.txtPrecioCompra.setEnabled(true);
        this.txtPrecioSujerido.setEnabled(true);
        this.txtStocks.setEnabled(true);
    }

    private void activarTexboxServicios() {
        this.txtNombre.setEnabled(true);
        this.txtPrecioSujerido.setEnabled(true);

    }

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
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductosFrame dialog = new ProductosFrame(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup grupoRadios;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JRadioButton radioProducto;
    private javax.swing.JRadioButton radioServicio;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtAveriado;
    private javax.swing.JTextField txtCriterioProducto;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioSujerido;
    private javax.swing.JTextField txtStocks;
    // End of variables declaration//GEN-END:variables
}
