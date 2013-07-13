package org.nois.model;

import java.util.List;

public interface ObjectDao<T> {
	int count();
	T get(long id);
	void add(T obj);
	void put(T obj);
	List<T> getAll();
	void del(long id);
}
