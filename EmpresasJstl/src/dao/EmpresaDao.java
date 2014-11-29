package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Empresa;
import bean.Empresas;

@Stateless
public class EmpresaDao {
	@PersistenceContext(unitName="EmpresasJstl")
	private EntityManager sessao;

	public void adiciona(Empresa obj) {
		sessao.merge(obj);
	}

	public void remove(int id) {
		Empresa praRemover = sessao.find(Empresa.class, id);
		sessao.remove(praRemover);
	}

	public Empresas getEmpresas() {		
		return new Empresas(sessao.createQuery("from Empresa as e",Empresa.class).getResultList());
	}
}
