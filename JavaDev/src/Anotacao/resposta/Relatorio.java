package Anotacao.resposta;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Relatorio {
	public static void main(String[] args) {
		Class<Item> item = Item.class;
		
		if(item.isAnnotationPresent(AFazer.class))  
			imprime(item.getAnnotation(AFazer.class));
		
		for (Field fld : item.getDeclaredFields()) {
			if(fld.isAnnotationPresent(AFazer.class))
				imprime(fld.getAnnotation(AFazer.class));
		}
		
		for(Constructor<?> cons : item.getConstructors()) {
			if(cons.isAnnotationPresent(AFazer.class))
				imprime(cons.getAnnotation(AFazer.class));
		}
		
		for(Method meth : item.getMethods()) {
			if(meth.isAnnotationPresent(AFazer.class))
				imprime(meth.getAnnotation(AFazer.class));
		}
	}
	
	
	public static void imprime(AFazer obj) {
		System.out.println("Data: " + obj.data() + " Descrição: " + obj.descricao());
	}
}
