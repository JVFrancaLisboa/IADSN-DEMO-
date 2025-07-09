function gerarPDF() {
    const elemento = document.getElementById('conteudo');
    const options = {
        margin: 1,
        filename: 'contrato.pdf',
        image: { type: 'jpeg', quality: 0.98 },
        html2canvas: { scale: 2 },
        jsPDF: { unit: 'in', format: 'a4', orientation: 'portrait' }
    };

    html2pdf().from(elemento).set(options).save();
}

function atualizarTexto(event) {
    const elemento = event.target;
    
    if (elemento.id === 'locatario') {
        document.getElementById('lacatarioDisplay').innerHTML = 'Locatário (a) (s): <strong>' + elemento.value + '</strong>';
        document.getElementById('locatarioDisplay0').innerHTML = '<strong>'+elemento.value+'</strong>';
        document.getElementById('locatarioAss').innerHTML = elemento.value;
    }else if(elemento.id === 'valor'){
        document.getElementById('valorDisplay').innerHTML = 'Valor do aluguel: <strong>'+elemento.value+'</strong>';
        document.getElementById('valorDisplay02').innerHTML = elemento.value;
    }else if(elemento.id == 'vigencia'){
        document.getElementById('vigenciaDisplay').innerHTML = 'Vigência: <strong>'+elemento.value+'</strong>';
    }else if (elemento.id == 'entrada' || elemento.id == 'saida') {
        const inputData = elemento.value;
        const [ano, mes, dia] = inputData.split('-');
        const dataFormatada = `${dia}/${mes}/${ano}`; 

        if (elemento.id == 'entrada') {
            document.getElementById('dataEntradaDisplay').innerHTML = dataFormatada;
        }else if(elemento.id == 'saida'){
            document.getElementById('dataSaidaDisplay').innerHTML = dataFormatada;
        }
    }else if(elemento.id == 'ssp-escolha'){
        const lista = ['SSP/AC', 'SSP/AL', 'SSP/AP', 'SSP/AM', 'SSP/BA', 'SSP/CE', 'SSP/DF', 'SSP/ES', 'SSP/GO', 'SSP/MA', 'SSP/MT', 'SSP/MS', 'SSP/MG', 'SSP/PA', 'SSP/PB', 'SSP/PR', 'SSP/PE', 'SSP/PI', 'SSP/RJ', 'SSP/RN', 'SSP/RS', 'SSP/RO', 'SSP/RR', 'SSP/SC', 'SSP/SP', 'SSP/SE', 'SSP/TO'];
        let ssp = '';
        lista.forEach(f => {
            if(f == elemento.value){
                ssp = f;
            }
        });
        document.getElementById('sspDisplay').innerHTML = ssp;
    }else if(elemento.id == 'rg'){
        document.getElementById('rgDisplay').innerHTML = elemento.value;
    }else if(elemento.id == 'cpf'){
        document.getElementById('cpfDisplay').innerHTML = elemento.value;
    }else if(elemento.id == 'dataHoje'){
        const inputData = elemento.value;
        const [ano, mes, dia] = inputData.split('-');
        const dataFormatada = `${dia}/${mes}/${ano}`; 

        document.getElementById('dataHojeDisplay').innerHTML = dataFormatada;
    }else if(elemento.id == 'endereco'){
        document.getElementById('enderecoDisplay').innerHTML = 'Endereço do imóvel do aluguel: <strong>'+elemento.value+'</strong></p>';
    }
}

document.getElementById('locatario').addEventListener('input', atualizarTexto);
document.getElementById('valor').addEventListener('input', atualizarTexto);
document.getElementById('vigencia').addEventListener('input', atualizarTexto);
document.getElementById('entrada').addEventListener('input', atualizarTexto);
document.getElementById('saida').addEventListener('input', atualizarTexto);
document.getElementById('ssp-escolha').addEventListener('input', atualizarTexto);
document.getElementById('rg').addEventListener('input', atualizarTexto);
document.getElementById('cpf').addEventListener('input', atualizarTexto);
document.getElementById('dataHoje').addEventListener('input', atualizarTexto);
document.getElementById('endereco').addEventListener('input', atualizarTexto);