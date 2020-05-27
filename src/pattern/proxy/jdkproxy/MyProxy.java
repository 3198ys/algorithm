package pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
 * @date:2020/5/27
 */
public class MyProxy implements InvocationHandler {
    private Object object;

    public  Object getInstance(Object object){
        this.object=object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hello");
        method.invoke(object,args);
        System.out.println("bbbb");
        return null;
    }
}
