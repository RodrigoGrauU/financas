var btn = document.getElementById("btnSalvar");
function limparCamposFormulario() {
    var inputs = document.getElementsByTagName("input");
    inputs[0].value = "";
    inputs[1].value = "";
    document.getElementsByTagName("textarea")[0].value = "";
}
function exibeMensagem() {
    var elementMsg = document.getElementById("alert-msg");
    var msgAlert = "Transação adicionada com sucesso!";
    elementMsg.innerHTML="<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">" + msgAlert + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>";

}

var salvarDespesa = function() {
    var inputs = document.getElementsByTagName("input");
    var valor = inputs[0].value;
    valor = valor.replace(",",".");
    var date = inputs[1].value; //vem yyyy-MM-dd
    var descricao = document.getElementsByTagName("textarea")[0].value;


    var option = document.getElementById('optionsTipoTransacao');
    var index = option.selectedIndex;
    console.log("index:" + index);
    console.log(option.options[index].value);

    var tipoTransacao = document.getElementById('optionsTipoTransacao').options[index].value;

    //Capturando Id da Conta
    var indexOptionConta = document.getElementById("optionsContas").selectedIndex;
    var idConta = document.getElementById("optionsContas").options[indexOptionConta].value;

    var transacao = {
        "idConta": idConta,
        "valorTransacao": valor,
        "descricaoTransacao": descricao,
        "dataTransacao": date,
        "tipo": tipoTransacao
    };

    var URL = window.location.origin + "/api/transacao/adicionar";
    fetch(URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(transacao)
    })
    .then(function(response) {
        if (response.ok && response.status == 201) {
            limparCamposFormulario();
            exibeMensagem();
            return response.json();
        }
    })
    .then(json => console.log(json))
    .catch(error => console.error('Error: ',error));
}

btn.addEventListener("click", salvarDespesa);

//Mascara para data
var inputData = document.getElementsByName("data")[0];
/*inputData.addEventListener("keyup", mascaraData);
function mascaraData() {
    var data = inputData.value;
    if(data.length == 2) {
        data = data + '/';
        inputData.value = data;
        return true;
    }

    if(data.length == 5) {
        data = data + '/';
        inputData.value = data;
        return true;
    }
}*/

//mascara para valor do dinheiro
/*var inputMoney = document.getElementsByName("valor")[0];
inputMoney.addEventListener('keyup', moneyMask);

function moneyMask() {
    var money = inputMoney.value;

    //substitui o ponto por vírgula
    if(money.indexOf(".") != -1) {
        inputMoney.value = money.replace(".", ",");
    }
}*/

//tratamento para deixar apenas a primeira letra em uppercase
var tipoTransacao = document.getElementById('optionsTipoTransacao');
function firstLetterUpperCase() {
    var tipoTransacao = document.getElementById('optionsTipoTransacao');
    var i = 0;
    for(i = 0; i < tipoTransacao.length; i++) {
      tipoTransacao.options[i].text = tipoTransacao.options[i].text.charAt(0) + tipoTransacao.options[i].text.substring(1).toLowerCase();
    }
}

firstLetterUpperCase();