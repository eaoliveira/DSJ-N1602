package org.nois.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectList implements ObjectDao<Pizza> {
	private List<Pizza> lista;
	private static ObjectList obj;
	private int id = 0;

	private ObjectList() {
		lista = new ArrayList<Pizza>();
	}

	private ObjectList(List<Pizza> lista) {
		this.lista = lista;
	}

	public static ObjectList getInstance(List<Pizza>... lista) {
		if (obj == null) {
			if (lista != null && lista.length > 0 && lista[0] != null) {
				obj = new ObjectList(lista[0]);
			} else {
				obj = new ObjectList();
			}
		}

		return obj;
	}

	@Override
	public int count() {
		return lista.size();
	}

	@Override
	public Pizza get(long id) {
		Pizza obj = null;

		for (Pizza pizza : lista) {
			if (pizza.getId() == id) {
				obj = pizza;
				break;
			}
		}
		return obj;
	}

	@Override
	public void add(Pizza obj) {
		obj.setId(id++);
		lista.add(obj);
	}

	@Override
	public void put(Pizza obj) {
		long id = obj.getId();
		lista.set((int) id, obj);
	}

	@Override
	public List<Pizza> getAll() {
		return Collections.synchronizedList(lista);
	}

	@Override
	public void del(long id) {
		lista.remove((int) id);
	}
}
