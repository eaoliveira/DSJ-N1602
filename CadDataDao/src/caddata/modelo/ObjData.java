package caddata.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CadData")
public class ObjData {
	@Id
	@Column(name="idCadData")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public ObjData() {
		super();
	}

	public ObjData(Integer id) {
		super();
		this.id = id;
	}

	public ObjData(Integer id, Date data) {
		super();
		this.id = id;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjData other = (ObjData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjData [id=" + id + ", data=" + data + "]";
	}
	
}
