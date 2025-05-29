package br.com.matheushramos.util;

import java.time.LocalDateTime;

/**
 * Classe utilitária para gerenciar os contadores e timestamps das atividades de usuários
 */
public class RelatorioAtividadeManager {
    private static final String ATTR_USUARIOS_CADASTRADOS = "usuariosCadastrados";
    private static final String ATTR_USUARIOS_EDITADOS = "usuariosEditados";
    private static final String ATTR_USUARIOS_REMOVIDOS = "usuariosRemovidos";
    private static final String ATTR_ULTIMA_ACAO = "ultimaAcao";

    /**
     * Incrementa o contador de usuários cadastrados
     */
    public static void incrementarCadastros(javax.servlet.ServletContext context) {
        Integer cadastros = (Integer) context.getAttribute(ATTR_USUARIOS_CADASTRADOS);
        context.setAttribute(ATTR_USUARIOS_CADASTRADOS, (cadastros == null ? 1 : cadastros + 1));
        atualizarUltimaAcao(context);
    }

    /**
     * Incrementa o contador de usuários editados
     */
    public static void incrementarEdicoes(javax.servlet.ServletContext context) {
        Integer edicoes = (Integer) context.getAttribute(ATTR_USUARIOS_EDITADOS);
        context.setAttribute(ATTR_USUARIOS_EDITADOS, (edicoes == null ? 1 : edicoes + 1));
        atualizarUltimaAcao(context);
    }

    /**
     * Incrementa o contador de usuários removidos
     */
    public static void incrementarRemocoes(javax.servlet.ServletContext context) {
        Integer remocoes = (Integer) context.getAttribute(ATTR_USUARIOS_REMOVIDOS);
        context.setAttribute(ATTR_USUARIOS_REMOVIDOS, (remocoes == null ? 1 : remocoes + 1));
        atualizarUltimaAcao(context);
    }

    /**
     * Atualiza o timestamp da última ação
     */
    private static void atualizarUltimaAcao(javax.servlet.ServletContext context) {
        context.setAttribute(ATTR_ULTIMA_ACAO, LocalDateTime.now());
    }

    /**
     * Obtém o número de usuários cadastrados
     */
    public static int getUsuariosCadastrados(javax.servlet.ServletContext context) {
        Integer cadastros = (Integer) context.getAttribute(ATTR_USUARIOS_CADASTRADOS);
        return cadastros == null ? 0 : cadastros;
    }

    /**
     * Obtém o número de usuários editados
     */
    public static int getUsuariosEditados(javax.servlet.ServletContext context) {
        Integer edicoes = (Integer) context.getAttribute(ATTR_USUARIOS_EDITADOS);
        return edicoes == null ? 0 : edicoes;
    }

    /**
     * Obtém o número de usuários removidos
     */
    public static int getUsuariosRemovidos(javax.servlet.ServletContext context) {
        Integer remocoes = (Integer) context.getAttribute(ATTR_USUARIOS_REMOVIDOS);
        return remocoes == null ? 0 : remocoes;
    }

    /**
     * Obtém a data e hora da última ação
     */
    public static LocalDateTime getUltimaAcao(javax.servlet.ServletContext context) {
        return (LocalDateTime) context.getAttribute(ATTR_ULTIMA_ACAO);
    }
} 