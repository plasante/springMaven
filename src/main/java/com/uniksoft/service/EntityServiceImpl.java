package com.uniksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.dao.EntityDAO;

/**
 * 
 * @author plasante
 *
 * @param <T>
 */
@Service
public class EntityServiceImpl<T> {

	@Autowired
	private EntityDAO<T> entityDAO;

	@Transactional
	public void addEntity(T entity) {
		entityDAO.addEntity(entity);
	}

	@Transactional
	public void updateEntity(T entity) {
		entityDAO.updateEntity(entity);
	}

	@Transactional
	public List<T> listEntities(Class<T> entity) {
		return entityDAO.listEntities(entity);
	}

	@Transactional
	public T getEntityById(Class<T> entity, Integer entityId) {
		return entityDAO.getEntityById(entity, entityId);
	}

	@Transactional
	public void removeEntity(Class<T> entity, Integer entityId) {
		entityDAO.removeEntity(entity, entityId);
	}
}
