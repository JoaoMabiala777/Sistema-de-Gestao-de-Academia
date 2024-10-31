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
public class FramMatricula extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private String tipo;

    /**
     * Creates new form FramMatricula
     */
    public FramMatricula() {
        initComponents();
        conexao = DBconexao.conector();
        
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        txtDataM.setText(formatador.format(data));
        
        txtDataM.setEnabled(false);
    }
    private void maconsulta3(){
        String num = JOptionPane.showInputDialog("Insira o ID do Aluno");
        String sql = "select* from tbmatricula where id=" + num;
        
        try{
            pst = conexao.prepareStatement(sql);                                
           rs = pst.executeQuery();
            
            if(rs.next()){                
                txtIdM.setText(rs.getString(1));            
                lbName.setText(rs.getString(2));            
                txtValor.setText(rs.getString(3));
                lbModalidade.setText(rs.getString(5));
                lblPreco.setText(rs.getString(6));
                
                String txtmensal = rs.getString(7);
                if(txtmensal.equals("Mensal")){
                    tipo = "Mensal";
                }else if(txtSemestral.equals("Semestral")){
                    txtSemestral.setSelected(true);
                        tipo ="Semestral";
                        }else{
                    txtTrimestral.setSelected(true);
                    tipo = "Trimestral";
                }
                txtIdM.setEnabled(false);
                txtValor.setEnabled(false);        
                btnAdd.setEnabled(false); 
                txtmodalidade.setEnabled(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "Código não exite");
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void maconsultar2(){
        String sql = "select* from tbmodalidade where id=?";
        
        try{
            pst = conexao.prepareStatement(sql);            
            pst.setString(1,txtmodalidade.getText());
           
           rs = pst.executeQuery();
            
            if(rs.next()){                
                //lblcod.setText(rs.getString(1));
                lbModalidade.setText(rs.getString(2));
                lblPreco.setText(rs.getString(3));
                
            }else{
                JOptionPane.showMessageDialog(null, "Código não exite");
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    private void maconsultar1(){
        String sql = "select* from tbaluno where id=?";
        
        try{
            pst = conexao.prepareStatement(sql);            
            pst.setString(1, txtIdM.getText());
           
           rs = pst.executeQuery();
            
            if(rs.next()){
                lbName.setText(rs.getString(2));
                
            }else{
                JOptionPane.showMessageDialog(null, "Aluno não Existe");
            }
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    private void matricular(){
                
        String sql = "insert into tbmatricula(id, Nome, valor,Excercicio,PrecoModalidade, PlanoPagamento) values (?,?,?,?,?,?)";
        
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdM.getText());
            pst.setString(2, lbName.getText());
            pst.setString(3, txtValor.getText());          
            pst.setString(4, lbModalidade.getText());
            pst.setString(5, lblPreco.getText());
            pst.setString(6,tipo);
           // pst.setString(6, lblcod.getText());
           // pst.setString(7, txtIdM.getText());
            
            int add = pst.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null,"Aluno Matriculado com Sucesso");
                                            
                txtIdM.setText(null);             
                lbName.setText(null);            
                txtValor.setText(null);                      
                lbModalidade.setText(null);
                lblPreco.setText(null);
               // lblcod.setText(null);                   
            
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
                filtro.put("id", Integer.valueOf(txtIdM.getText()));
                
                JasperPrint print = JasperFillManager.fillReport("/home/mabiala/NetBeansProjects/AcademiaISPT/Relatorio/Matricula1.jasper", filtro, conexao);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnImprimirM = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtmensal = new javax.swing.JRadioButton();
        txtSemestral = new javax.swing.JRadioButton();
        txtTrimestral = new javax.swing.JRadioButton();
        txtIdM = new javax.swing.JTextField();
        txtmodalidade = new javax.swing.JTextField();
        lbModalidade = new javax.swing.JLabel();
        txtDataM = new javax.swing.JTextField();
        try {
            jButton3 =(javax.swing.JButton)java.beans.Beans.instantiate(getClass().getClassLoader(), "Telas.FramMatricula_jButton3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jButton4 = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();
        ValorM = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matrícula");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Salvar.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Atualizar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnImprimirM.setBackground(new java.awt.Color(204, 204, 204));
        btnImprimirM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Imprimir.png"))); // NOI18N
        btnImprimirM.setToolTipText("Imprimir");
        btnImprimirM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(445, Short.MAX_VALUE)
                .addComponent(btnImprimirM)
                .addGap(48, 48, 48)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimirM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(btnAdd))))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setText("Código Aluno:");

        jLabel2.setText("Data:");

        jLabel3.setText("Nome:");

        lbName.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName.setText(".");

        jLabel5.setText("Digite o Código da Modalidade:");

        jLabel7.setText("Descrição:");

        jLabel8.setText("Valor Kz:");

        jLabel10.setText("Plano de Pagamento:");

        buttonGroup1.add(txtmensal);
        txtmensal.setText("Mensal");
        txtmensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmensalActionPerformed(evt);
            }
        });

        buttonGroup1.add(txtSemestral);
        txtSemestral.setText("Semestral");
        txtSemestral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSemestralActionPerformed(evt);
            }
        });

        buttonGroup1.add(txtTrimestral);
        txtTrimestral.setText("Trimestral");
        txtTrimestral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrimestralActionPerformed(evt);
            }
        });

        lbModalidade.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbModalidade.setText(".");

        txtDataM.setBackground(new java.awt.Color(153, 255, 153));
        txtDataM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataMActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ValorM.setText("Preço:");

        lblPreco.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblPreco.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataM, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmodalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ValorM, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(77, 77, 77)
                                    .addComponent(txtmensal)
                                    .addGap(89, 89, 89)
                                    .addComponent(txtSemestral)
                                    .addGap(48, 48, 48)
                                    .addComponent(txtTrimestral)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(437, 437, 437))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)))
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtmodalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ValorM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbModalidade)
                    .addComponent(lblPreco))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtmensal)
                    .addComponent(txtSemestral)
                    .addComponent(txtTrimestral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(292, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(190, 190, 190)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataMActionPerformed
       
    }//GEN-LAST:event_txtDataMActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        maconsulta3();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        matricular();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        maconsultar2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnImprimirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirMActionPerformed
        Imprimir();
    }//GEN-LAST:event_btnImprimirMActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       maconsultar1();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtmensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmensalActionPerformed
       tipo = "Mensal";
    }//GEN-LAST:event_txtmensalActionPerformed

    private void txtSemestralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSemestralActionPerformed
        tipo = "Semestral";
    }//GEN-LAST:event_txtSemestralActionPerformed

    private void txtTrimestralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrimestralActionPerformed
       tipo = "Trimestral";
    }//GEN-LAST:event_txtTrimestralActionPerformed

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
            java.util.logging.Logger.getLogger(FramMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FramMatricula().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ValorM;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnImprimirM;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbModalidade;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JTextField txtDataM;
    private javax.swing.JTextField txtIdM;
    private javax.swing.JRadioButton txtSemestral;
    private javax.swing.JRadioButton txtTrimestral;
    private javax.swing.JTextField txtValor;
    private javax.swing.JRadioButton txtmensal;
    private javax.swing.JTextField txtmodalidade;
    // End of variables declaration//GEN-END:variables
}
