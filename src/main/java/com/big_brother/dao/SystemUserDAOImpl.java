package com.big_brother.dao;

import com.big_brother.models.SystemUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by denysburlakov on 23.04.17.
 */
@Repository
public class SystemUserDAOImpl implements SystemUserDAO {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public SystemUser getSystemUserByLogin(String login) {
        return (SystemUser) sessionFactory.getCurrentSession().createQuery("select systemUser from com.big_brother.models.SystemUser systemUser where systemUser.login = ?").setString(0, login).list().get(0);
        //return sessionFactory.getCurrentSession().createSQLQuery("select city_id from analysis_cities where analysis_id = ?").setInteger(0, analysisId).list();
    }
}
