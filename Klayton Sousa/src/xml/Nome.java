

package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"id",
	"nome",	
    "descricao",
    "preco"
})
@XmlRootElement(name = "nome")
public class Nome {

    public static final int NOVO_REGISTRO = 0;
	
    protected String value;

    
    public String getvalue() {
        return value;
    }

    
    public void setvalue(String value) {
        this.value = value;
    }

	public int getId() {
		
		return Id;
	}


	public void setId(int value) {
		this.id = value;
		
	}


	public String getDescricao() {
		
		return descricao;
	}
	
	

}
