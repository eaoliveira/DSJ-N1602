package faces;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "bean")
@SessionScoped
public class Tela1Bean {
	private String nome;
	private int idade;
	private ListDataModel<Sujeito> dados = null;
	private List<Sujeito> lista = new ArrayList<Sujeito>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getQuantidade() {
		return lista.size();
	}
	
	public ListDataModel<Sujeito> getDados() {
		dados =  new ListDataModel<Sujeito>(lista);
		return dados;
	}

	@SuppressWarnings("unchecked")
	public String del(){
		List<Sujeito> nova = new ArrayList<Sujeito>();
		
	    for(Sujeito s : (List<Sujeito>)dados.getWrappedData()) {
	        if(!s.isDel())
	        	nova.add(s);
	    }
	    lista = nova;
	    
		return "";
	}
	
	public String enviar() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage();

		if (nome.isEmpty() || idade == 0) {
			msg.setSummary("Dados Invalidos!");
		} else {
			lista.add(new Sujeito(nome, idade));
			msg.setSummary("Sujeito Cadastrado!");
			nome = "";
			idade = 0;
		}
		ctx.addMessage(null, msg);

		return "";
	}
}
