package src.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import src.controller.UsuarioController;
import src.dao.UsuarioDAO;
import src.view.UsuarioView;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco"; // substitua pelo seu banco
        String user = "root"; // usuário do banco
        String password = "sua_senha"; // senha do banco

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            UsuarioDAO dao = new UsuarioDAO(conn);
            UsuarioController controller = new UsuarioController(dao);
            UsuarioView view = new UsuarioView(controller);

            view.menu(); // inicia o menu interativo

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou acessar o banco:");
            e.printStackTrace();
        }
    }
}