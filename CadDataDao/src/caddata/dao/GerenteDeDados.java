package caddata.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caddata.bean.DataBean;
import caddata.modelo.ObjData;

@Stateless
public class GerenteDeDados {
	@PersistenceContext(unitName="CadData")
	EntityManager em;

	public void gravaData(Date data) {
		ObjData obj = new ObjData();
		obj.setData(data);
		em.merge(obj);
	}

	public DataBean leDatas() {
		List<ObjData> lista = em.createQuery(
				"select d from ObjData as d order by d.data", ObjData.class)
				.getResultList();
		
		return new DataBean(lista);
	}
	
	public void apagaData(int id) {
		ObjData obj = em.find(ObjData.class, id);
		System.out.println("Apagar: " + obj);
		em.remove(obj);
	}
}
