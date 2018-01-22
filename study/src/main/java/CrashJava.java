import java.util.Vector;
/**
 * @author zhull
 * @date 2018/1/17</P>
 * <P>description: 覆盖toString方法，调用this.toString()会导致栈溢出</P>
 */
public class CrashJava {
    @Override
    public String toString() {
        // 这个是对的
//        return super.toString();
        // this.toString会无限调用自己的toString方法，使得栈溢出
        return "CrashJava address: " + this.toString() + "\n";
    }
    public static void main(String[] args) {
        CrashJava crashJava = new CrashJava();
        System.out.println(crashJava);

        Vector v = new Vector();
        for(int i = 0; i < 10; i++) {
            v.addElement(new CrashJava());
        }
        System.out.println(v);
    }
}