package pattern.single.lazy;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.single.lazy
 * 最简单的懒汉式 用到了在加载 但是 这是线程不安全的  除非像 下面那样  在方法上加上锁 但是 锁的粒度太大了也不是很好
 * @date:2020/5/21
 */
public class LazySimpleSingleton {

  private LazySimpleSingleton(){

  }

  private static LazySimpleSingleton lazySimpleSingleton=null;

  public static synchronized LazySimpleSingleton getInstance(){
    if(lazySimpleSingleton == null){
      lazySimpleSingleton=new LazySimpleSingleton();
    }
    return lazySimpleSingleton;
  }

}
