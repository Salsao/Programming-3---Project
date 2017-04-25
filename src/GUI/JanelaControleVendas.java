package GUI;

import Dominio.VendaPrazo;
import Dominio.VendaVista;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class JanelaControleVendas extends javax.swing.JFrame {

    private static JanelaPrincipal jPrincipal;
    private static JanelaRegistrarVenda jrv;
    private static JanelaControleItensVenda jciv;
    
    public static JanelaRegistrarVenda getJrv() {
        return jrv;
    }
    public static void setJrv(JanelaRegistrarVenda jrv) {
        JanelaControleVendas.jrv = jrv;
    }
    public static JanelaControleItensVenda getJciv() {
        return jciv;
    }
    public static void setJciv(JanelaControleItensVenda jciv) {
        JanelaControleVendas.jciv = jciv;
    }
    public static JanelaPrincipal getjAnt() {
        return jPrincipal;
    }
    
    public int getIDDaVendaDaLinhaSelecionada(){
       int v = (Integer)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
       return v;
    }
    
    private JanelaControleVendas(){
        initComponents();
    }
    public JanelaControleVendas(JanelaPrincipal jAnt){
        initComponents();
        jPrincipal = jAnt;
    }
    
    public void inicializaComponentes(){
        jrv = new JanelaRegistrarVenda(this);
        jciv = new JanelaControleItensVenda(this);
        jrv.comboBox();
    }
    
    public void insereVendasTabela(){
        float aux;
        
        int i = jPrincipal.getLoja().getVendas().size() - 1;
        Object[] ob = new Object []{"", "", "", ""};
        ((DefaultTableModel)jTable1.getModel()).addRow(ob);

        jTable1.getModel().setValueAt(jPrincipal.getLoja().getVendas().get(i).getId(), i, 0);
        jTable1.getModel().setValueAt( dateToString(jPrincipal.getLoja().getVendas().get(i).getData()), i, 1);
        if ( jPrincipal.getLoja().getVendas().get(i) instanceof VendaPrazo ){
            VendaPrazo vp = (VendaPrazo)jPrincipal.getLoja().getVendas().get(i);
            jTable1.getModel().setValueAt( vp.getCli(), i, 2);
        }
        if ( jPrincipal.getLoja().getVendas().get(i) instanceof VendaVista){
            jTable1.getModel().setValueAt("venda a vista", i, 2);
        }

        if (jPrincipal.getLoja().getVendas().get(i).getItensVenda() == null)
            aux = jPrincipal.getLoja().getVendas().get(i).calcularValorTotal();
        else aux = 0;

        jTable1.getModel().setValueAt(aux, i, 3);
    }
    
    public void atualizarValorTotal(){
        float aux;
        int i = jPrincipal.getLoja().getVendas().size() - 1;
        if (jPrincipal.getLoja().getVendas().get(i).getItensVenda() != null)
                    aux = jPrincipal.getLoja().getVendas().get(i).calcularValorTotal();
        else aux = 0;
        jTable1.getModel().setValueAt(aux, i, 3);
}
    
    public String dateToString (Date d){
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(d);
        return result;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Data", "Cliente", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Vendas:");

        jButton1.setText("Registrar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Controlar Itens de Venda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Botao 'FECHAR' <Clicado>
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botao 'REGISTRAR VENDA' <Clicado>
        this.setVisible(false);
        this.setEnabled(false);
        
        jrv.setVisible(true);
        jrv.setEnabled(true);
        System.out.println("[JanelaControleVendas]Abrindo jrv OK");
    }//GEN-LAST:event_jButton1ActionPerformed
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botao 'CONTROLAR ITENS DE VENDA' <Clicado>
        if(jTable1.getSelectedRowCount() == 1){
            this.setVisible(false);
            this.setEnabled(false);
            jciv.inicializaComponentes();
            jciv.setVisible(true);
            jciv.setEnabled(true);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Fechando a janela de Controle de Vendas e reativando a janela principal
        jPrincipal.setVisible(true);
        jPrincipal.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(JanelaControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaControleVendas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
