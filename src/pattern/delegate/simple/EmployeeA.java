package pattern.delegate.simple;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.delegate.simple
 * @date:2020/6/2
 */
public class EmployeeA implements IEmployee{

  @Override
  public void doing(String command) {
    System.out.println("aa");
  }
}
