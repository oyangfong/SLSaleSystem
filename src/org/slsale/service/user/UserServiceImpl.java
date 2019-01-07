package org.slsale.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.slsale.dao.user.UserMapper;
import org.slsale.pojo.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
    private UserMapper userMapper;
	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	@Override
	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getLoginUser(user);
	}
}
