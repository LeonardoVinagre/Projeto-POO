package Views;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DBFunctions {

    Connection connection;
    String server = "jdbc:mysql://localhost:3306/achadosperdidos";
    String username = "adm";
    String password = "root";

    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    server,
                    username,
                    password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Conexão com o banco falhou!",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public void getData(javax.swing.JTable dm) {

        String sql = "SELECT * FROM produto";
        System.out.println("chego");
        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String linha[]
                        = {
                            String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                        };
                
                ((DefaultTableModel) dm.getModel()).addRow(linha);
            }
            
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public Boolean create(String nome, String desc, String data, String status) {
        try {
            if (nome.equals("") || desc.equals("") || data.equals("") || status.equals("")) {
                throw new Exception("Prreencha todos os campos!");
            }
            String sql = "INSERT INTO produto VALUES(null,'" + nome + "','" + desc + "','" + data + "','" + status + "')";
            if (verifyExistence(nome) == true) {
                throw new Exception("Produto ja inserido!");
            }

            Statement s = connection.prepareStatement(sql);
            s.execute(sql);
            s.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public Boolean delete(String id) {
        try {
            if (id.equals("")) {
                throw new Exception("Erro nenhum produto selecionado!");
            }
            String sql = "DELETE FROM produto WHERE id_produto='" + id + "'";
            Statement s = connection.prepareStatement(sql);
            s.execute(sql);
            s.close();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERRO ao deletar!",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public Boolean update(String id, String nome, String desc, String data, String status) {
        String sql = "UPDATE produto SET nome_produto ='" + nome
                + "',descricao_produto='" + desc
                + "',data_produto='" + data
                + "',status_produto='" + status
                + "' WHERE id_produto='" + id + "'";
        try {
            Statement s = connection.prepareStatement(sql);
            s.execute(sql);
            s.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public Boolean verifyExistence(String nome) {
        String sql = "SELECT * FROM produto WHERE nome_produto='" + nome + "'";

        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            if (rs.next() == true) {
                s.close();
                return true;
            }
            s.close();
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao verificar!",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }

    
}


// public void search(String nome, String preco, String qntd, javax.swing.JTable dm) {
//        try {
//            if (nome != "" && preco.equals("") && qntd.equals("")) {
//                ((DefaultTableModel) dm.getModel()).setRowCount(0);
//                String sql = "SELECT * FROM produto WHERE nome_produto='" + nome + "'";
//                Statement s = connection.prepareStatement(sql);
//                ResultSet rs = s.executeQuery(sql);
//                while (rs.next()) {
//                    String linha[]
//                            = {
//                                String.valueOf(rs.getInt(1)),
//                                rs.getString(2),
//                                rs.getString(3),
//                                String.valueOf(rs.getInt(4))
//                            };
//                    ((DefaultTableModel) dm.getModel()).addRow(linha);
//
//                }
//                s.close();
//                return;
//            }
//            if (nome.equals("") && preco != "" && qntd.equals("")) {
//                ((DefaultTableModel) dm.getModel()).setRowCount(0);
//                String sql = "SELECT * FROM produto WHERE preco_produto='" + preco + "'";
//                Statement s = connection.prepareStatement(sql);
//                ResultSet rs = s.executeQuery(sql);
//                while (rs.next()) {
//                    String linha[]
//                            = {
//                                String.valueOf(rs.getInt(1)),
//                                rs.getString(2),
//                                rs.getString(3),
//                                String.valueOf(rs.getInt(4))
//                            };
//                    ((DefaultTableModel) dm.getModel()).addRow(linha);
//
//                }
//                s.close();
//                return;
//            }
//            if (nome.equals("") && preco.equals("") && qntd != "") {
//                ((DefaultTableModel) dm.getModel()).setRowCount(0);
//                String sql = "SELECT * FROM produto WHERE quantidade_produto='" + qntd + "'";
//                Statement s = connection.prepareStatement(sql);
//                ResultSet rs = s.executeQuery(sql);
//                while (rs.next()) {
//                    String linha[]
//                            = {
//                                String.valueOf(rs.getInt(1)),
//                                rs.getString(2),
//                                rs.getString(3),
//                                String.valueOf(rs.getInt(4))
//                            };
//                    ((DefaultTableModel) dm.getModel()).addRow(linha);
//
//                }
//                s.close();
//                return;
//            } 
//            
//            throw new Exception("Insira apenas um campo para busca!");
//           
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(
//                    null,
//                    e.getMessage(),
//                    "ERRO",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }