/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorjava;

import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author mextest
 */
public class View extends javax.swing.JFrame {

    File archivo;
    JFileChooser seleccionado;
    ArrayList<String> contentFile;
    ImageIcon img;
    Scanner reader;
    private LineNumberModelImpl lineNumberModel;
    private LineNumberComponent lineNumberComponent;
    private ArrayList<Symbol> listSymbol = new ArrayList();
    private int tokenId = 0;

    public class LineNumberModelImpl implements LineNumberModel {

        @Override
        public int getNumberLines() {
            int a = output.getLineCount();
            return a;
        }

        @Override
        public Rectangle getLineRect(int line) {
            try {
                return output.modelToView(output.getLineStartOffset(line));
            } catch (BadLocationException e) {
                return new Rectangle();
            }
        }
    }

    public View() {
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Sounds.class);
            }
        }.start();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        lineNumberModel = new LineNumberModelImpl();
        lineNumberComponent = new LineNumberComponent(lineNumberModel);
        jScrollPane2.setRowHeaderView(lineNumberComponent);
        lineNumberComponent.setAlignment(LineNumberComponent.CENTER_ALIGNMENT);
        output.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent arg0) {
                lineNumberComponent.adjustWidth();
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                lineNumberComponent.adjustWidth();
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                lineNumberComponent.adjustWidth();
            }
        });
        img = new ImageIcon("src/resources/atom-icon.png");
        setIconImage(img.getImage());
        path.getDocument().addDocumentListener(new View.pathListener());
        path.getDocument().putProperty("name", "path");
        PromptSupport.setPrompt("Please write a correct path", path);
        PromptSupport.setPrompt("HERE YOU CAN SEE THE OUTPUT", output);
        seleccionado = new JFileChooser();
        seleccionado.setFileFilter(new View.TypeOfFile());
        seleccionado.setDialogTitle("Browse java file");
        output.setText(" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clear = new javax.swing.JButton();
        path = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        clear1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        clear1.setText("Clear");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        jButton1.setText("Previous");

        jButton2.setText("Next");

        jLabel1.setText("Token ID:");

        jLabel2.setText("Token Name:");

        jLabel3.setText("Token Value:");

        jLabel4.setText("Line:");

        jLabel5.setText("Column:");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jButton3.setText("First");

        jButton4.setText("Last");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clear1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(39, 39, 39)
                                    .addComponent(jButton2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        archivo = null;
        Sounds s = new Sounds();
        if (seleccionado.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                archivo = seleccionado.getSelectedFile();
                if (archivo.canRead() && archivo.getName().endsWith("java")) {
                    archivo = seleccionado.getSelectedFile();
                    path.setText(seleccionado.getSelectedFile().getAbsolutePath());
                } else {
                    path.setText("");
                    s.worng();
                    JOptionPane.showMessageDialog(null, "Please select a java file");
                }
            } catch (HeadlessException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            path.setText("");
            s.worng();
            JOptionPane.showMessageDialog(null, "Please select a java file");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        output.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        output.setText("");
    }//GEN-LAST:event_clear1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    class TypeOfFile extends FileFilter {

        @Override
        public boolean accept(File f) {
            return f.isDirectory() || f.getName().toLowerCase().endsWith(".java");
        }

        //Set description for the type of file that should be display  
        @Override
        public String getDescription() {
            return ".java files";
        }
    }
    // Clase pathListener es una clase que se encarga de escuchar cada caracter que se inserte en el field de PATH

    class pathListener implements DocumentListener {

        final String newline = "\n";

        //metodo para escuchar cuando inserte un nuevo caracter
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "insertado en");
        }

        //Metodo para escuchar cuando elimine un caracter
        @Override
        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removido en");
        }

        //metodo para escuchar cuando cambie un caracter
        @Override
        public void changedUpdate(DocumentEvent e) {
            updateLog(e, "cambio en");
        }

        //metodo de actualizacion por cada uno de los metodos anteriores
        public void updateLog(DocumentEvent e, String action) {
            Document doc = (Document) e.getDocument();
            //recibe el archivo del directorio de PATH
            archivo = new File(path.getText());
            //Si el archivo se puede leer y tiene terminacion java
            if (archivo.canRead() && archivo.getName().endsWith("java")) {

                try {
                    output.setText("");
                    //lee el archivo y lo gusarda en listSymbol
                    listSymbol = LexerExecute.execute(archivo);  
                    reader = new Scanner(archivo);
                    while (reader.hasNextLine()) {
                        String i = reader.nextLine();
                        output.append(i + "\n");
                    }
                    reader.close();
                    
                    
                    
                } catch (IOException ex) {
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea output;
    private javax.swing.JTextField path;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables

}
