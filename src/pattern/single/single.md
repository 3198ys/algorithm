# 单例模式的有点

* 在内存中只有一个实例，减少了内存开销
* 可以避免对资源的多重占用
* 设置全局访问点，严格控制访问
# 单例模式的缺点

* 没有接口，扩展困难
* 如果要扩展单例对象，只有修改代码，没有其他途径
# 单例模式的一些特点

* 私有化构造器
* 保证线程安全
* 延迟加载
* 防止序列化和反序列化破坏单例
* 防御反射攻击单例