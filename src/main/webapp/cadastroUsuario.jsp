<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2><s:if test="usuario.id == null">Novo Usuário</s:if><s:else>Editar Usuário</s:else></h2>
        
        <s:form action="salvarUsuario" method="post" cssClass="mt-4">
            <s:hidden name="usuario.id" />
            
            <div class="mb-3">
                <s:textfield name="usuario.nome" label="Nome" placeholder="Nome" cssClass="form-control" required="true" />
            </div>
            
            <div class="mb-3">
                <s:textfield name="usuario.email" label="Email" placeholder="Email" cssClass="form-control" required="true" />
            </div>
            
            <div class="mt-4">
                <s:submit value="Salvar" cssClass="btn btn-primary" />
                <s:a href="usuario" cssClass="btn btn-secondary">Voltar</s:a>
            </div>
        </s:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 