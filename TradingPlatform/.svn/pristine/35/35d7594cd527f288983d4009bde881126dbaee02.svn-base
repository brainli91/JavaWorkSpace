package com.fdmgroup.tradingplatform.dao;

import java.util.List;

import com.fdmgroup.tradingplatform.model.IStorable;

public interface IStorage<T extends IStorable> {
	// public interface IStorage extends IStorable{

	public List<T> readAll();

	public T create(T t);

	public T read(int id);

	public T update(T t);

	public boolean delete(T t);

}
