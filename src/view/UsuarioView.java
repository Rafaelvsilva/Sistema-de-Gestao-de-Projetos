package src.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import src.controller.UsuarioController;
import src.model.Usuario;

public class UsuarioView {
    private final UsuarioController controller;
    private final Scanner sc = new Scanner(System.in);

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
    }

    public void menu() throws SQLException {
        while (true) {
            System.out.println("\n=== MENU USUÁRIOS ===");
            System.out.println("1 - Inserir usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Deletar usuário");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> inserirUsuario();
                case 2 -> listarUsuarios();
                case 3 -> atualizarUsuario();
                case 4 -> deletarUsuario();
                case 5 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void inserirUsuario() throws SQLException {
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("CPF: "); String cpf = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Login: "); String login = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();
        System.out.print("Perfil: "); String perfil = sc.nextLine();
        System.out.print("Cargo: "); String cargo = sc.nextLine();
        System.out.print("EquipeId: "); int equipeId = sc.nextInt(); sc.nextLine();

        Usuario usuario = new Usuario(0, nome, cpf, email, login, senha, perfil, cargo, equipeId);
        controller.adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private void listarUsuarios() throws SQLException {
        List<Usuario> usuarios = controller.listarUsuarios();
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getCargo() + " - " + u.getPerfil());
        }
    }

    private void atualizarUsuario() throws SQLException {
        System.out.print("Informe o ID do usuário que deseja atualizar: ");
        int id = sc.nextInt(); sc.nextLine();

        Usuario usuario = controller.buscarUsuario(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        System.out.print("Nome (" + usuario.getNome() + "): "); String nome = sc.nextLine();
        if (!nome.isEmpty()) usuario.setNome(nome);

        System.out.print("CPF (" + usuario.getCpf() + "): "); String cpf = sc.nextLine();
        if (!cpf.isEmpty()) usuario.setCpf(cpf);

        System.out.print("Email (" + usuario.getEmail() + "): "); String email = sc.nextLine();
        if (!email.isEmpty()) usuario.setEmail(email);

        System.out.print("Login (" + usuario.getLogin() + "): "); String login = sc.nextLine();
        if (!login.isEmpty()) usuario.setLogin(login);

        System.out.print("Senha (" + usuario.getSenhaHash() + "): "); String senha = sc.nextLine();
        if (!senha.isEmpty()) usuario.setSenhaHash(senha);

        System.out.print("Perfil (" + usuario.getPerfil() + "): "); String perfil = sc.nextLine();
        if (!perfil.isEmpty()) usuario.setPerfil(perfil);

        System.out.print("Cargo (" + usuario.getCargo() + "): "); String cargo = sc.nextLine();
        if (!cargo.isEmpty()) usuario.setCargo(cargo);

        System.out.print("EquipeId (" + usuario.getEquipeId() + "): "); String eq = sc.nextLine();
        if (!eq.isEmpty()) usuario.setEquipeId(Integer.parseInt(eq));

        controller.atualizarUsuario(usuario);
        System.out.println("Usuário atualizado com sucesso!");
    }

    private void deletarUsuario() throws SQLException {
        System.out.print("Informe o ID do usuário que deseja deletar: ");
        int id = sc.nextInt(); sc.nextLine();

        Usuario usuario = controller.buscarUsuario(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        controller.removerUsuario(id);
        System.out.println("Usuário deletado com sucesso!");
    }
}