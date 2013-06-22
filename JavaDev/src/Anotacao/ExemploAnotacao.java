package Anotacao;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class ExemploAnotacao {
  public static void main(String[] args) throws Exception {
    
    // Testa a presença da anotação @EmProgresso na classe Super
    if(Super.class.isAnnotationPresent(EmProgresso.class))
      System.out.println("Super est� em Progresso");
    else
      System.out.println("Super n�o est� em Progresso");

    
    // Testa a presença da anotação @EmProgresso na subclasse Sub
    if(Sub.class.isAnnotationPresent(EmProgresso.class))
      System.out.println("Sub est� em Progresso");
    else
      System.out.println("Sub n�o est� em Progresso");

    
    // Acessa o método da classe Investimento que foi marcada com a anotação GrupoTOTO
    AnnotatedElement element = 
      Investimento.class.getMethod(
      		"calculoDeInvestimento", float.class, float.class);

    
    // Obtém uma referência é anotação GrupoTODO utilizada no método calculoDeInvestimento
    GrupoTODO groupTodo = element.getAnnotation(GrupoTODO.class);

    
    // Acessa o valor associado ao atributo designadoA do GrupoTODO e imprime na tela
    System.out.printf(
    	"\nTODO na Classe: %s está designado á: '%s'\n",
      Investimento.class.getName(), groupTodo.designadoA());

    
    System.out.printf(
    	"\nResumo das anotações para a classe '%s'\n", 
      Investimento.class.toString());

    
    // Obtém a lista de anotações utilizadas na classe Investimento
    Annotation[] annotations = 
    	Investimento.class.getAnnotations();

    
    // Acessa o nome do Tipo da anotação utilizada na classe Investimento
    for(Annotation a : annotations)
      System.out.printf(
      		"    * Anotação '%s' encontrada\n", 
      		a.annotationType().getName());
  }
}
