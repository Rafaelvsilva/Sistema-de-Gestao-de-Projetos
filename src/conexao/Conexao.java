package src.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Método que cria e retorna a conexão com o banco
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/nomeDoBanco"; // troque pelo nome do seu banco
        String usuario = "seuUsuario"; // troque pelo login do banco
        String senha = "suaSenha";     // troque pela senha do banco

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            // Aqui não imprime nada no console
            return null;
        }
    }

    // Teste rápido da conexão
    public static void main(String[] args) {
        Connection conexao = conectar();
        if (conexao != null) {
            System.out.println("Conexão realizada com sucesso!");
        } else {
            System.out.println("Falha na conexão!");
        }
    }
}