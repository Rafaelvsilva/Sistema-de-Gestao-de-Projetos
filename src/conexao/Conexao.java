package src.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Método que cria e retorna a conexão com o banco
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/nomeDoBanco"; // troque pelo nome do seu banco
        String usuario = "seuUsuario"; // troque pelo login do banco
        String senha = "suaSenha"; // troque pela senha do banco

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
            return null;
        }
    }
}