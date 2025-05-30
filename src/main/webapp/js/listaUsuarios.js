function gerarRelatorioPDF() {
    $.ajax({
        url: contextPath + '/gerarRelatorioPDF',
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