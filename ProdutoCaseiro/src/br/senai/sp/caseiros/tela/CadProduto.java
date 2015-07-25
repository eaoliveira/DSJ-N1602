package br.senai.sp.caseiros.tela;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.caseiros.control.GerenteDeDados;
import br.senai.sp.caseiros.modelo.Mensagem;
import br.senai.sp.caseiros.modelo.Produto;

@WebServlet("/cadProduto")
public class CadProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		String preco = request.getParameter("preco");
		String validade = request.getParameter("validade");

		Mensagem msg = new Mensagem();

		if (nome.isEmpty() || desc.isEmpty() || preco.isEmpty()
				|| validade.isEmpty()) {
			msg.setTexto("Existem campos não informados");
			msg.setTitulo("Erro == Cad Produto");
			msg.setUrl("index.html");
		} else {
			DateFormat fmt = DateFormat.getDateInstance();
			NumberFormat nfmt = NumberFormat.getNumberInstance();
			String erro = "";

			try {
				Produto obj = new Produto();
				obj.setNome(nome);
				obj.setDesc(desc);
				erro = "Valor inválido";
				obj.setPreco(nfmt.parse(preco).doubleValue());
				erro = "Data inválida";
				obj.setValidade(fmt.parse(validade));

				GerenteDeDados.getInstance().salvar(obj);

				msg.setTexto("Sucesso no cadastro do produto");
				msg.setTitulo("== Cad Produto ==");
				msg.setUrl("index.html");
			} catch (ParseException ex) {
				msg.setTexto(erro);
				msg.setTitulo("Erro == Cad Produto");
				msg.setUrl("index.html");
			}

		}
		request.getSession().setAttribute("msg", msg);

		response.sendRedirect("resultPage.jsp");
	}
}
