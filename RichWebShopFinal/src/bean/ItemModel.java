package bean;

import modelo.Item;

public class ItemModel {
	private CarrinhoBean bean;
	private Item item;
	private int quantidade;

	public ItemModel(Item item, CarrinhoBean bean) {
		this.item = item;
		this.bean = bean;
	}

	public String getDescricao() {
		return item.getDescricao();
	}

	public String getImagem() {
		return item.getImagem();
	}

	public int getQuantidade() {
		return item.getQuantidade();
	}

	public void setQuantidade(int qtd) {
		quantidade = qtd;
	}
	
	public double getTotal() {
		return item.getTotal();
	}

	public void remove() {
		bean.removeItem(item.getCodigo());
	}

	public void altera() {
		Item it = new Item();
		it.setCodigo(item.getCodigo());
		it.setQuantidade(quantidade);
		bean.alteraQtd(it);
	}
}
