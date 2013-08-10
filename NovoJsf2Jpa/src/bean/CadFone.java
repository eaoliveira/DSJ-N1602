package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import modelo.Contato;
import modelo.Fone;
import dao.NovoGerente;

@ManagedBean(name = "fone")
@SessionScoped
public class CadFone {
	private String ddd;
	private String num;
	private Integer idContato;
	private List<SelectItem> contatos;
	@EJB
	private NovoGerente dao;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getIdContato() {
		if (idContato == null) {
			List<Contato> lista = dao.getContatos();
			if (lista.size() > 0) {
				Collections.sort(lista);
				Contato obj = lista.get(0);
				idContato = obj.getId();
			}
		}

		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public List<SelectItem> getContatos() {
		contatos = new ArrayList<SelectItem>();

		for (Contato obj : dao.getContatos()) {
			contatos.add(new SelectItem(obj.getId(), obj.getNome()));
		}

		return contatos;
	}

	public void setContatos(List<SelectItem> contatos) {
		this.contatos = contatos;
	}

	public int getQtdFones() {
		return dao.foneSize(idContato);
	}

	public String incluir() {
		Fone f = new Fone();
		f.setDdd(ddd);
		f.setNumero(num);
		dao.addFone(idContato, f);
		return "";
	}

	public void mudouContato(ValueChangeEvent ev) {
		System.out.println("Valor Novo:" + ev.getNewValue() + " Valor Antigo:"
				+ ev.getOldValue());
		idContato = Integer.parseInt(ev.getNewValue().toString());
	}

}
