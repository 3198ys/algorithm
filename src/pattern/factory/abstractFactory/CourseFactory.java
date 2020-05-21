package pattern.factory.abstractFactory;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.factory.abstractFactory
 *
 * 抽象工厂方法 是spring中 应用的最广泛的方法
 *
 * 适用于创建一系列产品的时候用的
 *
 * 最上层的方法也可以是 抽象类可以有自己的具体的公共实现
 *
 * @date:2020/5/21
 */
public interface CourseFactory {
  INote createNote();

  IVideo createVideo();
}
