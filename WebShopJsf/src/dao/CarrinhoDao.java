package dao;

import java.util.List;

import javax.ejb.Local;

import modelo.Compra;
import modelo.Item;

@Local
public interface CarrinhoDao extends TimerInterface {
		public void adicionaItem(String sessao, Item prod);
		public void removeItem(String sessao, String codigo) throws ShopException;
		public Item localizaItem(String sessao, String codigo);
		public List<Item> getLista(String sessao);
		public int getQtdItens();
		public double getTotal(String sessao);
		public void finalizaCompra(String id, Compra obj) throws ShopException;
}
