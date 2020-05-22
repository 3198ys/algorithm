package pattern.single.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
 *
 * 注册式单例 类似于 Spring中对单例的管理
 * @date:2020/5/22
 */
public class ContainerSingleton {

    private ContainerSingleton(){

    }
    private static Map<String,Object> ioc=new ConcurrentHashMap<>();

    public static Object getInstance(String className){
        synchronized (ioc){

            //加锁的原因就是 下面的那个判断不是线程安全的 多线程会创建出多个实例对象
            if(!ioc.containsKey(className)){
                Object obj=null;
                try{
                    obj=Class.forName(className);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }
}
