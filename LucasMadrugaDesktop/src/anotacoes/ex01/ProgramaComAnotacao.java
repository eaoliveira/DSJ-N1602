package anotacoes.ex01;

public class ProgramaComAnotacao {
	

	private Integer codCliente;
	private String cliente;
	
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "codCliente " + codCliente + ": cliente " + cliente;
	}

	
	@AFazer(data = "20/05/2015", descricao = "Responsável: Flávio")
	public void cadastrarCliente(Integer cod,String Cliente){
		
	}
	
	
	
	
}
