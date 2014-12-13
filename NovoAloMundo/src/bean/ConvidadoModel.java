package bean;

import modelo.Convidado;

public class ConvidadoModel extends Convidado {
	private boolean del;

	public ConvidadoModel(Convidado obj) {
		super();
		this.setId(obj.getId());
		this.setNome(obj.getNome());
		this.setEmail(obj.getEmail());
		this.setIdade(obj.getIdade());
		this.del = false;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}
}
