function removerElemento(element) {
    var opcao = window.confirm("Tem certeza que deseja remover o elemento?");

    if(opcao===true) {
        removerElementoAJAX(element);
    } else {
        alert("Elemento não removido");
    }
}

function removerElementoAJAX(idUser) {

    var httpRequest;
    if (window.XMLHttpRequest) { // Mozilla, Safari, ...
        req = new XMLHttpRequest();
        req.onreadystatechange = function() {
            //condição para o estágio 4 da requisição e status 204 (resposta da API)
            if(this.readyState == 4 && this.status == 204) {
                var e = document.getElementById(idUser);
                e.remove(); //remove elemento do HTML
            }
        };

        //Cria a requisição e envia informações JSON
        req.open("POST", "http://localhost:9090/api/usuario/delete",true);
        req.setRequestHeader("Content-Type", "application/json");
        req.send(JSON.stringify(
            { "id": idUser }
        ));
    }
}