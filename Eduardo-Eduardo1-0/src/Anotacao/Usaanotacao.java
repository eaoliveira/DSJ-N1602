package Anotacao;

import java.lang.annotation.Annotation;




public class Usaanotacao {

	public static void main(String[] args) throws ClassNotFoundException {
	
		 AFazer afazer = Agenda.class.getAnnotation(AFazer.class);		
		
		System.out.println(afazer.decricao());
		System.out.println(afazer.data());
	}
}
