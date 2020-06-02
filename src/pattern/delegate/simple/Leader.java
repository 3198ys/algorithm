package pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 简单的委派模式 上级给下级分配任务  下级 利用了一个策略模式 自己理解的策略模式就是可以避免ifelse
 * @date:2020/6/2
 */
public class Leader implements IEmployee {

  private Map<String,IEmployee> resultMap=new HashMap<>();

  public Leader(){
    resultMap.put("a",new EmployeeA());
    resultMap.put("b",new EmployeeB());
  }
  @Override
  public void doing(String command) {
    resultMap.get(command).doing(command);
  }
}
