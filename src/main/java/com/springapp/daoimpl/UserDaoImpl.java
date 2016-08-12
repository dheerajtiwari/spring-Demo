package com.springapp.daoimpl;

import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.logging.Logger;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

  @Autowired
  SessionFactory sessionFactory;

  @Override
  public List<User> list() {
    return  sessionFactory.getCurrentSession().createQuery(" from User ").list();
  }

  @Override
  public boolean delete(User user) {
    try {
      sessionFactory.getCurrentSession().delete(user);
    }catch (Exception exception){
      return false;
    }
    return true;
  }

  @Override
  public boolean saveOrUpdate(User user) {

    Session session;
    try {
      session = sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      session = sessionFactory.openSession();
    }
    Logger.getAnonymousLogger().info("session = "+session);
    System.out.println(session);



    sessionFactory.getCurrentSession().saveOrUpdate(user);
    return true;
  }
}
