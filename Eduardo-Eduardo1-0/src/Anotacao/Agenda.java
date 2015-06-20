package Anotacao;

@AFazer(data = "16/05/2015",
decricao = "Churrasco")
public class Agenda {

	String data;
	
	String descricao;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
