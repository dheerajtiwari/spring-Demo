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
import org.hibernate.Hibernate;
import org.springframework.orm.hibernate4.HibernateTemplate;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

  @Autowired
  SessionFactory sessionFactory;
 
  private HibernateTemplate template;
 
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }
  
  

  @Override
  public List<User> list() {
    return  sessionFactory.getCurrentSession().createQuery(" from User ").list();
  }

  @Override
  public boolean delete(User user) {
    try {
      template.delete(user);
    }catch (Exception exception){
      return false;
    }
    return true;
  }

  @Override
  public boolean saveOrUpdate(User user) {
    template.save(user);
    return true;
  }

  @Override
  public User findUser(int id) {
    return template.get(User.class, id);
    
  }
}
