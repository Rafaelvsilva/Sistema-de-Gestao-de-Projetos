package src.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Método que cria e retorna a conexão com o banco
    public static Connection conectar() {
        // Substitua pelos dados corretos do seu banco
        String url = "jdbc:mysql://localhost:3306/nomeDoBanco"; // nome do banco
        String usuario = "seuUsuario"; // usuário do MySQL
        String senha = "suaSenha"; // senha do MySQL

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace(); // mostra o erro real
            return null;
        }
    }

    // Teste rápido da conexão
    public static void main(String[] args) {
        conectar();
    }
}