package Anotacao.resposta;

@AFazer(data="22/05/2015", descricao="Implementar get e set")
@SuppressWarnings("unused")
public class Item {
	@AFazer(data="12/04/2014", descricao="alterar de int para Integer")
	private int codigo;
	private String descricao;
	private double preco;
	
	@AFazer(data="02/04/2014", descricao="inicializar os atributos")
	public Item() {
	}
	
	@AFazer(data="14/05/2015", descricao="calcular a média das vendas")
	public double getSaldo() {
		return 0;
	}
}
