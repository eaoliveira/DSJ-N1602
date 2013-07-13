package org.nois.model;

import java.util.List;

import android.content.Context;

@SuppressWarnings("unchecked")
public class ObjectFactory {
	private ObjectFactory() {
	}

	public static ObjectDao<Pizza> getInstance() {
			return ObjectList.getInstance();
	}

	public static ObjectDao<Pizza> getInstance(List<Pizza> obj) {
			return ObjectList.getInstance(obj);
	}

	public static ObjectDao<Pizza> getInstance(Context ctx) {
		return new ObjectSql(ctx);
	}
}
