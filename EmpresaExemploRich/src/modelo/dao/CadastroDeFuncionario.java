package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import modelo.Fone;
import modelo.Funcionario;

@Stateless
public class CadastroDeFuncionario {
	@PersistenceContext(unitName = "empresa")
	EntityManager session;

	public void salvaFuncionario(Funcionario func) throws DaoException {
		try {
			session.merge(func);
		} catch (PersistenceException ex) {
			throw new DaoException(ex.getMessage() + ex.getCause());
		}
	}

	public void removeFuncinario(List<Funcionario> lista) throws DaoException {
		try {
			for (Funcionario f : lista) {
				Funcionario func = session.find(Funcionario.class, f.getId());
				session.remove(func);
			}

		} catch (PersistenceException ex) {
			throw new DaoException(ex.getMessage());
		}
	}

	public void removeFone(Integer idFunc, List<Fone> lista) throws DaoException {
		try {
			Funcionario func = session.find(Funcionario.class, idFunc);

			for (Fone f : lista) {
				for (Fone fone : func.getTelefones()) {
					if (f.getId().equals(fone.getId())) {
						func.getTelefones().remove(fone);
						session.remove(fone);
						break;
					}
				}
			}

			session.persist(func);
		} catch (PersistenceException ex) {
			throw new DaoException(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getLista() {
		try {
			List<Funcionario> lista = session.createQuery(
					"select func from Funcionario as func")
					.getResultList();
			return lista;
		} catch (NoResultException ex) {
			return new ArrayList<Funcionario>();
		}
	}

	public Funcionario localizaFuncionario(String nome) {
		try {
			Query consulta = session.createQuery(
					"select func from Funcionario as func where func.nome=:nome");
			consulta.setParameter("nome", nome);
			return (Funcionario) consulta.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Funcionario localizaFuncionarioPeloId(Integer id) {
		try {
			Funcionario func = (Funcionario) session
					.createQuery("select func from Funcionario as func where func.id=:id")
					.setParameter("id", id).getSingleResult();
			return func;
		} catch (NoResultException ex) {
			System.out.println("Erro: sem resultado: " + id);
			return null;
		}
	}

}
