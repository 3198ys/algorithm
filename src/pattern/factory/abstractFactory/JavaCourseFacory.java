package pattern.factory.abstractFactory;

import pattern.factory.ICourse;
import pattern.factory.factoryMethod.ICourseFactory;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.abstractFactory
 *
 * 创建python系列的产品也是同理
 * @date:2020/5/21
 */
public class JavaCourseFacory implements CourseFactory {


  @Override
  public INote createNote() {
    return new JavaNote();
  }

  @Override
  public IVideo createVideo() {
    return new JavaVideo();
  }
}
