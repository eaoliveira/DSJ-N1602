package bean;

import java.util.List;

import model.Turma;

public class TurmaBean {
	private List<Turma> turmas;
	
	public TurmaBean(List<Turma> turmas) {
		super();
		this.turmas = turmas;
	}

	public List<Turma> getLista() {
		return turmas;
	}

	public void setLista(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public int getQuantidade() {
		return turmas.size();
	}
}
