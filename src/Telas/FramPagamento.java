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
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mabiala
 */
public class FramPagamento extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private double tipo = 500.45;


    /**
     * Creates new form FramPagamento
     */
    public FramPagamento() {
        initComponents();
        conexao = DBconexao.conector();
        
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        txtDataPagamento.setText(formatador.format(data));
        txtDataPagamento.setEnabled(false);
    }
    private void pagconsulta3(){
        String sql = "select* from tbmatricula where id=?";
        
        try{
            pst = conexao.prepareStatement(sql); 
            pst.setString(1, txtIdP.getText());
           rs = pst.executeQuery();
            
            if(rs.next()){                
                lblCod.setText(rs.getString(1));
                lbNameP.setText(rs.getString(2));                            
                txtModalidade.setText(rs.getString(5)); 
                txtvalor.setText(rs.getString(6));
                txtCod.setText(rs.getString(7));
                
                txtvalor.setEnabled(false);
                txtCod.setEnabled(false);
                txtModalidade.setEnabled(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "Código não exite");
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void pagConsulta1(){
        String sql = "select* from tbaluno where id=?";
        
        try{
            pst = conexao.prepareStatement(sql);            
            pst.setString(1, txtIdP.getText());
           
           rs = pst.executeQuery();
            
            if(rs.next()){
                lblCod.setText(rs.getString(1));
                lbNameP.setText(rs.getString(2));
                
            }else{
                JOptionPane.showMessageDialog(null, "Aluno não Existe");
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
     private void pagConsulta2(){
        String sql = "select* from tbmodalidade where id=?";
        
        try{
            pst = conexao.prepareStatement(sql);            
            pst.setString(1, txtCod.getText());
            //pst.setString(1,txtModalidade.getText());
           
           rs = pst.executeQuery();
            
            if(rs.next()){
                //cbModalidade.setSelectedItem(rs.getString(2));
                txtvalor.setText(rs.getString(3));
                txtCod.setText(rs.getString(4));
                
            }else{
                JOptionPane.showMessageDialog(null, "Modalidade não exite");
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
     private void pagar(){
                
        String sql = "insert into tbpagamento(id, Nome, Mes, Proxi_pagamento, valor, Multa, Exercicio) values (?,?,?,?,?,?,?)";
        
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1,lblCod.getText());
            pst.setString(2,lbNameP.getText());                                            
            pst.setString(3, cbtxtMes.getSelectedItem().toString());
            pst.setString(4, ProxiPag.getText());
            pst.setString(5, txtvalor.getText());            
            pst.setString(6, txtMulta.getText());
            pst.setString(7,txtModalidade.getText());                                                
           // pst.setString(8,txtCod.getText());
            
            int add = pst.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null,"Pagamento Sucedido");
               
                lblCod.setText(null);
                lbNameP.setText(null);
                cbtxtMes.setSelectedItem(null);            
                ProxiPag.setText(null);            
                txtvalor.setText(null);                        
                txtMulta.setText(null);            
                txtModalidade.setText(null);                                                            
                txtCod.setText(null);
               
            }
        
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void Imprimir(){
        int confirma = JOptionPane.showConfirmDialog(null,"Confirmar a Impressão?","Atençao",JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION){
            
            try{
                HashMap filtro = new HashMap();
                filtro.put("id", Integer.valueOf(txtIdP.getText()));
                
                JasperPrint print = JasperFillManager.fillReport("/home/mabiala/NetBeansProjects/AcademiaISPT/Relatorio/Pagamento1.jasper", filtro, conexao);
                JasperViewer.viewReport(print, false);
                
            }catch (Exception e){
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDataPagamento = new javax.swing.JTextField();
        txtvalor = new javax.swing.JTextField();
        txtIdP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lbNameP = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMes = new javax.swing.JLabel();
        ProxiPag = new javax.swing.JTextField();
        cbxMulta = new javax.swing.JCheckBox();
        txtMulta = new javax.swing.JTextField();
        cbtxtMes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtModalidade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnLancar = new javax.swing.JButton();
        btnConsultarP = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamento");

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setText("Digite Código do Aluno:");

        jLabel2.setText("Código:");

        jLabel3.setText("Treino de Exercício:");

        jLabel5.setText("Dt. Pagamento:");

        jLabel6.setText("Proxi. Pagamento:");

        jLabel7.setText("Valor Kz:");

        txtDataPagamento.setBackground(new java.awt.Color(153, 255, 153));

        jLabel8.setText("Nome:");

        lbNameP.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbNameP.setText(".");

        lblCod.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblCod.setText(".");

        lblMes.setText("Mês:");

        cbxMulta.setText("Multa:");
        cbxMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMultaActionPerformed(evt);
            }
        });

        txtMulta.setText("0");

        cbtxtMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel4.setText("Codigo");

        txtCod.setBackground(new java.awt.Color(153, 255, 153));

        txtModalidade.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(lbNameP, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(lblMes)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbtxtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxMulta)
                                            .addComponent(txtMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ProxiPag))
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(50, 50, 50)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtModalidade)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(107, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbtxtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCod)
                    .addComponent(lbNameP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxMulta)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProxiPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnLancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Salvar.png"))); // NOI18N
        btnLancar.setToolTipText("lançar");
        btnLancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancarActionPerformed(evt);
            }
        });

        btnConsultarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Atualizar.png"))); // NOI18N
        btnConsultarP.setToolTipText("Consultar");
        btnConsultarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Imprimir.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(59, 59, 59)
                .addComponent(btnConsultarP)
                .addGap(42, 42, 42)
                .addComponent(btnLancar)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLancar)
                            .addComponent(btnConsultarP))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(748, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPActionPerformed
        pagconsulta3();        
    }//GEN-LAST:event_btnConsultarPActionPerformed

    private void btnLancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancarActionPerformed
        pagar();
    }//GEN-LAST:event_btnLancarActionPerformed

    private void cbxMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMultaActionPerformed
        if(cbxMulta.isSelected()){
            txtMulta.setText(String.valueOf(500.25));
        }else{
            txtMulta.setText(null);
        }
    }//GEN-LAST:event_cbxMultaActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        Imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(FramPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FramPagamento().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ProxiPag;
    private javax.swing.JButton btnConsultarP;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLancar;
    private javax.swing.JComboBox<String> cbtxtMes;
    private javax.swing.JCheckBox cbxMulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbNameP;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblMes;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDataPagamento;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtModalidade;
    private javax.swing.JTextField txtMulta;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
