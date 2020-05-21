package pattern.factory.factoryMethod;

import pattern.factory.ICourse;
import pattern.factory.PythonCourse;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.factoryMethod
 * @date:2020/5/21
 */
public class PythonFactory implements ICourseFactory{

  @Override
  public ICourse create() {
    return new PythonCourse();
  }
}
