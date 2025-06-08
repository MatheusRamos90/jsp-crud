<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <input type="hidden" id="idUsuario" value="${id}" />
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Lista de Usuários</h2>
            <div>
                <button onclick="gerarRelatorioPDF()" class="btn btn-info me-2 text-white">Gerar Relatório PDF</button>
                <button id="btnBuscarJogos" class="btn btn-success me-2">Buscar Jogos</button>
                <s:a href="novoUsuario" cssClass="btn btn-primary">Novo Usuário</s:a>
            </div>
        </div>
        
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="usuarios">
                        <tr>
                            <td><s:property value="nome" /></td>
                            <td><s:property value="email" /></td>
                            <td>
                                <input type="hidden" name="id" value="<s:property value='id'/>" />
                                <s:a href="editarUsuario?id=%{id}" cssClass="btn btn-sm btn-warning">Editar</s:a>
                                <s:a href="excluirUsuario?id=%{id}" cssClass="btn btn-sm btn-danger"
                                     onclick="return confirm('Tem certeza que deseja excluir este usuário?')">Excluir</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Define o contexto da aplicação para uso no JavaScript
        const contextPath = '${pageContext.request.contextPath}';
    </script>
    <script src="${pageContext.request.contextPath}/js/listaUsuarios.js"></script>
    <script src="${pageContext.request.contextPath}/js/jogos.js"></script>
</body>
</html> 