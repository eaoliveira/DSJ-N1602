package view;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.EntityDao;
import model.Turma;

@ManagedBean(name = "turmabean")
@RequestScoped
public class CadTurma {
	@EJB
	private EntityDao dao;

	private Turma turma = new Turma();

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String salvar() {
		FacesContext ctx = FacesContext.getCurrentInstance();

		if (turma.getDescricao().isEmpty())
			Messages.add(ctx, "descricao", "A Descrição deve ser informada");
		else if (turma.getDescricao().length() > 250)
			Messages.add(ctx, "descricao", "A Descrição não pode ser maior que 250 caracteres");

		if (turma.getTitulo().isEmpty())
			Messages.add(ctx, "titulo", "O Título deve ser informado");

		if (turma.getInicio() == null || !turma.getInicio().after(new Date()))
			Messages.add(ctx, "inicio", "A Data de início deve ser no futuro");

		if (turma.getNumhoras() < 12 || turma.getNumhoras() > 360)
			Messages.add(ctx, "numhoras", "O Nº de horas deve estar entre 12 e 360");

		if (ctx.getMessageList().size() == 0) {
			dao.salva(turma);
			Messages.add(ctx, "Sucesso na gravação");
			
			turma = new Turma();
			return "sucesso";
		}
		return "";
	}
}
