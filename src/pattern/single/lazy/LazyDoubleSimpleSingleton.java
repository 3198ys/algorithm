package pattern.single.lazy;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.single.lazy
 * @date:2020/5/22
 */
public class LazyDoubleSimpleSingleton {
  private volatile static LazyDoubleSimpleSingleton lazyDoubleSimpleSingleton=null;

  public static LazyDoubleSimpleSingleton getInstance(){
    if(lazyDoubleSimpleSingleton == null){
      synchronized (LazyDoubleSimpleSingleton.class){
        if(lazyDoubleSimpleSingleton == null){
          lazyDoubleSimpleSingleton=new LazyDoubleSimpleSingleton();

          //指令重排序的问题 创建对象的顺序
          //1 分配内存给这个对象
          //2 初始化对象
          //3引用指向对象的地址  这里第二步和第三步是会发生指令重排序的  但是我认为 加上volatile的原因是因为 想让其他线程尽快的看见这个对象被创建了
          //用户使用
        }
      }
    }
    return lazyDoubleSimpleSingleton;
  }

}
