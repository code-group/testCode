/**
 * @author: zhull
 * <P>date: 2018/1/4</P>
 * <P>description: </P>
 */
public class Anything {

    private static String aString;

    public static void main(String[] args) {

        testStatic(new Anything());

    }

    public static void testStatic(Anything anything) {
        anything.print();
    }

    public void print() {
        System.out.println("hello");
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
