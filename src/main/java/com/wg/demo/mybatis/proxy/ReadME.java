package com.wg.demo.mybatis.proxy;

/**
 * @author wg
 * @date 2021/3/11
 */
public class ReadME {
    /**
     * 超全mybatis动态带来详解
     *
     * JDK动态代理分为三个步骤
     * 1、定义代理接口
     * 2、定义代理接口实现类
     * 3、定义动态代理调用处理器
     *
     * 调用动态代理的方法调用链
     *
     * Mapper层的JDBC操作
     * 装载Mysql驱动
     *Class.forName(driveName);
     * 获取连接
     *con =DriverManager.getConnection(url,user,pass);
     * // 创建Statement
     Statement state = con.createStatement();
     * // 构建SQL语句
     String stuQuerySqlStr = "SELECT * FROM STUDENT";
     * // 执行SQL返回结果
     ResultSet result = state.executeQuery(stuQuerySqlStr);
     *...
     *
     *所以 Mybatis 结合项目痛点，应运而生，怎么做的呢
     * 1 、将所有和 JDBC 交互的操作，底层采用 JDK 动态代理封装，使用者只需要自定义 Mapper 和 .xml 文件
     * 2 、SQL 语句定义在 .xml 文件或者 Mapper 中，项目启动时通过解析器解析 SQL 语句组装为 Java 中的对象
     *
     * 解析器分为多种，因为 Mybatis 中不仅有静态语句，同时也包含动态 SQL 语句
     *
     * 这也就是为什么 Mapper 接口不需要实现类，因为都已经被 Mybatis 通过动态代理封装了，如果每个 Mapper 都来一个实现类，臃肿且无用。经过这一顿操作，展示给我们的就是项目里用到的 Mybatis 框架
     *
     * 上面铺垫这么久，终于要到主角了，为什么 Mybatis Mapper 接口没有实现类也可以实现动态代理
     *
     * 有实现类接口和无实现类接口产生的动态代理类有什么区别
     *
     * 有实现类接口是对 InvocationHandler#invoke 方法调用，invoke 方法通过反射调用被代理对象（SubjectImpl）方法（sayHello）
     * 无实现类接口则是仅对 InvocationHandler#invoke 产生调用。所以有实现类接口返回的是被代理对象接口返回值，而无实现类接口返回的仅是 invoke 方法返回值
     *
     * 现在第一个问题答案已经浮现，Mapper 没有实现类，所有调用 JDBC 等操作都是在 Mybatis InvocationHandler 实现的
     *
     */
}
