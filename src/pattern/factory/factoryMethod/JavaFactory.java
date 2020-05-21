package pattern.factory.factoryMethod;

import pattern.factory.ICourse;
import pattern.factory.JavaCourse;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.factoryMethod
 * @date:2020/5/21
 */
public class JavaFactory implements ICourseFactory {

  @Override
  public ICourse create() {
    return new JavaCourse();
  }
}
