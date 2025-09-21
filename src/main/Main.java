package src.main;

import src.dao.UsuarioDAO;
import src.model.Usuario;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Configuração do banco de dados
        String url = "jdbc:mysql://localhost:3306/seu_banco"; // substitua "seu_banco"
        String user = "root"; // seu usuário do banco
        String password = "sua_senha"; // sua senha do banco

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Criar o DAO
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);

            // 1️⃣ Inserir um novo usuário
            Usuario novoUsuario = new Usuario(
                0,                     // id (vai ser gerado automaticamente)
                "Larissa",             // nome
                "12345678900",         // cpf
                "larissa@email.com",   // email
                "larissa",             // login
                "1234",                // senhaHash
                "ADMIN",               // perfil
                "Gerente",             // cargo
                1                      // equipeId
            );

            usuarioDAO.inserir(novoUsuario);
            System.out.println("Usuário inserido com ID: " + novoUsuario.getId());

            // 2️⃣ Listar todos os usuários
            System.out.println("\nLista de usuários:");
            for (Usuario u : usuarioDAO.listarTodos()) {
                System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getCargo() + " - " + u.getPerfil());
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou acessar o banco:");
            e.printStackTrace();
        }
    }
}