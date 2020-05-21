package pattern.single.hungry;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.single.hungry
 * 饿汉式单列模式  就是还没有使用 的时候就将其对象创建完
 * 线程安全的
 * 坏处就是 浪费资源
 * @date:2020/5/21
 */
public class HungrySingleton {

  private  static final HungrySingleton hungrySingleton=new HungrySingleton();

  private HungrySingleton(){

  }

  public static HungrySingleton getInstance(){
    return hungrySingleton;
  }
}
