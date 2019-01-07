package org.slsale.service.function;

import java.util.List;

import org.slsale.pojo.Authority;
import org.slsale.pojo.Function;


public interface FunctionService {
	public List<Function> getMainFunctionList(Authority authority) throws Exception;
	public List<Function> getSubFunctionList(Function function) throws Exception;
}
