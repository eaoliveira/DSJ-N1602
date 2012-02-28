package objeto;

// POJO
public class Carro {
     private int aro;
     private String cor;
     private int ano;
     
     public Carro() {
    	 ano = 2000;
    	 cor = "preto";
    	 aro = 13;
     }
     // Construtor
     public Carro(int ano, int aro, String cor) {
			 setAno(ano);
			 setAro(aro);
			 setCor(cor);
		}

		public int getAro() {
    	 return aro;
     }

     public void setAro(int aro) {
    	 this.aro = aro;
     }
     
     public String getCor() {
    	 return cor;
     }
     
     public void setCor(String cor) {
    	 this.cor = cor;
     }
     
     public int getAno() {
    	 return ano;
     }
     
     public void setAno(int ano) {
    	 this.ano = ano;
     }

     public String toString() {
  	 return "Carro ano: " + ano +
  			          " Cor: " + cor +
  			          " Aro: " + aro;
     }
}
