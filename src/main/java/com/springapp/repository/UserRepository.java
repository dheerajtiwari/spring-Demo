/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.repository;

import com.springapp.entities.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository {

  public List<User> list();

  public boolean delete(User user);

  public boolean saveOrUpdate(User user);

  public User findUser(int id);

}
