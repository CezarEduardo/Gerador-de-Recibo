package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    public static Connection getConnection() {
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/Recibo", "root", "cezar@8847"); // Passando os parametro para a conexão com o banco de dados(informe o usuario do bacno de dados e senha de acesso)
            System.out.println("Conexao estabelecida com sucesso!");
        } catch (SQLException ex) {
            System.err.println("ERRO 01 - Erro ao conectar no banco de dados " + ex);
        }

        return conexao;
    }
}
