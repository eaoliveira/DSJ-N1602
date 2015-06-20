package Exercicio_Anotacoes;

// CLASSE QUE COLETA E IMPRIME AS ANOTACOES

public class Testa_Anotacao  {
	
	
	public static void main(String[] args) {
		
		Teste pega_anotacao = Anotacoes.class.getAnnotation(Teste.class);
		System.out.println(pega_anotacao.descricao());
		System.out.println(pega_anotacao.data());
			
	}
	
	
}
