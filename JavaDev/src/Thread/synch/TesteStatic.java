package Thread.synch;

import java.util.*;

public class TesteStatic extends Thread {
	List<Maquina> lista = new ArrayList<Maquina>();

	public static void main(String[] args) {
		TesteStatic obj = new TesteStatic();
		obj.lista.add(new Maquina("Teste1"));
		obj.lista.add(new Maquina("Teste2"));
		obj.lista.add(new Maquina("Teste3"));
		for (Maquina al : obj.lista)
			al.start();

		obj.start();
	}

	public void run() {
		while (true) {
			try {
				for (Maquina al : lista) {
					synchronized (al.getNum()) {
						System.out.println(al.getNum());
					}
				}
				Thread.sleep(200);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class Maquina extends Thread {
	private String descr;
	private static List<Integer> num = new ArrayList<Integer>();

	public void run() {
		try {
			while (true) {
				synchronized (num) {
					num.add((int) Math.ceil(Math.random() * 1000));
				}
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Maquina(String descr) {
		this.descr = descr;
		synchronized (num) {
			num.add((int) Math.ceil(Math.random() * 1000));
		}
	}

	public String getDescr() {
		return descr;
	}

	public List<Integer> getNum() {
		return num;
	}

	public void setNum(List<Integer> num_) {
		num = num_;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "descr:  " + descr;
	}

}