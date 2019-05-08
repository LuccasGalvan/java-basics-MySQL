/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.JOptionPane;
import modelo.JogoVO;
import servicos.JogoServicos;
import servicos.ServicosFactory;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class GuiCadJogo extends javax.swing.JInternalFrame {

    /**
     * Creates new form GuiCadSeriado
     */
    public GuiCadJogo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jlNome = new javax.swing.JLabel();
        jlTemporada = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jtEmpresa = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jbCadastrar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("cadastro de jogo");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlNome.setText("nome");
        jLayeredPane1.add(jlNome);
        jlNome.setBounds(20, 20, 60, 16);

        jlTemporada.setText("empresa");
        jLayeredPane1.add(jlTemporada);
        jlTemporada.setBounds(20, 70, 100, 16);
        jLayeredPane1.add(jtNome);
        jtNome.setBounds(70, 20, 240, 30);
        jLayeredPane1.add(jtEmpresa);
        jtEmpresa.setBounds(110, 70, 200, 30);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbCadastrar.setText("cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jbCadastrar);
        jbCadastrar.setBounds(20, 20, 130, 32);

        jbLimpar.setText("limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jbLimpar);
        jbLimpar.setBounds(160, 20, 130, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(jLayeredPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrar(){
        try {
            JogoVO jVO = new JogoVO();
            
            jVO.setNome(jtNome.getText());
            jVO.setEmpresa(jtEmpresa.getText());
            
            JogoServicos js = ServicosFactory.getJogoServicos();
            js.cadastrarJogo(jVO);
            
            JOptionPane.showMessageDialog(this,
                 "Jogo cadastrado com sucesso!");
                        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "ERRO! "+e.getMessage());
        }//fecha catch
    }//fecha método cadastrar
    
    private void limpar(){
        jtNome.setText(null);
        jtEmpresa.setText(null);
    }//fecha método limpar
    
    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        cadastrar();
        limpar();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limpar();
    }//GEN-LAST:event_jbLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlTemporada;
    private javax.swing.JTextField jtEmpresa;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables
}
