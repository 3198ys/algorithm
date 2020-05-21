package pattern.factory.simpleFactrory;

import pattern.factory.ICourse;
import pattern.factory.JavaCourse;
import pattern.factory.PythonCourse;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.simpleFactrory
 *
 * 这个是简单工厂方法 简单工厂方法就是说 好处就是客户端不需要关心创建对象的具体实现 坏处就是你每添加一种类型的对象的时候都需要去修改工厂内部的方法
 * @date:2020/5/21
 */
public class CourseFactory {

  public ICourse create(String name){
    if("java".equals(name)){

      return new JavaCourse();
          }
    else if("python".equals(name)){
      return new PythonCourse();
    }else{
      return null;
    }
  }


  public ICourse createV2(Class<? extends ICourse> clazz){
    if(clazz!=null){
      try {
        return clazz.newInstance();
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
