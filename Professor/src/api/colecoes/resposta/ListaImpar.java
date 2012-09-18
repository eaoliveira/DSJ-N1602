package api.colecoes.resposta;

import java.util.ArrayList;
import java.util.List;

public class ListaImpar {
	public static void main(String[] args) {
		List<Fone> lista = new ArrayList<Fone>();
		
		Fone f = new Fone();
		f.setDdd("11");
		f.setNumero("6547-6544");
		f.setTipo(TipoFone.CELULAR);
		lista.add(f);

		f = new Fone();
		f.setDdd("11");
		f.setNumero("6547-8547");
		f.setTipo(TipoFone.COMERCIAL);
		lista.add(f);
		
		f = new Fone();
		f.setDdd("11");
		f.setNumero("685-9845");
		f.setTipo(TipoFone.RECADO);
		lista.add(f);

		f = new Fone();
		f.setDdd("11");
		f.setNumero("993-5588");
		f.setTipo(TipoFone.FAX);
		lista.add(f);
		
		f = new Fone();
		f.setDdd("11");
		f.setNumero("6547-0001");
		f.setTipo(TipoFone.RESIDENCIAL);
		lista.add(f);
		
		
		for (int i = 1; i < lista.size(); i+=2) {
			System.out.println(i + ": " + lista.get(i));
		}
		
		System.out.println("-----");
		
		for (int i = 0; i < lista.size(); i++) {
			if(i % 2 != 0)
			  System.out.println(i + ": " + lista.get(i));
		}
	}
}
