package br.com.matheushramos.action;

import br.com.matheushramos.model.Usuario;
import br.com.matheushramos.service.UsuarioService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioAction extends ActionSupport {
    private Usuario usuario;
    private List<Usuario> usuarios = new ArrayList<>();
    private Long id;
    private String mensagem;
    private String tipoMensagem;

    private final UsuarioService service;

    public UsuarioAction() {
        this.service = new UsuarioService();
    }

    public String listar() {
        try {
            usuarios = service.listarTodos();
            return SUCCESS;
        } catch (SQLException e) {
            mensagem = "Erro ao listar usuários: " + e.getMessage();
            tipoMensagem = "danger";
            return ERROR;
        }
    }

    public String novo() {
        usuario = new Usuario();
        return SUCCESS;
    }

    public String editar() {
        try {
            usuario = service.buscarPorId(id);
            if (usuario == null) {
                mensagem = "Usuário não encontrado";
                tipoMensagem = "danger";
                return ERROR;
            }
            return SUCCESS;
        } catch (SQLException e) {
            mensagem = "Erro ao buscar usuário: " + e.getMessage();
            tipoMensagem = "danger";
            return ERROR;
        }
    }

    public String salvar() {
        try {
            service.salvar(usuario);
            mensagem = usuario.getId() == null ?
                    "Usuário cadastrado com sucesso!" :
                    "Usuário atualizado com sucesso!";
            tipoMensagem = "success";
            return SUCCESS;
        } catch (IllegalArgumentException e) {
            mensagem = e.getMessage();
            tipoMensagem = "danger";
            return ERROR;
        } catch (SQLException e) {
            mensagem = "Erro ao salvar usuário: " + e.getMessage();
            tipoMensagem = "danger";
            return ERROR;
        }
    }

    public String excluir() {
        try {
            service.excluir(id);
            mensagem = "Usuário excluído com sucesso!";
            tipoMensagem = "success";
            return SUCCESS;
        } catch (SQLException e) {
            mensagem = "Erro ao excluir usuário: " + e.getMessage();
            tipoMensagem = "danger";
            return ERROR;
        }
    }
}