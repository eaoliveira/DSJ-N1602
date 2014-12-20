package view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Aluno;
import model.EntityDao;
import model.Turma;

@ManagedBean(name = "alunobean")
@RequestScoped
public class CadAluno {
	@EJB
	private EntityDao dao;

	private Aluno aluno = new Aluno();
	private Integer turma;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return dao.getTurmas();
	}
	
	public String salvar() {
		FacesContext ctx = FacesContext.getCurrentInstance();

		if (aluno.getNome().isEmpty())
			Messages.add(ctx, "nome", "O Nome deve ser informado");
		else if (aluno.getNome().length() > 25)
			Messages.add(ctx, "nome",
					"O Nome não pode ser maior que 25 caracteres");

		if (aluno.getEmail().isEmpty())
			Messages.add(ctx, "email", "O E-Mail deve ser informado");

		if (ctx.getMessageList().size() == 0) {
			Turma turma = dao.getTurma(this.turma);
			aluno.setTurma(turma);
			turma.getAlunos().add(aluno);
			dao.salva(turma);
			Messages.add(ctx, "Sucesso na gravação");

			aluno = new Aluno();
		}
		return "";
	}
}
