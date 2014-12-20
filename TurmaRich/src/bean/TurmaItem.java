package bean;

import java.util.Date;

public class TurmaItem {
	private Integer id;
	private String titulo;
	private Date inicio;
	private int horas;
	private boolean del;
	
	public TurmaItem(Integer id, String titulo, Date inicio, int horas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.inicio = inicio;
		this.horas = horas;
		this.del = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
