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
public class VerIndices extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form VerIndices
     */
    public VerIndices() {
        initComponents();
        modelo.addColumn("TABLE_CATALOG");
        modelo.addColumn("TABLE_SCHEMA");
        modelo.addColumn("TABLE_NAME");
        modelo.addColumn("NON_UNIQUE");
        modelo.addColumn("INDEX_NAME");
        modelo.addColumn("ORDINAL_POSITION");
        modelo.addColumn("COLUMN_NAME");
        modelo.addColumn("CARDINALITY");
        modelo.addColumn("PRIMARY_KEY");
        modelo.addColumn("INDEX_TYPE_NAME");
        modelo.addColumn("IS_GENERATED");
        modelo.addColumn("INDEX_TYPE");
        modelo.addColumn("ASC_OR_DESC");
        modelo.addColumn("PAGES");
        modelo.addColumn("FILTER_CONDITION");
        modelo.addColumn("REMAKRS");
        modelo.addColumn("SQL");
        modelo.addColumn("ID");
        modelo.addColumn("SORT_TYPE");
        modelo.addColumn("CONSTRAINT_NAME");
        modelo.addColumn("INDEX_CLASS");
        modelo.addColumn("AFFINITY");
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

        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton2.setText("Cerrar");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     
        try{
        
        String myDriver = "org.h2.Driver";
        String myUrl = "jdbc:h2:~/test";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "sa", "");

        String query = "select * from information_schema.indexes";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            
            String table_catalog = rs.getString("Table_Catalog");
            String table_schema = rs.getString("Table_Schema");
            String table_name = rs.getString("Table_Name");
            boolean non_unique = rs.getBoolean("Non_Unique");       String nonString = String.valueOf(non_unique);
            String index_name = rs.getString("Index_Name");
            int ordinal_position = rs.getInt("Ordinal_Position");   String ordinalString = Integer.toString(ordinal_position);
            String column_name = rs.getString("Column_Name");
            int cardinality = rs.getInt("Cardinality");             String cardinalityString = Integer.toString(cardinality);
            boolean primary_key = rs.getBoolean("Primary_Key");     String pk = String.valueOf(primary_key);
            String index_type_name = rs.getString("Index_Type_Name");
            boolean is_generated = rs.getBoolean("Is_Generated");   String isString = String.valueOf(is_generated);
            int index_type = rs.getInt("Index_Type");                String indexString = Integer.toString(index_type);
            String asc_desc = rs.getString("ASC_or_DESC");
            int pages = rs.getInt("Pages");                         String pagesString = Integer.toString(pages);
            String sql = rs.getString("SQL");
            int id = rs.getInt("ID");                               String idString = Integer.toString(id);
            String sort_type = rs.getString("Sort_Type");
            String constraint_name = rs.getString("Constraint_Name");
            String index_class = rs.getString("Index_Class");
            boolean affinity = rs.getBoolean("Affinity");           String affinityBoolean = String.valueOf(affinity);
            
            
            String Dato[] = new String[20];
            Dato[0] = table_catalog;
            Dato[1] = table_schema;
            Dato[2] = table_name;
            Dato[3] = nonString;
            Dato[4] = index_name;
            Dato[5] = ordinalString;
            Dato[6] = column_name;
            Dato[7] = cardinalityString;
            Dato[8] = pk;
            Dato[9] = index_type_name;
            Dato[10] = isString;
            Dato[11] = indexString;
            Dato[12] = asc_desc;
            Dato[13] = pagesString;
            Dato[14] = sql;
            Dato[15] = idString;
            Dato[16] = sort_type;
            Dato[17] = constraint_name;
            Dato[18] = index_class;
            Dato[19] = affinityBoolean;
            
            modelo.addRow(Dato);
            
        }
            st.close();
        }catch (Exception e){

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            
        }       
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      
        this.dispose();
        
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
            java.util.logging.Logger.getLogger(VerIndices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerIndices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerIndices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerIndices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerIndices().setVisible(true);
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