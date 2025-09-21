package src.view;

import src.controller.UsuarioController;
import src.model.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    private final UsuarioController controller;
    private final Scanner sc = new Scanner(System.in);

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
    }

    // Menu principal
    public void menu() throws SQLException {
        while (true) {
            System.out.println("\n=== MENU USUÁRIOS ===");
            System.out.println("1 - Inserir usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    inserirUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Inserir usuário
    private void inserirUsuario() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Perfil: ");
        String perfil = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.print("EquipeId: ");
        int equipeId = sc.nextInt();
        sc.nextLine(); // limpar buffer

        Usuario usuario = new Usuario(0, nome, cpf, email, login, senha, perfil, cargo, equipeId);
        controller.adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    // Listar usuários
    private void listarUsuarios() throws SQLException {
        List<Usuario> usuarios = controller.listarUsuarios();
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getCargo() + " - " + u.getPerfil());
        }
    }
}