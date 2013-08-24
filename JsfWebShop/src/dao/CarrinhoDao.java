package dao;

import java.util.List;

import javax.ejb.Local;

import modelo.Item;

@Local
public interface CarrinhoDao {
	public void adicionaItem(String sessao, Item prod);
	public void removeItem(String codigo);
	public Item localizaItem(String codigo);
	public List<Item> getLista();
	public int getQtdItens();
	public double getTotal();
}
