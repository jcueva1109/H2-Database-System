/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Jesus Cueva
 */
public class VerTablas extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form VerTablas
     */
    public VerTablas() {
        
        initComponents();
        modelo.addColumn("TABLE_CATALOG");
        modelo.addColumn("TABLE_SCHEMA");
        modelo.addColumn("TABLE_NAME");
        modelo.addColumn("TABLE_TYPE");
        modelo.addColumn("STORAGE_TYPE");
        modelo.addColumn("SQL");
        modelo.addColumn("REMARKS");
        modelo.addColumn("LAST_MODIFICATION");
        modelo.addColumn("ID");
        modelo.addColumn("TYPE_NAME");
        modelo.addColumn("TABLE_CLASS");
        modelo.addColumn("ROW_COUNT_ESTIMATE");
        tabla.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Cerrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1209, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      
        try{
        
        String myDriver = "org.h2.Driver";
        String myUrl = "jdbc:h2:~/test";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "sa", "");

        String query = "select * from information_schema.tables";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            
            String table_catalog = rs.getString("Table_Catalog");
            String table_schema = rs.getString("Table_Schema");
            String table_name = rs.getString("Table_Name");
            String table_type = rs.getString("Table_Type");
            String storage_type = rs.getString("Storage_Type");
            String sql = rs.getString("SQL");
            String remarks = rs.getString("Remarks");
            String last_modification = rs.getString("last_modification");
            int id = rs.getInt("id");   String idString = Integer.toString(id);
            String type_name = rs.getString("type_name");
            String table_class = rs.getString("table_class");
            int row_count = rs.getInt("row_count_estimate");    String rowString = Integer.toString(row_count);
            
            String Dato[] = new String[12];
            Dato[0] = table_catalog;
            Dato[1] = table_schema;
            Dato[2] = table_name;
            Dato[3] = table_type;
            Dato[4] = storage_type;
            Dato[5] = sql;
            Dato[6] = remarks;
            Dato[7] = last_modification;
            Dato[8] = idString;
            Dato[9] = type_name;
            Dato[10] = table_class;
            Dato[11] = rowString;
            
            modelo.addRow(Dato);
            
        }
            st.close();
        }catch (Exception e){

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            
        }       
        
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(VerTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerTablas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}