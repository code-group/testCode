import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author zhull
 * @date 2018/4/16
 * <P>动态类型语言支持</P>
 * MethodType, MethodHandle能够调用超类的方法
 * 底层是invokeVirtual指令
 */
public class InvokeVirtual {
    public static void main(String[] args) {
        Son son = new Son();
        son.thinking();
    }

}

class GrandFather {
    void thinking() {
        System.out.println("I am grandfather");
    }
}

class Father {
    void thinking() {
        System.out.println("I am father");
    }
}

class Son {
    /**
     * 调用父类的父类的方法
     */
    void thinking() {
        MethodType mt = MethodType.methodType(void.class);
        try {
            MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
            mh.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}