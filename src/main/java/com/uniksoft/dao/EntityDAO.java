package com.uniksoft.dao;

import java.util.List;

/*
 * This generic interface talks to the db.
 */
public interface EntityDAO<T> {
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public List<T> listEntities(Class<T> entity);
	public T getEntityById(Class<T> entity, Integer entityId);
	public void removeEntity(Class<T> entity, Integer entityId);
}
