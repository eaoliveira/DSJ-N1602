package banco;

public class caixa extends Thread {
	
	private fila primaria;
	private fila secundaria;
	private cliente atendimento;
	
	public caixa(fila filanormal, fila filaidoso){
		
		primaria = filanormal;
		secundaria = filaidoso;
	}
	
	public void abre(){
		this.start();
	}
	public void fecha(){
		while(!isInterrupted()){
			try{
			if(primaria.temGente()){
				atendimento = primaria.proximo();
			}else if(primaria.temGente()){
				atendimento = secundaria.proximo();
			}else{
				atendimento = null;
			}
			
			int documento = atendimento!= null? atendimento.getDocumento():5;
			Thread.sleep(documento *1000);
			
			}catch (InterruptedException e ){
			e.getMessage();
			e.printStackTrace();
			}
		}
	}
}
