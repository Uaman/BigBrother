package com.big_brother.dao;

import com.big_brother.dao.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class GenericDAOImpl implements GenericDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public <T> T save(final T o){
        return (T) sessionFactory.getCurrentSession().save(o);
    }


    @Override
    public void delete(final Object object){
        sessionFactory.getCurrentSession().delete(object);
    }

    /***/
    @Override
    public <T> T get(final Class<T> type, final Long id){
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public <T> T get(final Class<T> type, final Integer id){
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    /***/
    @Override
    public <T> T merge(final T o)   {
        return (T) sessionFactory.getCurrentSession().merge(o);
    }

    /***/
    @Override
    public <T> void saveOrUpdate(final T o){
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    // Не показаны реализации getSession() и setSessionFactory()
}