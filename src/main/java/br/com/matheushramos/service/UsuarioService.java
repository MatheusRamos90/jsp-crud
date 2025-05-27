package br.com.matheushramos.service;

import br.com.matheushramos.dao.UsuarioDao;
import br.com.matheushramos.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {
    private final UsuarioDao dao;

    public UsuarioService() {
        this.dao = new UsuarioDao();
    }

    public List<Usuario> listarTodos() throws SQLException {
        return dao.listarTodos();
    }

    public Usuario buscarPorId(Long id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public void salvar(Usuario usuario) throws SQLException {
        if (usuario.getId() == null && dao.emailExiste(usuario.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        dao.salvar(usuario);
    }

    public void excluir(Long id) throws SQLException {
        dao.excluir(id);
    }
}