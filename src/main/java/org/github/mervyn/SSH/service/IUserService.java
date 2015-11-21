package org.github.mervyn.SSH.service;

import org.github.mervyn.SSH.entity.User;

/**
 * @ClassName: IUserService
 * @Description: 对UserService封装的接口，这里仅写一个save方法的接口，作为演示。项目中可添加实际的接口。
 * @author: Mervyn
 * @Time: 2015年11月20日 下午2:23:20
 */
public interface IUserService {
	/**
	 * @Title: save
	 * @Description: 保存用户
	 * @param: @param user
	 * @return: void
	 * @throws:
	 */
	void save(User user);

}
