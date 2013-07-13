package org.nois.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ObjectSql extends SQLiteOpenHelper implements ObjectDao<Pizza> {
	public ObjectSql(Context context) {
		super(context, "DbItem", null, 1);
		Log.d("ObjectSql", "init");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table pizza (" +
				"id integer primary key autoincrement," +
				"nome text not null," +
				"grupo text not null," +
				"descricao text not null," +
				"imagemGrande text not null," +
				"imagemPequena text not null," +
				"preco double not null)"); 
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versaoAnterior, int versaoAtual) {
		db.execSQL("drop table if exists pizza");
		onCreate(db);
	}
	
	public int count() {
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.rawQuery("select count(*) from pizza", null) ;
		c.moveToFirst();
		db.close();
		return c.getInt(0);
	}
	
	public Pizza get(long id) {
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.rawQuery("select * from pizza where id=?", 
				new String[] {String.valueOf(id)});
		
		Pizza obj = null;
		
		if(c.getCount() > 0) {
			c.moveToFirst();
			obj = new Pizza();
			obj.setId(c.getInt(0));
			obj.setNome(c.getString(1));
			obj.setGrupo(c.getString(2));
			obj.setDescricao(c.getString(3));
			obj.setImagemGrande(c.getString(4));
			obj.setImagemPequena(c.getString(5));
			obj.setPreco(c.getDouble(6));
		}
		
		db.close();
		
		return obj; 
	}

	public void add(Pizza obj) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("insert into pizza ( nome, grupo, descricao, " +
				"imagemGrande, imagemPequena, preco ) " +
                 "values ('"+ obj.getNome() +
				"', '" + obj.getGrupo() + 
				"', '" + obj.getDescricao() +
				"', '" + obj.getImagemGrande() +
				"', '" + obj.getImagemPequena() +
				"', " + obj.getPreco() + ")");
		db.close();
	}
	
	public void put(Pizza obj) {
		SQLiteDatabase db = getWritableDatabase();		
		db.execSQL(
				"update pizza set nome = '" + obj.getNome()+
				"', grupo = '" +obj.getGrupo()+
				"', descricao = '" +obj.getDescricao()+
				"', imagemGrande = '" +obj.getImagemGrande()+
				"', imagemPequena = '" +obj.getImagemPequena()+
				"', preco = " +obj.getPreco()+
				" where id = " +obj.getId());
		db.close();
	}

	public List<Pizza> getAll() {
		List<Pizza> lista = new ArrayList<Pizza>();
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.rawQuery("select * from pizza", null);
		
		c.moveToFirst();
		for (int i = 0; i < c.getCount(); i++) {
			Pizza obj = new Pizza();
			obj.setId(c.getInt(0));
			obj.setNome(c.getString(1));
			obj.setGrupo(c.getString(2));
			obj.setDescricao(c.getString(3));
			obj.setImagemGrande(c.getString(4));
			obj.setImagemPequena(c.getString(5));
			obj.setPreco(c.getDouble(6));
			lista.add(obj);
			c.moveToNext();
		}
		db.close();
		
		return lista;
	}
	
	public void del(long id) {
		SQLiteDatabase db = getWritableDatabase();
		db.rawQuery("delete from pizza where id=?",  new String[] {String.valueOf(id)});
		db.close();
	}
}