package src.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    
    public static Connection conectar() {
        String url = "jdbc:mysql://127.0.0.1:3306/sistema_gestao?useSSL=false&serverTimezone=UTC";
        String usuario = "seuUsuario";
        String senha = "suaSenha";

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            return null;
        }
    }

    
    public static void main(String[] args) {
        Connection conexao = conectar();
        if (conexao != null) {
            System.out.println("Conexão realizada com sucesso!");
        } else {
            System.out.println("Falha na conexão!");
        }
    }
}