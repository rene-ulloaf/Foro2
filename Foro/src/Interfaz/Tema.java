package Interfaz;

import Clases.Temas;
import java.awt.Point;
import javax.swing.JOptionPane;

public class Tema extends javax.swing.JFrame {
    Temas t = new Temas();
    String vlNombreUsuario;
    int cantColumnas = 6;

    private Tema(){
        this.setLocationRelativeTo(null);
        initComponents();
        this.cargaDatos();
    }

    public Tema(String nombreUsuario){
        this.vlNombreUsuario = nombreUsuario;
        t.GetNombreUsuario(this.vlNombreUsuario);
        
        this.setLocationRelativeTo(null);
        initComponents();
        this.cargaDatos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTemas = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnCerrarSesion = new javax.swing.JButton();
        btnNuevoTema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Temas");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tblTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblTemasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTemas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrarSesion);

        btnNuevoTema.setText("Crear Nuevo Tema");
        btnNuevoTema.setFocusable(false);
        btnNuevoTema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTema.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoTemaMouseClicked(evt);
            }
        });
        jToolBar1.add(btnNuevoTema);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        Object[] botones = {"Si", "No"};

        if(JOptionPane.showOptionDialog(null, "¿Está seguro de Cerrar la Sesión?", "Escoja Opción", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]) == 0){
            Inicio ini = new Inicio();
            ini.show();
            this.hide();
        }
}//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnNuevoTemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoTemaMouseClicked
        this.NuevoTema();
    }//GEN-LAST:event_btnNuevoTemaMouseClicked

    private void tblTemasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTemasMouseReleased
        if(evt.getClickCount() == 2){
            Point p = evt.getPoint();
            
            if(this.isFilaSeleccionable(tblTemas.columnAtPoint(p))){
                Comentario com = null;
                String nombreTema="",usuarioCreador="",fechaCreacion="",ruta="";
                int cantComentarios=0;

                int fila = tblTemas.rowAtPoint(p);
                //int columna = tblTemas.columnAtPoint(p);

                nombreTema = tblTemas.getValueAt(fila,1).toString();
                usuarioCreador = tblTemas.getValueAt(fila,2).toString();
                fechaCreacion = tblTemas.getValueAt(fila,3).toString();
                ruta = tblTemas.getValueAt(fila,4).toString();
                cantComentarios = Integer.valueOf(tblTemas.getValueAt(fila,5).toString());

                com = new Comentario(nombreTema,vlNombreUsuario,usuarioCreador,fechaCreacion,ruta,cantComentarios);
                com.show();
                this.hide();
            }
        }
    }//GEN-LAST:event_tblTemasMouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnNuevoTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblTemas;
    // End of variables declaration//GEN-END:variables

    private void NuevoTema(){
        String tema = JOptionPane.showInputDialog("Ingrese el nombre del Tema");

        if(tema.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre del tema es obligatorio", "mensaje", JOptionPane.WARNING_MESSAGE);
            this.NuevoTema();
        }else{
            t.Crear(tema);
            this.cargaDatos();
        }
    }

    private void cargaDatos(){
        String columnas[] = {"Ver Comentarios","nombre Tema","Creador","Fecha Creación","ruta","cantidad Comentarios"};
        String datos[][] = new String[this.cantColumnas][t.ObtenerCantidad()];

        try{
            datos = t.Ver();
            tblTemas.setModel(new javax.swing.table.DefaultTableModel(datos,columnas));
            jScrollPane1.setViewportView(tblTemas);
        }catch (Exception e){
            //e.printStackTrace();
        }
    }

    private boolean isFilaSeleccionable(int fila){
        if(fila == 0){
            return true;
        }else{
            return false;
        }
    }
}