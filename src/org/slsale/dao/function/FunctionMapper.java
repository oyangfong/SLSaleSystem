package org.slsale.dao.function;

import java.util.List;

import org.slsale.pojo.Authority;
import org.slsale.pojo.Function;

public interface FunctionMapper {
  public List<Function> getMainFunctionList(Authority authority);
  public List<Function> getSubFunctionList(Function function);
}
