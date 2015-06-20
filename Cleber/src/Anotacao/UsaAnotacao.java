package Anotacao;

 @AFazer(data="12/04/2014", descricao="Teste de execução de codigo")
public class UsaAnotacao {
	
	public static void main(String args[]){
		AFazer teste = UsaAnotacao.class.getAnnotation(AFazer.class);
		
		if(teste != null) {
			System.out.println(teste.data() + "\n" + teste.descricao());
		} else {
			System.out.println("A classe UsaAnotacao não tem a anotação AFazer");
		}
	}

}
