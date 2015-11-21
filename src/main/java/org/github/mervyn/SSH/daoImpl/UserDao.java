package org.github.mervyn.SSH.daoImpl;

import org.github.mervyn.SSH.dao.IUserDao;
import org.github.mervyn.SSH.entity.User;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDao extends BaseDao<User, Integer> implements  IUserDao{

}
