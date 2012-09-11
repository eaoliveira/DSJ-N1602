package api.colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploComparable {
     public static void main(String[] args) {
			List<Produto> lista = new ArrayList<>();
			
			for (int i = 0; i < 5; i++) {
				Produto p = new Produto();
				p.setNome("Teste"+(Math.random()*1000));
				p.setDesc("Produto " +(i + 1));
				p.setValor((i+1) * 255.0);
				lista.add(p);
			}
			
			Collections.sort(lista);
			
			for (Produto string : lista)
				System.out.println(string);
			
			System.out.println("------------------------------------------");
			
			Collections.sort(lista, new ComparadorDeProduto());
			
			for (Produto string : lista)
				System.out.println(string);
			
		}
}

class ComparadorDeProduto  implements Comparator<Produto> {
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}

class Produto implements Comparable<Produto>{
	private String nome;
	private String desc;
	private Double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "nome:" + nome + " desc:" + desc + " valor:" + valor;
	}


	@Override
	public int compareTo(Produto o) {
			return (int)(valor - o.valor);
	}

}