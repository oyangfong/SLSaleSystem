package org.slsale.service.user;

import java.util.List;

import org.slsale.pojo.User;

public interface UserService {
	/**
	 * findAll
	 */
	public List<User> findAll() throws Exception;
	
	/**用户登录
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
}
