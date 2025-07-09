$(document).ready(function () {
    // Adiciona o evento de clique para o link "Membros"
    $(".navegacao").click(function (event) {
        event.preventDefault(); // Impede o comportamento padrão do link
        const url = $(this).data("url"); // Obtém a URL do atributo data-url

        // Carrega o conteúdo via AJAX
        $.ajax({
            url: url,
            type: "GET",
            beforeSend: function () {
                // Exibe uma mensagem de carregamento
                $("#dynamic-content").html("<div class='text-center'><p>Carregando...</p></div>");
            },
            success: function (response) {
                // Insere o conteúdo carregado na div
                $("#dynamic-content").html(response);
            },
            error: function () {
                // Exibe uma mensagem de erro em caso de falha
                $("#dynamic-content").html("<div class='text-center text-danger'><p>Erro ao carregar o conteúdo.</p></div>");
            }
        });
    });
});
