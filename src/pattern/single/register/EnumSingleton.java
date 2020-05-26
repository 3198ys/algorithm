package pattern.single.register;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.single.register
 * 使用枚举类来做单列
 *
 * 使用枚举类的好处就是本人他 构造方法的执行是在 静态代码块中的 的 这样 他的构造方法只能被执行一会 是线程安全的 这样 user就只会呗实例化一会了
 * 而且  枚举类是不能被反射的 反射有特殊限制 如果是枚举类就会抛异常
 *  之后就是 通过序列化也不会 出现创建多个 对象 其他的 单例序列化的时候就会反射执行他的构造方法 枚举比较特殊不会的 是回去jvm中找是否已经有枚举了
 * @date:2020/5/22
 */
public enum EnumSingleton {

    INSTANCE;
    private User user;
    private EnumSingleton(){

        user=new User();
    }

    public User getInstance(){
        return user;
    }
}
