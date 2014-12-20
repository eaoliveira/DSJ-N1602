package jsf;

import java.text.NumberFormat;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConverteDouble implements Converter {
	NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String valor) throws ConverterException {
		double val = 0d;
		
		if (valor != null && !valor.toString().trim().equals("")) {
			try {
				nf.setMaximumFractionDigits(2);
				val =  nf.parse(valor).doubleValue();
			} catch (Exception e) {
			}
		}
		
		return val;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object valor) throws ConverterException {
		String val = "0,00"; 
		
		if (valor != null && !valor.toString().trim().equals("")) {
			nf.setMaximumFractionDigits(2);
			val = nf.format(Double.valueOf(valor.toString()));
		}
		
		return val;
	}
}