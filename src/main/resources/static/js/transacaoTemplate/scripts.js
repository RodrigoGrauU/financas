    //declaracao de variáveis
    //Botão que salva as alterações realizadas na transação
    var btnSalvarAlteracao = document.getElementById("btnSalvarAlteracao");
    btnSalvarAlteracao.idTransacao = null;
    btnSalvarAlteracao.addEventListener('click', alteraTransacao);

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
        var URL = window.location.origin + "/api/transacao/remover";
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
        btnSalvarAlteracao.idTransacao = id;

        //separando valores
        var informacoesDaTransacao = document.getElementById(id).getElementsByTagName("td");
        var valor = informacoesDaTransacao[0].innerText;
        var descricao = informacoesDaTransacao[1].innerText;
        var tipo = informacoesDaTransacao[2].getAttribute("value");
        var date = informacoesDaTransacao[3].innerText;

        //adicionando valores no formulário para edição
        document.getElementsByName("form-atualiza-transacao")[0].getElementsByTagName("input")[0].value = valor;
        document.getElementsByName("form-atualiza-transacao")[0].getElementsByTagName("textarea")[0].value = descricao;
        document.getElementsByName("form-atualiza-transacao")[0].getElementsByTagName("input")[1].value = dateConvertFormat(date);

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

    function alteraTransacao(evt) {
        //pegando o id da transação a partir do currenteTarget
        var id = evt.currentTarget.idTransacao;

        //separando valores
        var formularioAtualizacao = document.getElementsByName("form-atualiza-transacao")[0];
        var valor = formularioAtualizacao.getElementsByTagName("input")[0].value;
        var descricao = formularioAtualizacao.getElementsByTagName("textarea")[0].value;

        //tratando o select
        var slct = formularioAtualizacao.getElementsByTagName("select")[0];
        var tipo = slct.selectedOptions[0].value;

        //data já vem convertida do frontend
        //var date = dateConvertFormat(formularioAtualizacao.getElementsByTagName("input")[1].value);
        var date = formularioAtualizacao.getElementsByTagName("input")[1].value;

        var transacaoAtualizada = {
            "valorTransacao": valor,
            "descricaoTransacao": descricao,
            "dataTransacao": date,
            "tipo": tipo
        }

        var URL = window.location.origin + "/api/transacao/" + id;
        fetch(URL, {
            method: 'PUT',
            headers: { 'Content-Type':'application/json' },
            body: JSON.stringify(transacaoAtualizada)
        })
        .then(response => {
            atualizaValoresEmTela(id, transacaoAtualizada);
        });

        //fechar label
        window.location = "#listaTransacoes";
    }

    //prepara a data para o padrão utilizado na api
    function dateConvertFormat(date) {
        var day = date.substring(0,2);
        var month = date.substring(3,5);
        var year = date.substring(6);
        date = year + "-" + month + "-" + day;
        return date;
    }


    //função para identificar fechamento de label
    document.getElementsByClassName("btn-close")[0].addEventListener('click', () => {
        btnSalvarAlteracao.idTransacao = null;
    } );

    //realizar consulta
    function atualizaValoresEmTela(id, jsonObject) {
        //separando valores
        var informacoesDaTransacao = document.getElementById(id).getElementsByTagName("td");
        informacoesDaTransacao[0].innerText = jsonObject.valorTransacao;
        informacoesDaTransacao[1].innerText = jsonObject.descricaoTransacao;
        
        switch(jsonObject.tipo) {
            case '1':
            informacoesDaTransacao[2].innerText = 'Despesa';
            informacoesDaTransacao[2].setAttribute("value",1);
            break;
            
            case '2':
            informacoesDaTransacao[2].innerText = 'Receita';
            informacoesDaTransacao[2].setAttribute("value",2);
            break;
        } 
        
        informacoesDaTransacao[3].innerText = dateConvertToBRFormat(jsonObject.dataTransacao);
    }

    //converte de yyyy-MM-dd para dd-MM-yyyy
    function dateConvertToBRFormat(date) {
        var year = date.substring(0,4);
        var month = date.substring(5,7);
        var day = date.substring(8);
        date = day + "/" + month + "/" + year;
        return date;
    }