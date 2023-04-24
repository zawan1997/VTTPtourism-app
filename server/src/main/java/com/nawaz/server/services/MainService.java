package com.nawaz.server.services;

import java.util.List;

public interface MainService<T> {
	public T create(T req);
	public T update(T req);
	public List<T> get();
	public T get(int id);
	public String delete(int id);
}
