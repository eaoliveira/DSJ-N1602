package Thread.FilaBancaria;

public class Agencia extends Thread {
	
	FilaBancaria preferencial = new FilaBancaria();
	FilaBancaria normal = new FilaBancaria();
	int qdteCliente = 10;
	Caixa[] caixas = {new Caixa(preferencial, normal),new Caixa(preferencial, normal),new Caixa(preferencial, normal),new Caixa(preferencial, normal),new Caixa(preferencial, normal)} ;
	
	public void abrir (){
		for(Caixa cx: caixas)
			cx.abre();
		start();
	}
	
	public void fechar(){
		
		interrupted();
		
		for(Caixa cx:caixas)
			
			cx.fecha();
	}
	public void run(){
		try{
			while(!isInterrupted()){
				
				for(int i = 0; i < qdteCliente; i++){
					
					Cliente cli = new Cliente();
					if(cli.isTipo()){
						preferencial.entrar(cli);
						}
					else{
						normal.entrar(cli);
					}
					
				}
				Thread.sleep(5);
			}
		}
		catch(InterruptedException e){
			
		}
	}
	

}
