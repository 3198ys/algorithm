# 代理模式的定义
是指为其他对象提供一种代理，以控制对这个对象的访问， 代理对象再客户端和目标对象之间起到中介的作用
## 静态代理
静态代理就是说每一个目标类都要实现一个代理类，而且目标类增加方法减少方法都需要修改代理类违反开闭原则
## 动态代理
### jdk动态代理
需要目标类都实现一个借口 底层实现是通过反射来做的，具体实现就是通过动态生成一个java代码这个代码就是代理类 之后直接写成class文件  通过 反射在实例化他
### cglib
底层实现是 继承 寻找方法是用到了  fastClass找到的