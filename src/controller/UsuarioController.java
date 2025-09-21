package src.controller;

import src.dao.UsuarioDAO;
import src.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    // Construtor recebe o DAO
    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    // Adiciona um usuário
    public void adicionarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.inserir(usuario);
    }

    // Atualiza um usuário
    public void atualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.atualizar(usuario);
    }

    // Remove um usuário pelo ID
    public void removerUsuario(int id) throws SQLException {
        usuarioDAO.deletar(id);
    }

    // Busca um usuário pelo ID
    public Usuario buscarUsuario(int id) throws SQLException {
        return usuarioDAO.buscarPorId(id);
    }

    // Lista todos os usuários
    public List<Usuario> listarUsuarios() throws SQLException {
        return usuarioDAO.listarTodos();
    }
}
