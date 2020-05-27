package pattern.proxy.jdkproxy;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
 * @date:2020/5/27
 */
public class ProxyTest {

    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        Son son = new Son();
        Iperson instance = (Iperson) myProxy.getInstance(son);
        instance.say();
    }
}
