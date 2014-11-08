package caddata.bean;

import java.util.List;

import caddata.modelo.ObjData;

public class DataBean {
	private List<ObjData> data;
	
	public DataBean(List<ObjData> data) {
		super();
		this.data = data;
	}

	public List<ObjData> getData() {
		
		System.out.println("--- Lista de Datas Cadastradas ---");
		for (ObjData objData : data) {
			System.out.println("getData: " + objData);
		}

		return data;
	}

	public void setData(List<ObjData> data) {
		this.data = data;
	}
	
	public int getQuantidade() {
		System.out.println("GetQuantidade: " + data.size());
		return data.size();
	}
}
