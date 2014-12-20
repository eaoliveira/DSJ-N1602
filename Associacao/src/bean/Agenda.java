package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import modelo.Horario;

import dao.GerenteDeDados;

@ManagedBean
@SessionScoped
public class Agenda {
	@EJB
	private GerenteDeDados dao;
	private boolean mostra = false;
	private boolean insere = false;
	private Integer idAssociado;
	private String nome;
	private Horario horario = Horario.MANHA;
	private Integer idAtividade;

	public Integer getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Integer idAssociado) {
		this.idAssociado = idAssociado;
	}

	public boolean isMostra() {
		return mostra;
	}

	public void setMostra(boolean mostra) {
		this.mostra = mostra;
	}

	public String mostrarAgenda() {
		mostra = true;
		return "";
	}

	public String escondeAgenda() {
		mostra = false;
		return "";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public boolean isInsere() {
		return insere;
	}

	public void setInsere(boolean insere) {
		this.insere = insere;
	}

	public String mostrarInsere() {
		insere = true;
		return "";
	}

	public String escondeInsere() {
		insere = false;
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ListDataModel<modelo.Agenda> getLista() {
		return new ListDataModel(dao.getAgendas(idAssociado));
	}

	public Integer getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Collection getAtividades() {
		List<SelectItem> lista = new ArrayList<SelectItem>();

		try {
			List<modelo.Atividade> obj = dao.getAtividades();

			if (obj.size() > 0 && getIdAtividade() == null)
				setIdAtividade(obj.get(0).getId());

			for (modelo.Atividade f : obj)
				lista.add(new SelectItem(f.getId(), f.getNome()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@SuppressWarnings("rawtypes")
	public Collection getHorarios() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for (Horario hora: Horario.values()) 
			lista.add(new SelectItem(hora, hora.toString()));
		
		return lista;
	}
	
	public String gravaHorario() {
		escondeInsere();
		dao.insereHorario(idAtividade, idAssociado, horario);
		return "";
	}
}
