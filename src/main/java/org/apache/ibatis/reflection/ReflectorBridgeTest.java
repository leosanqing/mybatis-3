package org.apache.ibatis.reflection;

import java.lang.reflect.Method;

/**
 * @Author: rtliu
 * @Date: 2020/5/8 上午10:49
 * @Package: org.apache.ibatis.reflection
 * @Description: Reflector中的 addUniqueMethods中 有个isBridge方法测试
 * @Version: 1.0
 */
public class ReflectorBridgeTest {
  public static void main(String[] args) throws Exception {
    AClass obj = new AClass();
    Method func = AClass.class.getMethod("func", String.class);
    func.invoke(obj, "AAA");
    System.out.println(func.isBridge());
    func = AClass.class.getMethod("func", Object.class);
    func.invoke(obj, "BBB");
    System.out.println(func.isBridge());

  }

}
interface AInterface<T> {
  void func(T t);
}
class AClass implements AInterface<String> {
  @Override
  public void func(String s) {
    System.out.println(s);
  }
}
