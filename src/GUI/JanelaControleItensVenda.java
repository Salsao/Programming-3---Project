package GUI;

import Dominio.ItemVenda;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaControleItensVenda extends javax.swing.JFrame {
    
    private static JanelaControleVendas jcv;
    private JanelaIncluirItemVenda jiiv;
    
    public JanelaControleVendas getjAnt() {
        return jcv;
    }
    public void setjAnt(JanelaControleVendas jAnt) {
        jcv = jAnt;
    }
    public JanelaIncluirItemVenda getJiiv() {
        return this.jiiv;
    }
    public void setJiiv(JanelaIncluirItemVenda jiiv) {
        this.jiiv = jiiv;
    }
    
    public int getIDDoItemVendaDaLinhaSelecionada(){
       int v;
       v = (Integer)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
       
       return v;
    } 

    private JanelaControleItensVenda() {
        initComponents();
    }
    public JanelaControleItensVenda(JanelaControleVendas jAnt){
        initComponents();
        jcv = jAnt;
    }
    
    public void inicializaComponentes(){
        jiiv = new JanelaIncluirItemVenda(this);
        jiiv.comboBox();
    }
    
    public void Tabela(){
        int j = jcv.getIDDaVendaDaLinhaSelecionada();      
        for (int e = 0; e < JanelaControleVendas.getjAnt().getLoja().getVendas().size(); e++)
            if (j == JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getId())
       
                for ( int a = 0; a < JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().size(); a++ ){
                    Object[] ob = new Object []{"", "", ""};
                    
                    ((DefaultTableModel)jTable1.getModel()).addRow(ob);
                    jTable1.getModel().setValueAt(JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().get(a).getId(), a, 0);//id
                    jTable1.getModel().setValueAt(JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().get(a).getValorVenda(), a, 1);//valor venda
                    jTable1.getModel().setValueAt(JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().get(a).getQuant(), a, 2);//quantidade
        }
    }
    
    public void insereItensVendaTabela(){
        int j = jcv.getIDDaVendaDaLinhaSelecionada();
        int i;
        for (int e = 0; e < JanelaControleVendas.getjAnt().getLoja().getVendas().size(); e++){
            if (j == JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getId()){
                i = JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().size() - 1;
                    Object[] ob = new Object []{"", "", ""};
                    ((DefaultTableModel)jTable1.getModel()).addRow(ob);
                    
                    jTable1.getModel().setValueAt(JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().get(i).getId(), i, 0);//id
                    jTable1.getModel().setValueAt(JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().get(i).getValorVenda(), i, 1);//valor venda
                    jTable1.getModel().setValueAt(JanelaControleVendas.getjAnt().getLoja().getVendas().get(e).getItensVenda().get(i).getQuant(), i, 2);//quantidade
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Incluir Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Itens de Venda:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Valor de Venda", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(68, 68, 68)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Botao incluir item apertado
            this.setVisible(false);
            this.setEnabled(false);
            jiiv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botao remover item apertado
        if(jTable1.getSelectedRowCount() == 1){
            int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja realmente remover o item?", "Confirmação", JOptionPane.YES_NO_OPTION);  
            if(selectedOption == JOptionPane.YES_OPTION){  

                ItemVenda iv;
                int idv = jcv.getIDDaVendaDaLinhaSelecionada();
                int idiv = this.getIDDoItemVendaDaLinhaSelecionada();
                for (int i = 0; i < JanelaControleVendas.getjAnt().getLoja().getVendas().size(); i++){
                    if (idv == JanelaControleVendas.getjAnt().getLoja().getVendas().get(i).getId()){
                        for (int j = 0; j < JanelaControleVendas.getjAnt().getLoja().getVendas().get(i).getItensVenda().size(); j++){
                            if (idiv == JanelaControleVendas.getjAnt().getLoja().getVendas().get(i).getItensVenda().get(j).getId()){
                                iv = JanelaControleVendas.getjAnt().getLoja().getVendas().get(i).getItensVenda().get(j);
                                JanelaControleVendas.getjAnt().getLoja().getVendas().get(i).removerItemVenda(iv);
                                }
                            }
                        }
                    }
                ((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow());
                jcv.atualizarValorTotal();
             }                          
        }     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Botao Fechar clicado
        jcv.setVisible(true);
        jcv.setEnabled(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(JanelaControleItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaControleItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaControleItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaControleItensVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaControleItensVenda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
