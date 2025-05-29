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
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Lista de Usuários</h2>
            <div>
                <button onclick="gerarRelatorioPDF()" class="btn btn-info me-2 text-white">Gerar Relatório PDF</button>
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
        function gerarRelatorioPDF() {
            $.ajax({
                url: '${pageContext.request.contextPath}/gerarRelatorioPDF',
                type: 'GET',
                success: function(response) {
                    if (response.error) {
                        console.error('Erro ao gerar PDF:', response.error);
                        alert('Erro ao gerar o relatório PDF. Por favor, tente novamente.');
                        return;
                    }
                    
                    // Converte o Base64 para Blob
                    const byteCharacters = atob(response.pdfBase64);
                    const byteNumbers = new Array(byteCharacters.length);
                    for (let i = 0; i < byteCharacters.length; i++) {
                        byteNumbers[i] = byteCharacters.charCodeAt(i);
                    }
                    const byteArray = new Uint8Array(byteNumbers);
                    const blob = new Blob([byteArray], { type: 'application/pdf' });
                    
                    // Cria um link para download
                    const link = document.createElement('a');
                    link.href = window.URL.createObjectURL(blob);
                    link.download = response.fileName;
                    
                    // Simula o clique no link
                    document.body.appendChild(link);
                    link.click();
                    document.body.removeChild(link);
                },
                error: function(xhr, status, error) {
                    console.error('Erro ao gerar PDF:', error);
                    console.error('Status:', status);
                    console.error('Response:', xhr.responseText);
                    alert('Erro ao gerar o relatório PDF. Por favor, tente novamente.');
                }
            });
        }
    </script>
</body>
</html> 