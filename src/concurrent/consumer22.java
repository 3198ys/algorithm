package concurrent;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/4/22
 */
public class consumer22 implements Runnable{

  private testsuo testsuo;

  public consumer22(testsuo t){
    this.testsuo=t;
  }

  @Override
  public void run() {
    testsuo.say();
  }
}
