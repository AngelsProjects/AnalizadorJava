/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorjava;

import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import org.jdesktop.swingx.prompt.PromptSupport;
import java_cup.runtime.Symbol;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;

public class View extends javax.swing.JFrame {

    File archivo;
    JFileChooser seleccionado;
    ArrayList<String> contentFile;
    ImageIcon img;
    Scanner reader;
    private final LineNumberModelImpl lineNumberModel;
    private LineNumberComponent lineNumberComponent;

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
        path.getDocument().addDocumentListener(new pathListener());
        path.getDocument().putProperty("name", "path");
        PromptSupport.setPrompt("Please write a correct path", path);
        PromptSupport.setPrompt("HERE YOU CAN SEE THE OUTPUT", output);
        seleccionado = new JFileChooser();
        seleccionado.setFileFilter(new TypeOfFile());
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

        path = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Java");
        setResizable(false);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(path, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear)
                .addGap(142, 142, 142))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addComponent(clear)
                .addGap(28, 28, 28))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(147, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        archivo = null;
        if (seleccionado.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            try {
                if (archivo.canRead() && archivo.getName().endsWith("java")) {
                    archivo = seleccionado.getSelectedFile();
                    path.setText(seleccionado.getSelectedFile().getAbsolutePath());
                } else {
                    path.setText("");
                    JOptionPane.showMessageDialog(null, "Please select a java file");
                }
            } catch (HeadlessException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            path.setText("");
            JOptionPane.showMessageDialog(null, "Please select a java file");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        output.setText("");
    }//GEN-LAST:event_clearActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea output;
    private javax.swing.JTextField path;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
