package api.enumeracao;

public enum Operacao {
  SOMA {
    public double execute(int i, int j) {
      return i + j;
    }
  },
  
  SUBTRACAO {
    public double execute(int i, int j) {
      return i - j;
    }
  },
  
  MULTIPLICACAO {
    public double execute(int i, int j) {
      return i * j;
    }
  },
  
  DIVISAO {
    public double execute(int i, int j) {
      return i / j;
    }
  };
  
  public abstract double execute(int i, int j);
}