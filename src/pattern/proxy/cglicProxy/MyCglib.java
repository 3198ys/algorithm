//package pattern.proxy.cglicProxy;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * @author: create by ys
// * @version: v1.0
// * @description:
// * @date:2020/5/27
// */
//public class MyCglib implements MethodInterceptor {
//
//    public Object getInstance(Class<?> clazz){
//        Enhancer enhancer=new Enhancer();
//        enhancer.setSuperclass(clazz);
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//
//        System.out.println("开始");
//        methodProxy.invokeSuper(o,objects);
//        System.out.println("结束");
//        return null;
//    }
//}
