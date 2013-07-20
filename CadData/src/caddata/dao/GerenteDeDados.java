package caddata.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import caddata.bean.DataBean;
import caddata.modelo.ObjData;

// Classe Singleton
public class GerenteDeDados {
	// Atributo para guardar a �nica inst�ncia deste Objeto
	private static GerenteDeDados meuObj;
	private List<ObjData> lista;
	private int nextId = 0;
	
	// Construtor privado, impedindo a cria��o deste Objeto
	// por outras classes
	private GerenteDeDados() {
		lista = new ArrayList<ObjData>();
	}
	
	// m�todo publico e static, oferecendo o mecanismo
	// para a obten��o da �nica refer�ncia deste Objeto
	public static GerenteDeDados getInstance() {
		if(meuObj == null)
			meuObj = new GerenteDeDados();
		
		return meuObj;
	}
	
	public void gravaData(Date data) {
		lista.add(new ObjData(nextId++, data));
			
//		ObjData obj = new ObjData(nextId, data);
//		nextId++;
//		lista.add(obj);
	}

	public DataBean leDatas() {
		return new DataBean(Collections.synchronizedList(lista));
	}
	
	public void apagaData(int id) {
		synchronized (lista) {
			lista.remove(new ObjData(id));
//			for (int i = 0;i< lista.size();i++) {
//				ObjData obj = lista.get(i);
//				if(obj.getId() == id) {
//					lista.remove(i);
//				}
//			}			
		}
	}
}
