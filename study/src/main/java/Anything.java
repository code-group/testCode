import java.util.Enumeration;
import java.util.Vector;

/**
 * @author zhull
 * @date 2018/1/16</P>
 * <P>description: </P>
 */
public class Anything {

    public static void main(String[] args) throws Exception{
        Vector v = new Vector();
        for(int i = 0; i < 10; i++ )
            v.addElement(new Int(i));
        System.out.println("v: " + v);
        Vector v2 = (Vector)v.clone();
        // Increment all v2's elements:
        for(Enumeration e = v2.elements();
            e.hasMoreElements(); )
            ((Int)e.nextElement()).increment();
        // See if it changed v's elements:
        System.out.println("v: " + v);

        Int i = new Int(1);
        Int i1 = (Int)i.clone();

    }
}

class Int implements Cloneable {
    private int i;
    public Int(int ii) { i = ii; }
    public void increment() { i++; }
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}