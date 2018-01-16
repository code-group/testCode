package statics;

/**
 * <P>created by zhull, on 2018/1/12</P>
 * <P>description: static初始化</P>
 *
 * java类加载顺序，首先加载类，执行static变量初始化，接下来执行对象的创建
 * 把内部类看成外部类的非静态成员，它的初始化必须在外部类对象创建后以后进行，
 * 要加载内部类必须在实例化外部类之后完成 ，而java虚拟机要求所有的静态变量必须在对象创建之前完成
 *
 **/
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        // (1)
        Cups.c1.f(99);
    }
    // (2)
//    static Cups x = new Cups();
//    static Cups y = new Cups();

    // 这是有问题的
//    class Cups {
//        static Cup c1;
//        static Cup c2;
//        static {
//            c1 = new Cup(1);
//            c2 = new Cup(2);
//        }
//        Cups() {
//            System.out.println("Cups()");
//        }
//    }
}

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }

}

class Cups {
    static Cup c1;
    static Cup c2;
    static {
        c1 = new Cup(1);
        c2 = new Cup(2);
    }
    Cups() {
        System.out.println("Cups()");
    }
}