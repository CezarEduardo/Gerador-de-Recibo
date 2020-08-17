package banco;

import classes.Cobrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cezar
 */
public class ReciboDao {

    public void insertCobrador(Cobrador cobrador) throws SQLException {

        Connection conexao = Conexao.getConnection(); //Abrindo a conexão do banco de dado.
        PreparedStatement stmt = null; // Inicializando o stmt2 com null.

        try {
            stmt = conexao.prepareStatement("INSERT INTO Cobrador (Nome_cobrador,Endereco_cobrador,Cnpj_cobrador, Valor,id, Dataa, Local_cobrador, Referencia, Nome_pagador, Endereco_pagador, te)VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, cobrador.getNome_cobrador());
            stmt.setString(2, cobrador.getEndereco_cobrador());
            stmt.setString(3, cobrador.getCnpj_cobrador());//Passando os paramentro dos dados a serem salvo no banco
            stmt.setDouble(4, cobrador.getValor());
            stmt.setInt(5, cobrador.getId());
            stmt.setDate(6, new java.sql.Date(cobrador.getData().getTime()));
            stmt.setString(7, cobrador.getLocal());
            stmt.setString(8, cobrador.getReferencia());
            stmt.setString(9, cobrador.getNome_pagador());
            stmt.setString(10, cobrador.getEndereco_pagador());
            stmt.setString(11, cobrador.getCnpj_pagador());
            stmt.executeUpdate(); // Executando o script do mysql para ser inserido no banco.

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "(Erro 03) - Erro ao salvar os dados");
            System.err.println("ERRO: 03 - Erro ao salvar os dados da tabela Cobrador " + ex);
            

        } finally {

            conexao.close(); //Fechando a conexão com o banco de dados. 
            stmt.close(); //Fechado execução do prepareStatement.

        }
    }

    public void alterar(Cobrador cobrador) throws SQLException {
        Connection conexao = Conexao.getConnection(); //Abrindo a conexão do banco de dado.
        PreparedStatement stmt = null; // Inicializando o stmt2 com null.

        try {
            stmt = conexao.prepareStatement("UPDATE Cobrador SET Nome_cobrador = ? , Endereco_cobrador = ? , Cnpj_cobrador = ? , Valor = ?, Dataa = ?, Local_cobrador = ?, Referencia = ?, Nome_pagador = ?, Endereco_pagador = ?, cnpj_pagador = ? WHERE id = ?");

            stmt.setString(1, cobrador.getNome_cobrador());
            stmt.setString(2, cobrador.getEndereco_cobrador());
            stmt.setString(3, cobrador.getCnpj_cobrador());//Passando os paramentro dos dados a serem salvo no banco
            stmt.setDouble(4, cobrador.getValor());
            stmt.setDate(5, new java.sql.Date(cobrador.getData().getTime()));
            stmt.setString(6, cobrador.getLocal());
            stmt.setString(7, cobrador.getReferencia());
            stmt.setString(8, cobrador.getNome_pagador());
            stmt.setString(9, cobrador.getEndereco_pagador());
            stmt.setString(10, cobrador.getCnpj_pagador());
            stmt.setInt(11, cobrador.getId());

            stmt.executeUpdate(); // Executando o script do mysql para ser inserido no banco.

        } catch (SQLException ex) {

            System.err.println("ERRO: 03 - Erro ao altera os dados da tabela Cobrador " + ex);
            JOptionPane.showMessageDialog(null, "(Erro 03) - Erro ao alterar os dados");

        } finally {

            conexao.close(); //Fechando a conexão com o banco de dados. 
            stmt.close(); //Fechado execução do prepareStatement.

        }
    }

    public void Delete(Cobrador cobrador) throws SQLException {

        Connection conexao = Conexao.getConnection(); //Abrindo a conexão do banco de dado.
        PreparedStatement stmt = null; // Inicializando o stmt2 com null.

        try {
            stmt = conexao.prepareStatement("DELETE FROM Cobrador WHERE id = ? ");

            stmt.setInt(1, cobrador.getId());

            stmt.executeUpdate(); // Executando o script do mysql para ser inserido no banco.

        } catch (SQLException ex) {

            System.err.println("ERRO: 06 - Erro ao editar os dados da tabela Cobrador" + ex);
            JOptionPane.showMessageDialog(null, "(Erro 06) - Erro ao editar os dados");

        } finally {

            conexao.close(); //Fechando a conexão com o banco de dados. 
            stmt.close(); //Fechado execução do prepareStatement.

        }
    }

    public void mostrar(Cobrador corabdor) throws SQLException {

    }

}
