package jichu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class refelect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class<?> aClass = people.class;
        Constructor<?> constructor = aClass.getConstructor(String.class,String.class);
        Object aa = constructor.newInstance("aa","aa");
//        Object aa = aClass.newInstance();
//        Method sayHi = aClass.getMethod("sayHi", String.class);
//        sayHi.invoke(aa, "as");
//        Method saya = aClass.getDeclaredMethod("saya", String.class);
//        saya.setAccessible(true);
//        String hhhh = (String)saya.invoke(aa, "hhhh");
//        System.out.printf(hhhh);

        Field[] fields = aClass.getFields();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(aa,"ysysys");
        Method getName = aClass.getMethod("getName");
        String invoke = (String)getName.invoke(aa);
        System.out.printf(invoke);
        for(Field f:fields){

            f.setAccessible(true);
            System.out.printf(f.getName());
        }

    }
}
