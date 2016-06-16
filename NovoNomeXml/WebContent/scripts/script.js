// JavaScript de Interface entre o HTML e o RESTFull WebService

function createXHR() {
	var request = false;
	try {
		request = new ActiveXObject('Msxml2.XMLHTTP');
	} catch (err2) {
		try {
			request = new ActiveXObject('Microsoft.XMLHTTP');
		} catch (err3) {
			try {
				request = new XMLHttpRequest();
			} catch (err1) {
				request = false;
			}
		}
	}
	return request;
}

function todos() {
	var xhr = createXHR();
	xhr.open("GET", "srv/bean/all", true);
	xhr.setRequestHeader("Content-Type", "text/plain");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status != 404) {
				var xml = xhr.responseText;
				var tbody = "<h2>Registro</h2>" +
				"<form><div class='Tabela'>" +
				  "<div class='Cabecalho'>" +
				    "<span class='Celula'>Del</span>" +
				    "<span class='Celula'>ID</span>" +
				    "<span class='Celula'>Nome</span>" +
				    "<span class='Celula'>Idade</span>" +
				  "</div>";
				$(xml).find("nome").each(function() {
					var id = $(this).find("id").text();
					var nome = $(this).find("primeiroNome").text();
					var idade = $(this).find("idade").text();
					tbody += "<div class='Linha'>" +
							   "<div class='Celula'><input type='button' value='del' onclick='apaga("+id+")'/></div>" +
							   "<div class='Celula'>" + id + "</div>" +
							   "<div class='Celula'>" + nome + "</div>" +
							   "<div class='Celula'>" + idade + "</div>" +
							"</div>";
				});
				tbody += "</div></form>";
				document.getElementById("zone").innerHTML = tbody;
			} else {
				document.getElementById("zone").innerHTML = "<h2>Erro ao acessar o servidor</h2>";
			}
		}
	};
	xhr.send(null);
}

function apaga(chave) {
	var xhr = createXHR();
	xhr.open("DELETE", "srv/bean/" + chave, true);
	xhr.setRequestHeader("Content-Type", "text/plain");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status != 404) {
				document.form1.idade.value = "";
				document.form1.nome.value = "";

				todos();
			} else {
				document.getElementById("zone").innerHTML = fname
						+ " n&atilde;o encontrado";
			}
		}
	};
	xhr.send(null); 
}

function salva() {
	var idade = document.form1.idade.value;
	var nome = document.form1.nome.value;
	var reg =  
	  "<nome>" + 
	    "<id></id>" + 
	    "<idade>" + idade + "</idade>" + 
	    "<primeiroNome>" + nome + "</primeiroNome>" + 
	   "</nome>";
	var xhr = createXHR();
	xhr.open("POST", "srv/bean/", true);
	xhr.setRequestHeader("Content-Type", "application/xml");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status != 404) {
				document.form1.idade.value = "";
				document.form1.nome.value = "";

				todos();
			} else {
				document.getElementById("zone").innerHTML = "<h2>Erro</h2>";
			}
		}
	};
	xhr.send(reg);
}
