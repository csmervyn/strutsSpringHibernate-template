package org.github.mervyn.SSH.serviceImpl;

import org.github.mervyn.SSH.dao.IUserDao;
import org.github.mervyn.SSH.entity.User;
import org.github.mervyn.SSH.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: UserService
 * @Description: IUserService的具体的实现类，该类仅做一个简单的演示，实际中service中应该是业务逻辑的核心（复杂）
 * @author: Mervyn
 * @Time: 2015年11月20日 下午2:27:02
 */
@Service("userService")
public class UserService implements IUserService {
	/**
	 * @Filed userDao : 自动注入IUserDao接口的实现类
	 */
	@Autowired(required=true)
	@Qualifier("userDao")
	private IUserDao userDao;

	/*
	 *(非 Javadoc) 
	 * <p>Title: save</p> 
	 * <p>Description: 保存User类的对象</p> 
	 * @param user 
	 * @see org.github.mervyn.SSH.service.IUserService#save(org.github.mervyn.SSH.entity.User) 
	 */
	@Override
	@Transactional  //使用声明式事物
	public void save(User user) {
		userDao.save(user);
	}

}
