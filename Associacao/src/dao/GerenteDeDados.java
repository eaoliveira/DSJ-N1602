package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Agenda;
import modelo.Associado;
import modelo.Atividade;
import modelo.Horario;

@Stateless
public class GerenteDeDados {
	@PersistenceContext(unitName = "Associacao")
	private EntityManager sessao;

	public void grava(Object a) {
		sessao.persist(a);		
	}

	public List<Associado> getAssociados() {
		return sessao.createQuery("from Associado", Associado.class).getResultList();
	}
	
	public List<Agenda> getAgendas(Integer idAssociado) {
		Associado ass = sessao.find(Associado.class, idAssociado);

		return sessao.createQuery("from Agenda where associado = :obj", Agenda.class).
		            setParameter("obj", ass).getResultList();
	}

	public List<Atividade> getAtividades() {
		List<Atividade> lista = sessao.createQuery("from Atividade", Atividade.class)
				.getResultList();
		return lista;
	}

	public void insereHorario(Integer idAtividade, Integer idAssociado, Horario horario) {
		Atividade at = sessao.find(Atividade.class, idAtividade);
		
		Associado ass = sessao.find(Associado.class, idAssociado);
		
		Agenda ag = new Agenda();
		ag.setAtividade(at);
		ag.setAssociado(ass);
		ag.setHorario(horario);
		sessao.persist(ag);
		
		ass.getAgendamentos().add(ag);
		sessao.merge(ass);
	}
	
}
