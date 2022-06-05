
package Views;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class TelaPrincipal extends javax.swing.JFrame {
    Connection connection;
    DBFunctions dbFunctions = new DBFunctions();

    /**
     * Creates new form Interface
     */
    public TelaPrincipal() {
        initComponents();
        dbFunctions.openConnection();
        fillTable();
    }

    private void fillTable() {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        dbFunctions.getData(jTable1);  
        jTable1.getColumnModel().getColumn(4).setCellRenderer(renderer);
    }
    
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
     @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 

         String str = (String) value;
         if ("Fechado".equals(str)) {
             c.setBackground(Color.GREEN);
        } else {
             c.setBackground(Color.RED);
         }
         
return c;
   }
    };

    private void closeConnection() throws Exception {
        connection.close();
    }

    @Override
    protected void finalize() throws Throwable {
        closeConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Descricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        Clean = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Create = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Pesquisa = new javax.swing.JTextField();
        SearchOp = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox<>();
        Data = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        jLabel1.setText("ID:");

        Id.setEditable(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Descrição");

        jLabel4.setText("Data");

        Search.setText("Buscar");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Clean.setText("Limpar");
        Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanActionPerformed(evt);
            }
        });

        Delete.setText("Remover");
        Delete.setEnabled(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Create.setText("Inserir");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Update.setText("Alterar");
        Update.setEnabled(false);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrição", "Data", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel5.setText("Pesquisa: ");

        SearchOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item", "Data" }));

        jLabel6.setText("Status");

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Aberto", "Fechado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(SearchOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Search))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(173, 330, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel6))
                                                .addGap(77, 77, 77)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Id, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                    .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                    .addComponent(Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                    .addComponent(Status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(Data))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(Update)
                                .addGap(57, 57, 57)
                                .addComponent(Delete)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Clean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Create)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Delete)
                                            .addComponent(Update))
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Clean)
                                            .addComponent(Create))
                                        .addGap(77, 77, 77))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCleaner(){
        Id.setText("");
        Nome.setText("");
        Descricao.setText("");
        Data.setText("");
        Pesquisa.setText("");
        Search.setEnabled(true);
        Create.setEnabled(true);
        Pesquisa.setEnabled(true);
        SearchOp.setEnabled(true);
        Delete.setEnabled(false);
        Update.setEnabled(false);
        Status.setSelectedIndex(0);
        SearchOp.setSelectedIndex(0);
        fillTable();
    }
    
    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        if(dbFunctions.create(Nome.getText(), Descricao.getText(), Data.getText(), Status.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
            fieldCleaner();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Inserção não realizada!");
        }

            
    }//GEN-LAST:event_CreateActionPerformed

    private void CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanActionPerformed
        fieldCleaner();
    }//GEN-LAST:event_CleanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount() == 2){
            Search.setEnabled(false);
            Create.setEnabled(false);
            Pesquisa.setEnabled(false);
            SearchOp.setEnabled(false);
            Delete.setEnabled(true);
            Update.setEnabled(true);
            int row = (jTable1.getSelectedRow());
            Id.setText((String)jTable1.getModel().getValueAt(row, 0));
            Nome.setText((String)jTable1.getModel().getValueAt(row, 1));
            Descricao.setText((String)jTable1.getModel().getValueAt(row, 2));
            Data.setText((String)jTable1.getModel().getValueAt(row, 3));
            Status.setSelectedItem(jTable1.getModel().getValueAt(row,4));
           
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        int op = SearchOp.getSelectedIndex();
        System.out.println(op);
        int i;
        switch(op){
            case 1:
                String nome = Pesquisa.getText();
                
                for (i = 0; i < jTable1.getRowCount(); i++) {
                    if (jTable1.getValueAt(i, 1).toString().contains(nome)) {
                        jTable1.setRowSelectionInterval(i, i);
                        Id.setText(jTable1.getValueAt(i, 0).toString());
                        Nome.setText(jTable1.getValueAt(i, 1).toString());
                        Descricao.setText(jTable1.getValueAt(i, 2).toString());
                        Data.setText(jTable1.getValueAt(i, 3).toString());
                        Update.setEnabled(true);
                        Delete.setEnabled(true);
                        Create.setEnabled(false);
                        break;
                    }
                }
                if (i == jTable1.getRowCount()) {
                    jTable1.clearSelection();
                    Id.setText("");
                    Nome.setText("");
                    Descricao.setText("");
                    Data.setText("");
                    Delete.setEnabled(false);
                    Update.setEnabled(false);
                    Create.setEnabled(true);

                    JOptionPane.showMessageDialog(
                            this,
                            "Elemento não encontrado!",
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                String data = Pesquisa.getText();
                
                for (i = 0; i < jTable1.getRowCount(); i++) {
                    if (jTable1.getValueAt(i, 3).toString().contains(data)) {
                        jTable1.setRowSelectionInterval(i, i);
                        Id.setText(jTable1.getValueAt(i, 0).toString());
                        Nome.setText(jTable1.getValueAt(i, 1).toString());
                        Descricao.setText(jTable1.getValueAt(i, 2).toString());
                        Data.setText(jTable1.getValueAt(i, 3).toString());
                        Update.setEnabled(true);
                        Delete.setEnabled(true);
                        Create.setEnabled(false);
                        break;
                    }
                }
                if (i == jTable1.getRowCount()) {
                    jTable1.clearSelection();
                    Id.setText("");
                    Nome.setText("");
                    Descricao.setText("");
                    Data.setText("");
                    Delete.setEnabled(false);
                    Update.setEnabled(false);
                    Create.setEnabled(true);

                    JOptionPane.showMessageDialog(
                            this,
                            "Elemento não encontrado!",
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        
    }//GEN-LAST:event_SearchActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        String[] options = {"Sim", "Não"};
        int answ = JOptionPane.showOptionDialog(null, "Deseja deletar??", "Confirmar delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (answ == 1) {
            JOptionPane.showMessageDialog(null, "Não deletado");
            return;
        }

        if(dbFunctions.delete(Id.getText())){
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            fieldCleaner();
        }
        else{
            JOptionPane.showMessageDialog(null, "Não deletado!");
        }
        
        
    }//GEN-LAST:event_DeleteActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed

        if(Nome.getText().equals("") || Descricao.getText().equals("") || Data.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para atualizar!");
            return;
        }
        if(dbFunctions.update(Id.getText(), Nome.getText(), Descricao.getText(), Data.getText(), Status.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "Produto atualizado!");
            fieldCleaner();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Produto não atualizado!");
        }
   
    }//GEN-LAST:event_UpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clean;
    private javax.swing.JButton Create;
    private javax.swing.JFormattedTextField Data;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Descricao;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField Pesquisa;
    private javax.swing.JButton Search;
    private javax.swing.JComboBox<String> SearchOp;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
