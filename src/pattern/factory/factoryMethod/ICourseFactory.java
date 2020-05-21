package pattern.factory.factoryMethod;

import pattern.factory.ICourse;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.factoryMethod
 * 工厂方法  是指创建一个对象的接口 但让实现这个接口的类在决定实例化哪个类，工厂方法让类的实例化推迟到了 子类中进行
 * @date:2020/5/21
 */
public interface ICourseFactory {


  public ICourse create();
}
