/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import java.text.DateFormat;
import java.util.Date;
import java.sql.*;
import javax.swing.JOptionPane;
import DataAccessLayer.DBconexao;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;


/**
 *
 * @author mabiala
 */
public class FramFuncionario extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    /**
     * Creates new form FramAluno
     */
    public FramFuncionario() {
        initComponents();
        conexao = DBconexao.conector();
        
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        txtDataCadastroF.setText(formatador.format(data));
        txtDataCadastroF.setEnabled(false);
    }
    private void fuconsultar(){
        String sql = "select* from tbfuncionario where id=?";
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdfu.getText());
           
           rs = pst.executeQuery();
            
            if(rs.next()){
                txtIdfu.setText(rs.getString(1));
                txtNomefu.setText(rs.getString(2));            
                txtBIfu.setText(rs.getString(3));                        
                DtNascimentofu.setText(rs.getString(4));            
                txtIdadefu.setText(rs.getString(5));            
                cboSexofu.setSelectedItem(rs.getString(6));                        
                txtMoradafu.setText(rs.getString(7));            
                txtFonefu.setText(rs.getString(8));            
                txtEmailfu.setText(rs.getString(9));
                
                btnAdd.setEnabled(false);                
                
            }else{
                JOptionPane.showMessageDialog(null, "Funcionário não Existe");
                
                txtIdfu.setText(null);
                txtNomefu.setText(null);            
                txtBIfu.setText(null);                        
                DtNascimentofu.setText(null);            
                txtIdadefu.setText(null);            
                cboSexofu.setSelectedItem(null);                        
                txtMoradafu.setText(null);            
                txtFonefu.setText(null);            
                txtEmailfu.setText(null);
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void fuadicionar(){
        
        String sql = "insert into tbfuncionario(id, Nome, BI,Dat_Nascimento,Idade, Sexo, Morada, Telefone, Email) values(?,?,?,?,?,?,?,?,?)";        
        
        try{
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdfu.getText());
            pst.setString(2, txtNomefu.getText());
            pst.setString(3, txtBIfu.getText());            
            pst.setString(4, DtNascimentofu.getText());
            pst.setString(5, txtIdadefu.getText());
            pst.setString(6, cboSexofu.getSelectedItem().toString());            
            pst.setString(7, txtMoradafu.getText());
            pst.setString(8, txtFonefu.getText());
            pst.setString(9, txtEmailfu.getText());
                                
            
            int add = pst.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null,"Funcionário Cadastrado com Sucesso");
                
        
                
                txtIdfu.setText(null);            
                txtNomefu.setText(null);                
                DtNascimentofu.setText(null);            
                txtIdadefu.setText(null);            
                cboSexofu.setSelectedItem(null);
                txtBIfu.setText(null);            
                txtMoradafu.setText(null);            
                txtFonefu.setText(null);            
                txtEmailfu.setText(null);
            
            }
        
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void alterar(){
        
        String sql = "update tbfuncionario set Nome=?, BI=?,Dat_Nascimento=?,Idade=?,Sexo=?,Morada=?,Telefone=?,Email=? where id=?";        
        
        try{
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, txtNomefu.getText());
            pst.setString(2, txtBIfu.getText());            
            pst.setString(3, DtNascimentofu.getText());
            pst.setString(4, txtIdadefu.getText());
            pst.setString(5, cboSexofu.getSelectedItem().toString());            
            pst.setString(6, txtMoradafu.getText());
            pst.setString(7, txtFonefu.getText());
            pst.setString(8, txtEmailfu.getText());
            pst.setString(9, txtIdfu.getText());
            
            int add = pst.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null,"Dados alterado com Sucesso");
                            
                txtNomefu.setText(null);                        
                DtNascimentofu.setText(null);            
                txtIdadefu.setText(null);            
                cboSexofu.setSelectedItem(null);
                txtBIfu.setText(null);            
                txtMoradafu.setText(null);            
                txtFonefu.setText(null);            
                txtEmailfu.setText(null);
                txtIdfu.setText(null);
            
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void remover(){
        int confirma = JOptionPane.showConfirmDialog(null,"Tens a Certeza que queres deletar?","Atenção",JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "delete from tbfuncionario where id=?";
            
            try{
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIdfu.getText());
                
                int apagar = pst.executeUpdate();
                
                if(apagar>0){
                JOptionPane.showMessageDialog(null,"Removido com Sucesso");
                            
                txtIdfu.setText(null);
                txtNomefu.setText(null);                        
                DtNascimentofu.setText(null);            
                txtIdadefu.setText(null);            
                cboSexofu.setSelectedItem(null);
                txtBIfu.setText(null);            
                txtMoradafu.setText(null);            
                txtFonefu.setText(null);            
                txtEmailfu.setText(null);                
            
            }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNomefu = new javax.swing.JTextField();
        txtMoradafu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBIfu = new javax.swing.JTextField();
        txtFonefu = new javax.swing.JTextField();
        txtEmailfu = new javax.swing.JTextField();
        txtIdadefu = new javax.swing.JTextField();
        cboSexofu = new javax.swing.JComboBox<>();
        txtDataCadastroF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIdfu = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DtNascimentofu = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tbnSalvarF = new javax.swing.JButton();
        btnDeleteF = new javax.swing.JButton();
        btnAtualizarF = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Dt Nascimento:");

        jLabel4.setText("Cidade");

        jLabel5.setText("Telefone:");

        jLabel6.setText("E-Mail:");

        jLabel7.setText("Idade:");

        jLabel8.setText("Sexo:");

        jLabel10.setText("BI:");

        cboSexofu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cboSexofu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSexofuActionPerformed(evt);
            }
        });

        txtDataCadastroF.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setText("Data:");

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/FotoPerfil.png"))); // NOI18N
        jLabel13.setToolTipText("Perfil do usuario");

        jLabel9.setText("FOTO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel13)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFonefu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmailfu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(146, 146, 146)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(240, 240, 240)
                                .addComponent(jLabel11)))
                        .addGap(0, 263, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtMoradafu, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdfu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addComponent(txtDataCadastroF, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(txtNomefu, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtBIfu, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(DtNascimentofu, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtIdadefu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cboSexofu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDataCadastroF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdfu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomefu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIdadefu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboSexofu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DtNascimentofu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtBIfu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMoradafu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFonefu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailfu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tbnSalvarF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Editar.png"))); // NOI18N
        tbnSalvarF.setToolTipText("Editar");
        tbnSalvarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarFActionPerformed(evt);
            }
        });

        btnDeleteF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/eliminar.png"))); // NOI18N
        btnDeleteF.setToolTipText("Deletar");
        btnDeleteF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFActionPerformed(evt);
            }
        });

        btnAtualizarF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Atualizar.png"))); // NOI18N
        btnAtualizarF.setToolTipText("Pesquizar");
        btnAtualizarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarFActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Cadastrar.png"))); // NOI18N
        btnAdd.setToolTipText("Cadastrar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(54, 54, 54)
                .addComponent(btnAtualizarF)
                .addGap(51, 51, 51)
                .addComponent(btnDeleteF)
                .addGap(61, 61, 61)
                .addComponent(tbnSalvarF)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnSalvarF)
                    .addComponent(btnDeleteF)
                    .addComponent(btnAtualizarF)
                    .addComponent(btnAdd))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(759, 594));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboSexofuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSexofuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSexofuActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        fuadicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAtualizarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarFActionPerformed
        fuconsultar();
    }//GEN-LAST:event_btnAtualizarFActionPerformed

    private void btnDeleteFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFActionPerformed
        remover();
    }//GEN-LAST:event_btnDeleteFActionPerformed

    private void tbnSalvarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarFActionPerformed
        alterar();
    }//GEN-LAST:event_tbnSalvarFActionPerformed

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
            java.util.logging.Logger.getLogger(FramFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FramFuncionario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DtNascimentofu;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAtualizarF;
    private javax.swing.JButton btnDeleteF;
    private javax.swing.JComboBox<String> cboSexofu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton tbnSalvarF;
    private javax.swing.JTextField txtBIfu;
    private javax.swing.JTextField txtDataCadastroF;
    private javax.swing.JTextField txtEmailfu;
    private javax.swing.JTextField txtFonefu;
    private javax.swing.JTextField txtIdadefu;
    private javax.swing.JTextField txtIdfu;
    private javax.swing.JTextField txtMoradafu;
    private javax.swing.JTextField txtNomefu;
    // End of variables declaration//GEN-END:variables
}
