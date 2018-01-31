package io.khasang.demo.dao.impl;

import io.khasang.demo.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getList() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);

        criteriaQuery.select(root);

        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
    }

    @Override
    public T getById(long id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public T delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
        return entity;
    }

    @Override
    public T create(T entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }
}
