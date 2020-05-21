package pattern.single.lazy;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.single.lazy
 * 使用静态内部类来实现的 单列 是比较好的一种方法 而且 他是懒汉式的 用到才加载而且还是线程安全的
 * @date:2020/5/22
 */
public class LazyInnerClassSingleton {

  private LazyInnerClassSingleton(){

    /**
     * 写下面的那个方法就是为了 防止通过反射来破坏这个单列
     */
    if(LazeHolder.LAZY!=null){
      throw  new RuntimeException("不允许创建多个实例");
    }
  }

  public static final LazyInnerClassSingleton getInstance(){
    return LazeHolder.LAZY;
  }

  private static class LazeHolder{
    private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
  }
}
