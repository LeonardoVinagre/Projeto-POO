package Views;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DBFunctions {

    Connection connection;
    String server = "jdbc:mysql://localhost:3306/achadosperdidos";
    String username = "adm";
    String password = "toor";

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

    public void closeConnection() {
        closeConnection();
    }

    public void getData(javax.swing.JTable dm) {

        String sql = "SELECT * FROM produto";

        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String data = rs.getString(4);
                String[] format = data.split("-");
                String newData = format[2] + "-" + format[1] + "-" + format[0];
                String linha[]
                        = {
                            String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getString(3),
                            newData,
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
            String[] format = data.split("-");

            String newData = format[2] + "-" + format[1] + "-" + format[0];

            String sql = "INSERT INTO produto VALUES(null,'" + nome + "','" + desc + "','" + newData + "','" + status + "')";
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
        String[] format = data.split("-");

        String newData = format[2] + "-" + format[1] + "-" + format[0];
        String sql = "UPDATE produto SET nome_produto ='" + nome
                + "',descricao_produto='" + desc
                + "',data_produto='" + newData
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

    public Boolean createUser(String login, String senha, String nome) {
        String sql = "INSERT INTO usuario VALUES('" + login + "',SHA1('" + senha + "'),'" + nome + "')";

        try {
            if (nome.equals("") || login.equals("") || senha.equals("")) {
                throw new Exception("Preencha todos os campos!");
            }
            Statement s = connection.prepareStatement(sql);
            s.execute(sql);
            s.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Dados invalidos para criação!",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean login(String login, String password) {
        try {
            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery(
                    "SELECT * FROM usuario WHERE login='"
                    + login
                    + "' AND senha=SHA1('"
                    + password
                    + "');"
            );
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
