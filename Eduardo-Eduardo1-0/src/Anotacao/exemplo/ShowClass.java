package Anotacao.exemplo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SuppressWarnings("rawtypes")
public class ShowClass {
	public static void main(String[] args) throws ClassNotFoundException {

		// Cria um objeto Class associado é Classe ou Interface informada no
		// argumento
		Class aClass = Class.forName("Anotacao.exemplo.Funcionario");

		// Testa se é uma Interface
		if (aClass.isInterface()) {
			System.out.print(Modifier.toString(aClass.getModifiers()) + " "
					+ typeName(aClass));
		} else
		// Testa se têm uma Superclasse
		if (aClass.getSuperclass() != null) {
			System.out.print(Modifier.toString(aClass.getModifiers())
					+ " class " + typeName(aClass) + " extends "
					+ typeName(aClass.getSuperclass()));
		} else {
			System.out.print(Modifier.toString(aClass.getModifiers())
					+ " class " + typeName(aClass));
		}

		// Lista as interfaces ou super-interfaces da classe ou interface.
		Class[] interfaces = aClass.getInterfaces();
		if ((interfaces != null) && (interfaces.length > 0)) {
			if (aClass.isInterface())
				System.out.print(" extends ");
			else
				System.out.print(" implements ");
			for (int i = 0; i < interfaces.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(typeName(interfaces[i]));
			}
		}

		System.out.println(" {");

		// Lista os construtores
		System.out.println("  // Constructores");
		Constructor[] constructors = aClass.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++)
			printMethodOrConstructor(constructors[i]);

		// Lista os atributos
		System.out.println("  // Atributos");
		Field[] fields = aClass.getDeclaredFields(); // Pesquisa os atributos
		for (int i = 0; i < fields.length; i++)
			printField(fields[i]);

		// Lista os métodos
		System.out.println("  // Métodos");
		Method[] methods = aClass.getDeclaredMethods(); // Pesquisa os métodos
		for (int i = 0; i < methods.length; i++)
			printMethodOrConstructor(methods[i]);

		System.out.println("}"); // Fim da Classe
	}

	public static String typeName(Class t) {
		String brackets = "";
		while (t.isArray()) {
			brackets += "[]";
			t = t.getComponentType();
		}
		String name = t.getName();
		int pos = name.lastIndexOf('.');
		if (pos != -1)
			name = name.substring(pos + 1);
		return name + brackets;
	}

	// trata os espaços para os modicadores de acesso da classe.
	public static String modifiers(int m) {
		if (m == 0)
			return "";
		else
			return Modifier.toString(m) + " ";
	}

	// imprimeno nome dos atributos
	public static void printField(Field f) {
		System.out.println("  " + modifiers(f.getModifiers())
				+ typeName(f.getType()) + " " + f.getName() + ";");
	}

	// imprime os métodos e contrutores
	public static void printMethodOrConstructor(Member member) {
		Class returntype = null, parameters[], exceptions[];
		if (member instanceof Method) {
			Method m = (Method) member;
			returntype = m.getReturnType();
			parameters = m.getParameterTypes();
			exceptions = m.getExceptionTypes();
			System.out.print("  " + modifiers(member.getModifiers())
					+ typeName(returntype) + " " + member.getName() + "(");
		} else {
			Constructor c = (Constructor) member;
			parameters = c.getParameterTypes();
			exceptions = c.getExceptionTypes();
			System.out.print("  " + modifiers(member.getModifiers())
					+ typeName(c.getDeclaringClass()) + "(");
		}

		for (int i = 0; i < parameters.length; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(typeName(parameters[i]));
		}
		System.out.print(")");
		if (exceptions.length > 0)
			System.out.print(" throws ");
		for (int i = 0; i < exceptions.length; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(typeName(exceptions[i]));
		}
		System.out.println(";");
	}
}