$(document).ready(function () {

  $("#form-dizimo").submit(function (event) {
    event.preventDefault();
    // Limpar mensagens de erro anteriores
    $(".error-data-dizimo").html("").hide();
    $(".error-valor-dizimo").html("").hide();

    // Verificar se os campos foram preenchidos
    const dataDizimo = $("#data-dizimo").val();
    const valorDizimo = $("#valor-dizimo").val();
    const pessoaDizimista = $("#pessoa-dizimista").val();

    //dizimos
    if (!dataDizimo) {
      $(".error-data-dizimo").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!valorDizimo) {
      $(".error-valor-dizimo").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (pessoaDizimista === "selecionar") {
      $(".error-pessoa-dizimista").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    // Se passar pelas validações, permitir o envio do formulário
    $(this).unbind("submit").submit();
  });

  $("#form-oferta").submit(function (event) {
    event.preventDefault();
    // Limpar mensagens de erro anteriores
    $(".error-data-oferta").html("").hide();
    $(".error-valor-oferta").html("").hide();

    // Verificar se os campos foram preenchidos
    const dataOferta = $("#data-oferta").val();
    const valorOferta = $("#valor-oferta").val();

    if (!dataOferta) {
      $(".error-data-oferta").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!valorOferta) {
      $(".error-valor-oferta").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    // Se passar pelas validações, permitir o envio do formulário
    $(this).unbind("submit").submit();
  });

  $("#form-gasto").submit(function (event) {
    event.preventDefault();
    // Limpar mensagens de erro anteriores
    $(".error-doc-gasto").html("").hide();
    $(".error-data-gasto").html("").hide();
    $(".error-valor-gasto").html("").hide();

    // Verificar se os campos foram preenchidos
    const docGasto = $("#doc-gasto").val();
    const dataGasto = $("#data-gasto").val();
    const valorGasto = $("#valor-gasto").val();

    if (!docGasto) {
      $(".error-doc-gasto").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!dataGasto) {
      $(".error-data-gasto").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!valorGasto) {
      $(".error-valor-gasto").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    // Se passar pelas validações, permitir o envio do formulário
    $(this).unbind("submit").submit();
  });

  $("#form-membro").submit(function (event) {
    event.preventDefault();

    // Limpar mensagens de erro anteriores  
    $(".error-foto-membro").html("").hide();
    $(".error-nome-membro").html("").hide();    
    $(".error-data-membro").html("").hide();
    $(".error-cpf-membro").html("").hide();
    $(".error-sexo-membro").html("").hide();
    $(".error-status-membro").html("").hide();
    $(".error-cargo-membro").html("").hide();
    $(".error-endereco-membro").html("").hide();
    $(".error-telefone-membro").html("").hide();

    const fotoMembro = $("#foto-membro").val();
    const imagemAtual = $("#selectedImage").attr("src"); // Obtém o src da imagem atual
    const nomeMembro = $("#nome-membro").val();
    const dataMembro = $("#data-membro").val();
    const cpfMembro = $("#cpf-membro").val();
    const sexoMembro = $("#sexo-membro").val();
    const statusMembro = $("#status-membro").val();
    const cargoMembro = $("#cargo-membro").val();
    const enderecoMembro = $("#endereco-membro").val();
    const telefoneMembro = $("#telefone-membro").val();

    // Verifica se o campo de upload está vazio e se a imagem atual é a padrão
    if (!fotoMembro && imagemAtual.includes("placeholder.jpg")) {
        $(".error-foto-membro").html("*Campo obrigatório").show();
        return; // Impede o envio do formulário
    }

    if (!nomeMembro) {
      $(".error-nome-membro").html("*Campo obrigatório").show();
      return;
    }

    if (!dataMembro) {
      $(".error-data-membro").html("*Campo obrigatório").show();
      return;
    }

    if (!cpfMembro) {
      $(".error-cpf-membro").html("*Campo obrigatório").show();
      return;
    }

    if (sexoMembro === "selecionar") {
      $(".error-sexo-membro").html("*Campo obrigatório").show();
      return;
    }

    if (statusMembro === "selecionar") {
      $(".error-status-membro").html("*Campo obrigatório").show();
      return;
    }

    if (cargoMembro === "selecionar") {
      $(".error-cargo-membro").html("*Campo obrigatório").show();
      return;
    }

    if (!enderecoMembro) {
      $(".error-endereco-membro").html("*Campo obrigatório").show();
      return;
    }

    if (!telefoneMembro) {
      $(".error-telefone-membro").html("*Campo obrigatório").show();
      return;
    }

    // Se passar pelas validações, permitir o envio do formulário
    $(this).unbind("submit").submit();
  });

  $("#form-membrodto").submit(function (event) {
    event.preventDefault();

    // Limpar mensagens de erro anteriores  
    $(".error-pessoa-membro").html("").hide();
    $(".error-aguas-membro").html("").hide();
    $(".error-rg-membro").html("").hide();
    $(".error-espirito-membro").html("").hide();
    $(".error-nacionalidade-membro").html("").hide();
    $(".error-naturalidade-membro").html("").hide();
    $(".error-campo-membro").html("").hide();

    const selecaoPessoa = $("#pessoa-membro").val();
    const batismoAguas = $("#batismo-aguas").val();
    const rgMembro = $("#rg-membro").val();
    const batismoEspirito = $("#batismo-espirito").val();
    const nacionalidade = $("#nacionalidade-membro").val();
    const naturalidade = $("#naturalidade-membro").val();
    const campo = $("#campo-membro").val();

    if (selecaoPessoa === "selecionar") {
      $(".error-pessoa-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!batismoAguas) {
      $(".error-aguas-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (rgMembro == 0 || rgMembro == "" || rgMembro == null) {
      $(".error-rg-membro").html("*obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!batismoEspirito) {
      $(".error-espirito-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!nacionalidade) {
      $(".error-nacionalidade-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!naturalidade) {
      $(".error-naturalidade-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!campo) {
      $(".error-campo-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    $(this).unbind("submit").submit(); // Se passar pelas validações, permitir o envio do formulário
  });

  $("#form-ministrodto").submit(function (event) {
    event.preventDefault();

    // Limpar mensagens de erro anteriores  
    $(".error-pessoa-membro").html("").hide();
    $(".error-aguas-membro").html("").hide();
    $(".error-rg-membro").html("").hide();
    $(".error-espirito-membro").html("").hide();
    $(".error-nacionalidade-membro").html("").hide();
    $(".error-naturalidade-membro").html("").hide();
    $(".error-ordenacao-membro").html("").hide();
    $(".error-sede-membro").html("").hide();

    const selecaoPessoa = $("#pessoa-membro").val();
    const batismoAguas = $("#batismo-aguas").val();
    const rgMembro = $("#rg-membro").val();
    const batismoEspirito = $("#batismo-espirito").val();
    const nacionalidade = $("#nacionalidade-membro").val();
    const naturalidade = $("#naturalidade-membro").val();
    const ordenacao = $("#ordenacao-membro").val();
    const sede = $("#sede-membro").val();

    if (selecaoPessoa === "selecionar") {
      $(".error-pessoa-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!batismoAguas) {
      $(".error-aguas-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (rgMembro == 0 || rgMembro == "" || rgMembro == null) {
      $(".error-rg-membro").html("*obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!batismoEspirito) {
      $(".error-espirito-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!nacionalidade) {
      $(".error-nacionalidade-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!naturalidade) {
      $(".error-naturalidade-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!ordenacao) {
      $(".error-ordenacao-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!sede) {
      $(".error-sede-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    $(this).unbind("submit").submit(); // Se passar pelas validações, permitir o envio do formulário
  });

  $("#form-missionariodto").submit(function (event) {
    event.preventDefault();

    // Limpar mensagens de erro anteriores  
    $(".error-pessoa-membro").html("").hide();
    $(".error-aguas-membro").html("").hide();
    $(".error-rg-membro").html("").hide();
    $(".error-espirito-membro").html("").hide();
    $(".error-nacionalidade-membro").html("").hide();
    $(".error-naturalidade-membro").html("").hide();
    $(".error-sede-membro").html("").hide();

    const selecaoPessoa = $("#pessoa-membro").val();
    const batismoAguas = $("#batismo-aguas").val();
    const rgMembro = $("#rg-membro").val();
    const batismoEspirito = $("#batismo-espirito").val();
    const nacionalidade = $("#nacionalidade-membro").val();
    const naturalidade = $("#naturalidade-membro").val();
    const sede = $("#sede-membro").val();

    if (selecaoPessoa === "selecionar") {
      $(".error-pessoa-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!batismoAguas) {
      $(".error-aguas-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (rgMembro == 0 || rgMembro == "" || rgMembro == null) {
      $(".error-rg-membro").html("*obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!batismoEspirito) {
      $(".error-espirito-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!nacionalidade) {
      $(".error-nacionalidade-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!naturalidade) {
      $(".error-naturalidade-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    if (!sede) {
      $(".error-sede-membro").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
      return; // Impede o envio do formulário
    }

    $(this).unbind("submit").submit(); // Se passar pelas validações, permitir o envio do formulário
  });

});
