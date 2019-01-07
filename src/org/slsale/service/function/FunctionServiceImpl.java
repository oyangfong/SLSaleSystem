package org.slsale.service.function;

import java.util.List;

import javax.annotation.Resource;

import org.slsale.dao.function.FunctionMapper;
import org.slsale.dao.user.UserMapper;
import org.slsale.pojo.Authority;
import org.slsale.pojo.Function;
import org.slsale.pojo.User;
import org.springframework.stereotype.Service;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	@Resource
    private FunctionMapper functionMapper;

	@Override
	public List<Function> getMainFunctionList(Authority authority)
			throws Exception {
		// TODO Auto-generated method stub
		return functionMapper.getMainFunctionList(authority);
	}

	@Override
	public List<Function> getSubFunctionList(Function function)
			throws Exception {
		// TODO Auto-generated method stub
		return functionMapper.getSubFunctionList(function);
	}
	
}
