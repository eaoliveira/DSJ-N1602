package bean;

import java.util.List;

import modelo.Empresa;

public class Empresas {
	private List<Empresa> itens;
	
	public Empresas(List<Empresa> obj) {
		itens = obj;
	}
	
	public List<Empresa> getItens() {
		return itens;
	}
	
	public int getCount() {
		return itens.size();
	}
}
