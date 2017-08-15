package csvtojson;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Sujoy
 */
public class ViewPage extends javax.swing.JFrame {

    String[] result1 = null;
    String[] result2 = null;
    int ignore = 0;
    String filepath;
    File f;

    public ViewPage() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_path = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_csv_display = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_json_display = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CSV To JSON Converter");
        setPreferredSize(new java.awt.Dimension(1030, 684));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("File Path");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 23, 110, -1));
        getContentPane().add(txt_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 43, 478, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 43, 167, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("C S V");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("J S O N");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Convert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        txt_csv_display.setColumns(20);
        txt_csv_display.setRows(5);
        jScrollPane3.setViewportView(txt_csv_display);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 470, 419));

        txt_json_display.setColumns(20);
        txt_json_display.setRows(5);
        jScrollPane1.setViewportView(txt_json_display);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 450, 420));

        jButton2.setText("Save");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chosser = new JFileChooser();
        chosser.showOpenDialog(null);
        File f = chosser.getSelectedFile();
        filepath = f.getAbsolutePath();

        txt_path.setText(filepath);
        String[] result11 = null;
        String outputcsv = "";
        try {
            String[] result1;

            List<String> line = Files.readAllLines(Paths.get(filepath));
            String aaa = line.toString();

            for (String lin : line) {

                //lin = lin.replace(",", " ");
                result11 = lin.split("\n");
                outputcsv = outputcsv + result11[0]+"\n";

            }
            //result1 = line.split("\n");
            txt_csv_display.setText(outputcsv);

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String output = "";
        
        int i = 0;

        //take 1st row
        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath));

            for (String line : lines) {

                line = line.replace(",", " ");
                result1 = line.split("\n");

                break;

            }

            // for all row taking
            //System.out.println("[");

            output = output + "[\n";
            for (String line : lines) {

                line = line.replace(",", " ");
                result2 = line.split("\n");

                if (ignore > 0) {//ignore 1st row
                    Scanner fromstr1 = new Scanner(result1[0]);
                    Scanner fromstr2 = new Scanner(result2[0]);

                    //System.out.println("{");

                    output = output + "{\n";
                    while (fromstr1.hasNext()) {//devide row based on space and print Json formate

                        //System.out.print('"' + fromstr1.next());
                        String a = fromstr1.next();
                        //System.out.print('"' + a);

                        output = output + '"' + a;

                        //System.out.print('"');

                        output = output + '"';
                        //System.out.print(':');

                        output = output + ':';
                        //System.out.print('"' + fromstr2.next());
                        String b = fromstr2.next();
                        //System.out.print('"' + b);
                        output = output + '"' + b;

                        //System.out.println('"');

                        output = output + '"' + "\n";

                        //output=output+'"'+fromstr1.next()+'"'+':'+'"' + fromstr2.next()+'"'+"\n";
                    }

                    //System.out.println("}");

                    output = output + "}\n";

                    //output=output+"}\n";
                }
                ignore++;

            }
            //System.out.println("]");

            output = output + "]" + "\n";

            //output=output+"]\n";
            txt_json_display.setText(output);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txt_csv_display;
    private javax.swing.JTextArea txt_json_display;
    private javax.swing.JTextField txt_path;
    // End of variables declaration//GEN-END:variables
}
