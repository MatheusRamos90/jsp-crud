package br.com.matheushramos.filter;

import br.com.matheushramos.util.RelatorioAtividadeManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter para interceptar e registrar as atividades de usuários
 */
public class AtividadeUsuarioFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização do filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String method = httpRequest.getMethod();
        String servletPath = httpRequest.getServletPath();

        // Processa a requisição normalmente
        chain.doFilter(request, response);

        // Após o processamento, atualiza os contadores se necessário
        if (method.equals("POST") && servletPath.equals("/salvarUsuario.action")) {
            // Se tiver ID na requisição, é edição, senão é criação
            String id = request.getParameter("usuario.id");
            if (id != null && !id.isEmpty()) {
                RelatorioAtividadeManager.incrementarEdicoes(request.getServletContext());
            } else {
                RelatorioAtividadeManager.incrementarCadastros(request.getServletContext());
            }
        } else if (method.equals("GET") && servletPath.equals("/excluirUsuario")) {
            RelatorioAtividadeManager.incrementarRemocoes(request.getServletContext());
        }
    }

    @Override
    public void destroy() {
        // Limpeza do filter
    }
} 