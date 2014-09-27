package Thread.listas;

import java.util.ArrayList;
import java.util.List;

public class SyncListaDeNomes {
	private static List<Nome> lista = new ArrayList<Nome>();

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					synchronized (lista) {
						lista.add(new Nome(String
								.valueOf(Math.random() * 10000), String
								.valueOf(Math.random() * 10000)));
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				for (int i = 0; i < 500; i++) {
					synchronized (lista) {
						lista.remove((int) Math.random() * 999);
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					synchronized (lista) {
						for (Nome n : lista)
							System.out.println(i + ": " + n);

						System.out
								.println("------------------------------------------");

					}
				}
			}
		}.start();
	}
}
