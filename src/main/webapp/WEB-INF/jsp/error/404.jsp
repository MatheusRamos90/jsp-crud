<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6 text-center">
            <div class="card">
                <div class="card-body">
                    <h1 class="display-1 text-danger">404</h1>
                    <h2 class="mb-4">Página não encontrada</h2>
                    <p class="lead mb-4">A página que você está procurando não existe ou foi movida.</p>
                    <a href="<s:url action='listarUsuarios'/>" class="btn btn-primary">
                        <i class="fas fa-home"></i> Voltar para a página inicial
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html> 