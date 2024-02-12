
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Profit_BillAdmin extends javax.swing.JFrame {

    /**
     * Creates new form BillAdmin
     */
    public void Profit() {
        try {
            String conn = "com.mysql.cj.jdbc.Driver";
            Class.forName(conn);
            String s = "jdbc:mysql://localhost:3306/AgriFarm";
            String rt = "root";
            Connection con = DriverManager.getConnection(s, rt, "");
            String sql = "select * from product";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet r, rs = ps.executeQuery();

            String pn, sq, x;
            int pq, ts, tl, pr, ep, cp;

            String a, b, c, d, e;
            //int pr,ep,cp;
            DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();

            while (rs.next()) {
                pn = rs.getString("PName");
                pq = rs.getInt("Quantity");
                pr = rs.getInt("Price");
                ts = 0;
                tl = pq;

                ProductBill.addItem(pn);
                sq = "select sum(Quan) from billhistory where PName=?";

                ps = con.prepareStatement(sq);
                ps.setString(1, pn);

                r = ps.executeQuery();
                if (r.next()) {
                    x = r.getString("sum(Quan)");
                    ts = Integer.parseInt(x);
                }

                pq += ts;

                ep = pr * pq;
                cp = pr * ts;

                a = String.valueOf(pq);
                b = String.valueOf(ts);
                c = String.valueOf(tl);
                d = String.valueOf(ep);
                e = String.valueOf(cp);

                String dt[] = {pn, a, b, c, d, e};

                tb.addRow(dt);
            }
        } catch (Exception ex) {
            Logger.getLogger(ui_4_managerlist.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Bill() {
        try {
            String conn = "com.mysql.cj.jdbc.Driver";
            Class.forName(conn);
            String s = "jdbc:mysql://localhost:3306/AgriFarm";
            String rt = "root";
            Connection con = DriverManager.getConnection(s, rt, "");
            String sql = "select * from billhistory";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();

            String pn, pq, tp, cn, dt;
            while (rs.next()) {
                pn = rs.getString("PName");
                //pcat = rs.getString("PCat");
                pq = rs.getString("Quan");
                tp = rs.getString("TotalPrice");
                dt = rs.getString("Date");
                cn = rs.getString("CustomerName");

                String td[] = {pn, pq, tp, cn, dt};
                tb.addRow(td);
            }

        } catch (Exception ex) {
            Logger.getLogger(ui_4_managerlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Profit_BillAdmin() {
        initComponents();
        Bill();
        Profit();
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ProductBill = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 153, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Qunatity(kg)", "Total Price", "CName", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Bill History");

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 153, 102));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PName", "Total Quan(kg)", "Total Sold(kg)", "Total Left(kg)", "Expected Profit(TK)", "Profit Till now(TK)"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        Back.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Profit");

        ProductBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductBillActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 204, 204));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Quantity(kg)", "Toatal Price(tk)"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Select Item ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Product Bill history");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 891, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(440, 440, 440))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(478, 478, 478))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                                .addComponent(jScrollPane1))
                            .addGap(119, 119, 119)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ProductBill, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProductBill, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        new ui_2_admin().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void ProductBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductBillActionPerformed
        // TODO add your handling code here:

        try {
            String conn = "com.mysql.cj.jdbc.Driver";
            Class.forName(conn);
            String s = "jdbc:mysql://localhost:3306/AgriFarm";
            String rt = "root";
            Connection con = DriverManager.getConnection(s, rt, "");
            
            String name=ProductBill.getSelectedItem().toString();
            String sql = "select Quan,TotalPrice,Date from billhistory where PName=?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setString(1, name);
            
            ResultSet rs=ps.executeQuery();
            
            String date,q,tp;            
            //int price,quan;
            DefaultTableModel tb=(DefaultTableModel)jTable3.getModel();
            tb.getDataVector().removeAllElements();
            
            while(rs.next())
            {
                q=String.valueOf(rs.getInt("Quan"));
                tp=String.valueOf(rs.getInt("TotalPrice"));
                date=rs.getString("Date");
                
                String dt[]={date,q,tp};
                tb.addRow(dt);
            }
        }
        
        catch (Exception ex) {
            Logger.getLogger(ui_4_managerlist.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ProductBillActionPerformed

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
            java.util.logging.Logger.getLogger(Profit_BillAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profit_BillAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profit_BillAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profit_BillAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profit_BillAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> ProductBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
