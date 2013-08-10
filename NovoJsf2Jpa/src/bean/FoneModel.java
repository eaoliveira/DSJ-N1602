package bean;

import modelo.Fone;

public class FoneModel {
	private Integer id;
	private String ddd;
	private String num;
	private boolean del;
	
	public FoneModel() {
		super();
	}

	public FoneModel(Fone obj) {
		super();
		this.id = obj.getId();
		this.ddd = obj.getDdd();
		this.num = obj.getNumero();
		this.del = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
