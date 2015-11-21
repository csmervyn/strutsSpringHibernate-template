package org.github.mervyn.SSH.action;

import org.github.mervyn.SSH.entity.User;
import org.github.mervyn.SSH.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: UserAction
 * @Description: UserAction,主要用来接收用户的请求，调用service的相应处理函数，然后返回相应的页面
 * @author: Mervyn
 * @Time: 2015年11月20日 下午8:29:05
 */
@Controller("userAction")
@Scope(value="prototype")
public class UserAction extends ActionSupport {
	/**
	 * @Filed serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	@Autowired(required=true)
	@Qualifier("userService")
	private IUserService userService;
	
	private User user;
	
	
	public String addUser(){
		userService.save(user);
		return SUCCESS;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
