package pattern.factory;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory
 * @date:2020/5/21
 */
public class PythonCourse implements ICourse{

  @Override
  public void record() {
    System.out.println("录制Python课程");
  }
}
