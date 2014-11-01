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
		return data;
	}

	public void setData(List<ObjData> data) {
		this.data = data;
	}
	
	public int getQuantidade() {
		return data.size();
	}
}
