<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Lista de Usuários</h2>
            <s:a href="usuario-novo" cssClass="btn btn-primary">Novo Usuário</s:a>
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
                                <s:a href="usuario-editar?id=%{id}" cssClass="btn btn-sm btn-warning">Editar</s:a>
                                <s:a href="usuario-excluir?id=%{id}" cssClass="btn btn-sm btn-danger" 
                                     onclick="return confirm('Tem certeza que deseja excluir este usuário?')">Excluir</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 