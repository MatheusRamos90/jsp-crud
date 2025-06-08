$(document).ready(function() {
    $('#btnBuscarJogos').on('click', function() {
        const btn = $(this);
        btn.prop('disabled', true);
        btn.text('Buscando jogos...');
        
        $.ajax({
            url: contextPath + '/buscarJogosUsuario',
            type: 'POST',
            success: function(response) {
                btn.prop('disabled', false);
                btn.text('Buscar Jogos');
                
                if (response.success) {
                    alert(response.message);
                } else {
                    console.error('Erro ao buscar jogos:', response.message);
                    alert('Erro ao buscar jogos: ' + response.message);
                }
            },
            error: function(xhr, status, error) {
                btn.prop('disabled', false);
                btn.text('Buscar Jogos');
                
                console.error('Erro ao buscar jogos:', error);
                console.error('Status:', status);
                console.error('Response:', xhr.responseText);
                alert('Erro ao buscar jogos. Por favor, tente novamente.');
            }
        });
    });
}); 