

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
	var fname = document.form1.nome.value;
	var xhr = createXHR();
	xhr.open("GET", "srv/bean/all", true);
	xhr.setRequestHeader("Content-Type", "text/plain");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status != 404) {
				var xml = xhr.responseText;
				var tbody = "<h2>Registro</h2><form><table border='1'>" +
				"<tr><th>Del</th><th>ID</th><th>Nome</th><th>Id</th></tr>";
				$(xml).find("nome").each(function() {
					var id = $(this).find("id").text();
					var nome = $(this).find("Nome").text();
					var Descricao = $(this).find("Descricao").text();
					tbody += "<tr><td>" +
							"<input type='button' value='del' onclick='apaga("+id+")'/>" +
							"</td><td>" +
							+ id + "</td><td>" + nome + "</td><td>"
							+ Descricao + "</td></tr>";
				});
				tbody += "</table></form>";
				document.getElementById("zone").innerHTML = tbody;
			} else {
				document.getElementById("zone").innerHTML = fname
						+ " n&atilde;o encontrado";
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
				document.form1.id.value = "";
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
	var idade = document.form1.id.value;
	var nome = document.form1.nome.value;
	var reg =  
	  "<nome>" + 
	    "<id></id>" + 
	    "<Nome>" + nome + "</Nome>" + 
	   "</nome>";
	var xhr = createXHR();
	xhr.open("POST", "srv/bean/", true);
	xhr.setRequestHeader("Content-Type", "application/xml");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status != 404) {
				document.form1.id.value = "";
				document.form1.nome.value = "";

				todos();
			} else {
				document.getElementById("zone").innerHTML = "<h2>Erro</h2>";
			}
		}
	};
	xhr.send(reg);
}
