    function limparCamposFormulario() {
        var inputs = document.getElementsByTagName("input");
        inputs[0].value = "";
        inputs[1].value = "";
        document.getElementsByTagName("textarea")[0].value = "";
    }
    function removerLinhaTransacao(idTransacao) {
        var opcao = window.confirm("Tem certeza que deseja remover o elemento?");
        (opcao===true) ? removerTransacao(idTransacao) : alert("Elemento não removido");
    }

    function removerTransacao(id) {
        var URL = "http://localhost:9090/api/transacao/remover";
        fetch(URL, {
            method: 'DELETE',
            headers: { 'Content-Type':'application/json' },
            body: JSON.stringify({'id': id })
        })
        .then((response) => {
            if(response.ok && response.status == 200) {
                //remove linha do elemento removido
                document.getElementById(id).remove();
            }
        })
    }

    function formAlteratransacao(id) {
        //separando valores
        var informacoesDaTransacao = document.getElementById(id).getElementsByTagName("td");
        var valor = informacoesDaTransacao[0].innerText;
        var descricao = informacoesDaTransacao[1].innerText;
        var tipo = informacoesDaTransacao[2].getAttribute("value");
        var date = informacoesDaTransacao[3].innerText;

        //adicionando valores no formulário para edição
        document.getElementsByName("form-atualiza-transacao")[0].getElementsByTagName("input")[0].value = valor;
        document.getElementsByName("form-atualiza-transacao")[0].getElementsByTagName("textarea")[0].value = descricao;
        document.getElementsByName("form-atualiza-transacao")[0].getElementsByTagName("input")[1].value = date;

        //Tratando a tag select
        var slct = document.getElementById("optionsTipoTransacao");
        var opts = slct.getElementsByTagName("option");
        for(element of opts) {
            if(element.value == tipo) {
                element.selected = true;
                break;
            }
        };
    }

    function alteraTransacao(id) {  
        //separando valores
        var informacoesDaTransacao = document.getElementById(id).getElementsByTagName("td");
        var valor = informacoesDaTransacao[0].innerText;
        var descricao = informacoesDaTransacao[1].innerText;
        var tipo = informacoesDaTransacao[2].getAttribute("value");
        var date = dateConvertFormat(informacoesDaTransacao[3].innerText);

        var transacaoAtualizada = {
            "valorTransacao": valor,
            "descricaoTransacao": descricao,
            "dataTransacao": date,
            "tipo": tipo
        }

        var URL = "http://localhost:9090/api/transacao/" + id;

        fetch(URL, {
            method: 'PUT',
            headers: { 'Content-Type':'application/json' },
            body: JSON.stringify(transacaoAtualizada)
        })
        .then(response => console.log(response));

        console.log(transacaoAtualizada);
    }

    //prepara a data para o padrão utilizado na api
    function dateConvertFormat(date) {
        var day = date.substring(0,2);
        var month = date.substring(3,5);
        var year = date.substring(6);
        date = year + "-" + month + "-" + day;
        return date;
    }