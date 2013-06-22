package Anotacao;

import java.io.IOException;
import java.io.PrintStream;

/*
 * Exemplo de Classes anotadas
 */

public class Investimento {
  @EmProgresso
  @GrupoTODO(severity = GrupoTODO.Severidade.CRITICO, 
             item = "Calcular o montante de investimento", 
             designadoA = "Fulano da Silva", 
             dataDesignacao = "26-04-2007")
  public void calculoDeInvestimento(float valor, float taxa) {
  // Para posterior implementação
  }
}

@EmProgresso
class Super {
  public void print(PrintStream out) throws IOException {
    out.println("Super imprimindo...");
  }
}

class Sub extends Super {
  public void print(PrintStream out) throws IOException {
    out.println("Sub imprimindo...");
  }
}
