package pattern.proxy.cglicProxy;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
 * @date:2020/5/27
 */
public class CglibTest {
    public static void main(String[] args) {
        MyCglib myCglib = new MyCglib();

        Consumer instance = (Consumer) myCglib.getInstance(Consumer.class);
        instance.say();

    }
}
