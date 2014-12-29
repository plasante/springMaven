package com.uniksoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntityDAOImpl<T> implements EntityDAO<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEntity(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void updateEntity(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listEntities(Class<T> entity) {
		String className = entity.getSimpleName();
		return sessionFactory.getCurrentSession().createQuery("from " + className).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityById(Class<T> entity, Integer entityId) {
		String className = entity.getSimpleName();
		String sql = "from " + className + " b where b.id = :entityId";
		List<T> list = sessionFactory.getCurrentSession().createQuery( sql ).setParameter("entityId", entityId).list();
		return list.size() > 0 ? (T)list.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void removeEntity(Class<T> entity, Integer entityId) {
		T anEntity = (T)sessionFactory.getCurrentSession().load(entity, entityId);
		if ( anEntity != null) {
			sessionFactory.getCurrentSession().delete(anEntity);
		}
	}
}
