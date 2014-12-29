package com.uniksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.dao.EntityDAO;

@Service
public class EntityServiceImpl<T> implements EntityService<T> {

	@Autowired
	private EntityDAO<T> entityDAO;

	@Override
	@Transactional
	public void addEntity(T entity) {
		entityDAO.addEntity(entity);
	}

	@Override
	@Transactional
	public void updateEntity(T entity) {
		entityDAO.updateEntity(entity);
	}

	@Override
	@Transactional
	public List<T> listEntities(Class<T> entity) {
		return entityDAO.listEntities(entity);
	}

	@Override
	@Transactional
	public T getEntityById(Class<T> entity, Integer entityId) {
		return entityDAO.getEntityById(entity, entityId);
	}

	@Override
	@Transactional
	public void removeEntity(Class<T> entity, Integer entityId) {
		entityDAO.removeEntity(entity, entityId);
	}
}
