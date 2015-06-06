package Rmi.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public enum Operacao {
	SOMA {
		public double execute(int i, int j) throws RemoteException {
			return calc.soma(i, j);
		}
	},

	SUBTRACAO {
		public double execute(int i, int j) throws RemoteException {
			return calc.subtrai(i, j);
		}
	},

	MULTIPLICACAO {
		public double execute(int i, int j) throws RemoteException {
			return calc.multiplica(i, j);
		}
	},

	DIVISAO {
		public double execute(int i, int j) throws RemoteException {
			return calc.divide(i, j);
		}
	};

	public abstract double execute(int i, int j) throws RemoteException;

	protected Calculo calc;

	private Operacao() {
		try {
			Registry reg = LocateRegistry.getRegistry("10.84.144.250");
			calc = (Calculo) reg.lookup("calculadora");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}