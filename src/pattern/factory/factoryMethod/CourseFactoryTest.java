package pattern.factory.factoryMethod;

import pattern.factory.ICourse;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.factoryMethod
 * @date:2020/5/21
 */
public class CourseFactoryTest {

  public static void main(String[] args) {
    JavaFactory javaFactory = new JavaFactory();
    ICourse iCourse = javaFactory.create();

    ICourse iCourse1 = new PythonFactory().create();
  }
}
