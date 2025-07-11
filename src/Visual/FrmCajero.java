/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visual;

import control.FacturaController;
import control.MedicoController;

import control.FacturaController;
import control.PacienteController;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Especialidad;
import model.Factura;
import model.Medico;
import model.PacienteLLBN;


public class FrmCajero extends javax.swing.JFrame {

       private MedicoController datosmedico;
       private FacturaController datosController;
       private PacienteController datospaciente;

       
    public FrmCajero() {
        initComponents();
         datosmedico = new MedicoController();
         datosController = new FacturaController();
          datospaciente = new PacienteController();
         cargarEspecialidades();
        establecerNumeroFactura();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCajero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        dtcFechaFactura = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbMedico = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripConsulta = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        btnGenerarFactura = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        btnIngresarPaciente = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(710, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(710, 520));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(710, 520));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(152, 168, 194));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setForeground(new java.awt.Color(255, 102, 102));
        jButton1.setText("Cerrar sesion");
        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("CAJERO");

        lblCajero.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(lblCajero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblCajero)))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 60));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("FACTURA Nª ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblNumero.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblNumero.setForeground(new java.awt.Color(0, 0, 0));
        lblNumero.setText("___");
        jPanel2.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 700, 10));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 0, 0));
        jLabel4.setText("Total a pagar      $");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));
        jPanel2.add(dtcFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 130, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Valor de la consulta ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nª identificacion:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel2.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 150, -1));
        jPanel2.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 222, 720, 10));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Datos del paciente");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nombre y apellidos;");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        cmbMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 210, -1));

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Edad");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecialidadActionPerformed(evt);
            }
        });
        jPanel2.add(cmbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 210, -1));

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Especialidad:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, 210));

        txtDescripConsulta.setColumns(20);
        txtDescripConsulta.setRows(5);
        jScrollPane1.setViewportView(txtDescripConsulta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 280, 60));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 700, 10));

        btnGenerarFactura.setBackground(new java.awt.Color(89, 124, 124));
        btnGenerarFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGenerarFactura.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarFactura.setText("Generar");
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 170, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("Consulta medica");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Subtotal:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        lblTotal.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setText("...");
        jPanel2.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Medico:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Descripcion:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        lblEdad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(0, 0, 0));
        lblEdad.setText("...");
        jPanel2.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        lblValor.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblValor.setForeground(new java.awt.Color(0, 0, 0));
        lblValor.setText("...");
        jPanel2.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Valor ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        lblDescuento.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(0, 0, 0));
        lblDescuento.setText("...");
        jPanel2.add(lblDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Descuento");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        lblSubtotal.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(0, 0, 0));
        lblSubtotal.setText("...");
        jPanel2.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 382, 260, 0));

        jSeparator6.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 280, 20));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 10, 210));

        btnIngresarPaciente.setBackground(new java.awt.Color(138, 184, 226));
        btnIngresarPaciente.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnIngresarPaciente.setForeground(new java.awt.Color(0, 102, 204));
        btnIngresarPaciente.setText("Nuevo Paciente");
        btnIngresarPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnIngresarPaciente.setBorderPainted(false);
        btnIngresarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPacienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 180, 40));

        btnbuscar.setBackground(java.awt.Color.lightGray);
        btnbuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnbuscar.setText("Buscar paciente");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jPanel3.setBackground(new java.awt.Color(224, 224, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 700, 70));

        jPanel4.setBackground(new java.awt.Color(224, 224, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 10, 220));

        jPanel5.setBackground(new java.awt.Color(224, 224, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 700, 50));

        jPanel6.setBackground(new java.awt.Color(224, 224, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 700, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
     private void establecerNumeroFactura() {
        int numeroFactura = datosController.obtenerUltimoNumeroFactura() + 1;
        lblNumero.setText(String.format("%02d", numeroFactura));
    }

     private void cargarEspecialidades() {
        datosmedico.llenarComboEspecialidades(cmbEspecialidad);
    }

   
    
    private void buscarPacientePorCedula() {
         String cedula = txtCedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            PacienteLLBN paciente = datospaciente.buscarPacientePorCedula(cedula);
            if (paciente != null) {
                txtNombres.setText(paciente.getNombre() + " " + paciente.getApellido());
                lblEdad.setText(String.valueOf(paciente.getEdad()));
                actualizarCalculoDescuento();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un paciente con esa cédula");
                limpiarCampos();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar paciente: " + 
                    ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private void calcularDescuento(int edad) {
        String especialidadNombre = (String) cmbEspecialidad.getSelectedItem();
        if (especialidadNombre != null) {
            Especialidad especialidad = datosmedico.getEspecialidadSeleccionada(especialidadNombre);
            if (especialidad != null) {
                double valorEspecialidad = especialidad.getValor_especialidad();
                double descuento = 0.0;
                if (edad < 13) {
                    descuento = valorEspecialidad * 0.05;
                } else if (edad > 80) {
                    descuento = valorEspecialidad * 0.10;
                }
                lblValor.setText(String.format("%.2f", valorEspecialidad));
                lblDescuento.setText(String.format("%.2f", descuento));
                lblSubtotal.setText(String.format("%.2f", valorEspecialidad - descuento));
                lblTotal.setText(String.format("%.2f", valorEspecialidad - descuento));
            }
        }
    }
     private void actualizarCalculoDescuento() {
        String edadText = lblEdad.getText().trim();
         if (!lblEdad.getText().isEmpty()) {
            try {
                int edad = Integer.parseInt(lblEdad.getText());
                calcularDescuento(edad);
            } catch (NumberFormatException e) {
                  System.out.println("Edad no válida aún: " + edadText);
            }
        }
    }
     
       private void limpiarCampos() {
        txtNombres.setText("");
        lblEdad.setText("");
        lblValor.setText("");
        lblDescuento.setText("");
        lblTotal.setText("");
        txtCedula.setText("");
        txtDescripConsulta.setText("");
        cmbEspecialidad.setSelectedIndex(-1);  
        cmbMedico.removeAllItems();  
        lblTotal.setText("");
    }
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose(); // Cierra la ventana actual
        FrmLogin login = new FrmLogin();
        login.setVisible(true); // Abre la ventana de login
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIngresarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPacienteActionPerformed
       FrmRegistrarPaciente registrarPaciente = new FrmRegistrarPaciente(this, true);
        registrarPaciente.setVisible(true);
    }//GEN-LAST:event_btnIngresarPacienteActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        String cedula = txtCedula.getText();
        String descripcionConsulta = txtDescripConsulta.getText();
        String especialidadNombre = (String) cmbEspecialidad.getSelectedItem();
        String medicoNombre = (String) cmbMedico.getSelectedItem();
        double total = 0.0;
            String pacienteNombre = txtNombres.getText();


        try {
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            Number number = format.parse(lblTotal.getText());
            total = number.doubleValue();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error al parsear el total: " + 
                    lblTotal.getText(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Especialidad especialidad = datosmedico.getEspecialidadSeleccionada(especialidadNombre);
        Medico medico = datosmedico.getMedicoSeleccionado(medicoNombre);
        if (especialidad == null || medico == null) {
            JOptionPane.showMessageDialog(this, "Error: Especialidad o Médico "
                    + "no seleccionados correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int numeroFactura = datosController.obtenerUltimoNumeroFactura() + 1;

        Factura factura = new Factura(
                numeroFactura,
                cedula,
                LocalDate.now(),
                descripcionConsulta,
                especialidad.getId_especialidad(),
                medico.getId_medico(),
                total
        );

        if (datosController.guardarFactura(factura)) {
            
            JOptionPane.showMessageDialog(this, "Factura generada exitosamente");
            FrmFacturaDoc facturaDoc = new FrmFacturaDoc(factura, pacienteNombre, especialidadNombre);
            facturaDoc.setVisible(true);
            limpiarCampos();
            establecerNumeroFactura(); 
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar la factura", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
     
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
         buscarPacientePorCedula();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cmbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecialidadActionPerformed
         String especialidadSeleccionada = (String) cmbEspecialidad.getSelectedItem();
     if (especialidadSeleccionada != null) {
            datosmedico.llenarComboMedicosPorEspecialidad(cmbMedico, especialidadSeleccionada);
            actualizarCalculoDescuento();

        }
    }//GEN-LAST:event_cmbEspecialidadActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnIngresarPaciente;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> cmbEspecialidad;
    private javax.swing.JComboBox<String> cmbMedico;
    private com.toedter.calendar.JDateChooser dtcFechaFactura;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtDescripConsulta;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
