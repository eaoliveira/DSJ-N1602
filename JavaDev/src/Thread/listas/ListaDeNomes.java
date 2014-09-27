package Thread.listas;

import java.util.ArrayList;
import java.util.List;

public class ListaDeNomes {
	private static List<Nome> lista = new ArrayList<Nome>();

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					try {
						lista.add(new Nome(
								String.valueOf(Math.random() * 10000), String
										.valueOf(Math.random() * 10000)));
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				for (int i = 0; i < 5000; i++) {
					lista.remove((int) Math.random() * lista.size());
				}
			}
		}.start();

		new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					try {
						for (Nome n : lista)
							System.out.println(i + ": " + n);

						System.out
								.println("------------------------------------------");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
