/**
 * @author zhull
 * @date 2018/1/16</P>
 * <P>description: 内部类</P>
 */
public class InnerClass extends WithInner.Inner {
    private class PContents {
        private int i = 11;
        public int value() { return i; }
    }

    public static void main(String[] args) {
        InnerClass anything = new InnerClass(new WithInner());
        // 这是对的
        PContents pContents = anything.new PContents();

        // 这是错的，内部类需要拥有封装类的引用，封装类的作用是创建内部类
//        PContents pContents = new PContents();
    }

    // 这个有问题 no enclosing instance of type is in scope
//    InnerClass() {
//
//    }

    InnerClass(WithInner withInner) {
        withInner.super();
    }
}

class WithInner {
    class Inner {}
}

